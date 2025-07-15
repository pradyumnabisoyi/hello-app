package com.bisoyi.helloapp.web.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@Tag(name = "Hello Resource", description = "Hello APIs")
public class HelloResource {
    @Operation(summary = "Say Hello", description = "Say Hello api call for testing purpose")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "returns hello world")
    })
    @GetMapping("/world")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello world..");
    }
}
