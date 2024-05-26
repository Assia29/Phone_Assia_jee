package com.example.phone_assia_jee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication  ( exclude = { SecurityAutoConfiguration.class })
public class PhoneAssiaJeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneAssiaJeeApplication.class, args);
    }

}
