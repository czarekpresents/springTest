package com.project.learning.controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Greetings controller
 */
@RestController
@RequestMapping("/greetings")
public class GreetingsController {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") @NotNull String name) {
        return String.format("Hello %s!", name.toUpperCase());
    }

    @GetMapping("/bye")
    public String bye(@RequestParam(value = "name", defaultValue = "World") @NotNull String name) {
        return String.format("Goodbye %s!", name.toUpperCase());
    }
}
