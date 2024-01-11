package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);

        byte byteValue = 1;
        short shortValue = 10;
        int intValue = 100;
        long longValue = 1000L;
        float floatValue = 1.5F;
        double doubleValue = 2.7;
        char charValue = 'a';
        boolean booleanValue = true;
        LOG.debug("byteValue : {}", byteValue);
        LOG.debug("shortValue : {}", shortValue);
        LOG.debug("intValue : {}", intValue);
        LOG.debug("longValue : {}", longValue);
        LOG.debug("floatValue : {}", floatValue);
        LOG.debug("doubleValue : {}", doubleValue);
        LOG.debug("charValue : {}", charValue);
        LOG.debug("booleanValue : {}", booleanValue);
    }
}
