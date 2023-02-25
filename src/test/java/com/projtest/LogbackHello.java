package com.projtest;

import com.proj.common.base.APISetUp;

public class LogbackHello extends APISetUp {
    //private static final Logger logger = LoggerFactory.getLogger(LogbackHello.class);
    public static void main(String[] args) {
        logger.trace("Hello World!");

        String name = "Abhijit";
        logger.debug("Hi, {}", name);
        logger.info("Welcome to the HelloWorld example of Logback.");
        logger.warn("Dummy warning message.");
        logger.error("Dummy error message.");
        logger.info("-------------- TEST TERMINATED ----------------");
    }
}