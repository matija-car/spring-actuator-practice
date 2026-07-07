package com.actuator.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final Counter helloRequestCounter;

    public TestController(MeterRegistry registry) {
        this.helloRequestCounter = registry.counter("hello.request.counter");
    }

    @GetMapping("/hello")
    public String hello() {
        helloRequestCounter.increment();
        return "Hello from the test controller!";
    }
}