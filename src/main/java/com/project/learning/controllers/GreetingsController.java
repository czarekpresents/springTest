package com.project.learning.controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Greetings controller
 */
@RestController
@RequestMapping("/greetings")
public class GreetingsController {

    @PostMapping("/hello/{name}")
    public String hello(@PathVariable @NotNull String name) {
        return String.format("Hello %s!", name.toUpperCase());
    }

    @PostMapping("/bye/{name}")
    public String bye(@PathVariable @NotNull String name) {
        return String.format("Goodbye %s!", name.toUpperCase());
    }
}
