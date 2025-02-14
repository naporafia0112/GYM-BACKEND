package com.app.gym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class GymApplication {

    private static final Logger logger = LoggerFactory.getLogger(GymApplication.class);

    public static void main(String[] args) {
        try {
            SpringApplication.run(GymApplication.class, args);
            logger.info("✅ Gym Application has started successfully!");
        } catch (Exception e) {
            logger.error("❌ Error starting Gym Application: ", e);
        }
    }
}