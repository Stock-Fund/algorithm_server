package org.example;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.example.socket.proto.java.Algorithm.Stock;
@SpringBootApplication
public class SpringBoot {
    public static void main(String[] args) {

        var stock = Stock.newBuilder();
        stock.setName("John");
        stock.setCode(603888);
        stock.build();

        System.out.print("Hello Spring!");
        SpringApplication.run(SpringBoot.class, args);
    }
}
