package org.example;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
public class SpringBoot {
    public static void main(String[] args) {
        System.out.print("Hello Spring!");
        SpringApplication.run(SpringBoot.class, args);
    }
}
