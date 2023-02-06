package ru.mrsu.test.project.clients.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/helloClient")
    public String getHelloMessage(@RequestParam String name) {
        return "Hello, " + name;
    }

    @GetMapping("/clients/{id}")
    @ResponseBody
    public String getID(@PathVariable String id){
        return "ID: " + id;
    }
}
