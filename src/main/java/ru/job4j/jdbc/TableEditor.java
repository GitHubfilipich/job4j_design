package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private final Properties properties;

    private TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void executeSQL(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private void createTable(String tableName) throws SQLException {
        executeSQL(String.format("CREATE TABLE IF NOT EXISTS %s();", tableName));
    }

    private void dropTable(String tableName) throws SQLException {
        executeSQL(String.format("DROP TABLE IF EXISTS %s;", tableName));
    }

    private void addColumn(String tableName, String columnName, String type) throws SQLException {
        executeSQL(String.format("ALTER TABLE IF EXISTS %s ADD COLUMN IF NOT EXISTS %s %s;",
                tableName, columnName, type));
    }

    private void dropColumn(String tableName, String columnName) throws SQLException {
        executeSQL(String.format("ALTER TABLE IF EXISTS %s DROP COLUMN IF EXISTS %s;",
                tableName, columnName));
    }

    private void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        executeSQL(String.format(String.format("ALTER TABLE IF EXISTS %s RENAME COLUMN %s TO %s;",
                tableName, columnName, newColumnName)));
    }

    private String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    private static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
        }
        return properties;
    }

    private void initConnection() throws SQLException, ClassNotFoundException {
        Class.forName(properties.getProperty("driver_class"));
        connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password"));
    }

    private void printTableScheme(String tableName) throws Exception {
        System.out.println(getTableScheme(tableName));
    }

    public static void main(String[] args) throws Exception {
        try (TableEditor editor = new TableEditor(getProperties())) {
            String tableName = "my_table";
            editor.createTable(tableName);
            editor.printTableScheme(tableName);

            editor.addColumn(tableName, "id", "SERIAL PRIMARY KEY");
            editor.addColumn(tableName, "name", "text");
            editor.printTableScheme(tableName);

            editor.renameColumn(tableName, "name", "first_name");
            editor.printTableScheme(tableName);

            editor.dropColumn(tableName, "first_name");
            editor.printTableScheme(tableName);

            editor.dropTable(tableName);
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
