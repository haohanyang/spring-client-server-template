package com.example.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello world");
        System.exit(0);
    }
}
