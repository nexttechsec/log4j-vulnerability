package org.playground.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
    private static final String API_VERSION_HEADER_NAME = "X-Api-Version";
    private static final Logger LOGGER = LogManager.getLogger("HelloWorldController");

    @GetMapping
    public ResponseEntity getHelloWorldMessage(@RequestHeader(API_VERSION_HEADER_NAME) String apiVersion) {
        LOGGER.info("Received a request for API version " + apiVersion);

        final Map<String, String> message = new HashMap<>();
        message.put("message", "Hello world");

        return ResponseEntity.ok(message);
    }
}
