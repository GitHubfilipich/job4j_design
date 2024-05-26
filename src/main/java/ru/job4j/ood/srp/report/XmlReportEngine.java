package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.function.Predicate;

class XmlReportEngine extends ReportEngine {
    private Marshaller marshaller;

    public XmlReportEngine(Store store, DateTimeParser<Calendar> dateTimeParser) {
        super(store, dateTimeParser);
        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            marshaller = context.createMarshaller();
            marshaller.setAdapter(new CalendarXmlAdapter());
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static class CalendarXmlAdapter extends XmlAdapter<String, Calendar> {
        @Override
        public String marshal(Calendar v) throws Exception {
            return String.format("%1$td:%1$tm:%1$tY %1$tR", v);
        }

        @Override
        public Calendar unmarshal(String v) throws Exception {
            return null;
        }
    }

    private static class AnnotatedEmployee {
        @XmlElement
        private String name;

        @XmlElement
        @XmlJavaTypeAdapter(CalendarXmlAdapter.class)
        private Calendar hired;

        @XmlElement
        @XmlJavaTypeAdapter(CalendarXmlAdapter.class)
        private Calendar fired;

        @XmlElement
        private double salary;

        public AnnotatedEmployee(Employee employee) {
            this.name = employee.getName();
            this.hired = employee.getHired();
            this.fired = employee.getFired();
            this.salary = employee.getSalary();
        }
    }

    @XmlRootElement(name = "employees")
    private static class Employees {
        @XmlElement(name = "employee")
        private List<AnnotatedEmployee> annotatedEmployees = new LinkedList<>();

        public Employees() {
        }

        Employees(List<Employee> employees) {
            employees.forEach(employee -> annotatedEmployees.add(new AnnotatedEmployee(employee)));
        }
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            try {
                marshaller.marshal(new Employees(store.findBy(filter)), writer);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            xml = writer.getBuffer().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;
    }
}
