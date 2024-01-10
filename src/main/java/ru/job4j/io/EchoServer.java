package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile("msg=.+ ");
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String string = input.readLine();
                    if (string != null && !string.isEmpty()) {
                        Matcher matcher = pattern.matcher(string);
                        if (matcher.find()) {
                            switch (matcher.group()) {
                                case "msg=Hello " -> output.write("Hello".getBytes());
                                case "msg=Exit " -> {
                                    output.write("Server closed".getBytes());
                                    server.close();
                                }
                                default -> output.write("What".getBytes());
                            }
                        }
                    }
                    output.flush();
                }
            }
        }
    }
}
