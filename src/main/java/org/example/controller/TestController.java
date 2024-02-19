package org.example.controller;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@SpringBootApplication
public class TestController {
    @RequestMapping("/")
    public String home(){
        return "Hello Controller!!!";
    }
}
