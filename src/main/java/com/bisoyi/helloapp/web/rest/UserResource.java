package com.bisoyi.helloapp.web.rest;

import com.bisoyi.helloapp.service.UserService;
import com.bisoyi.helloapp.service.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/uers")
@Tag(name = "User Resource", description = "User APIs")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;

    @Operation(summary = "Create a new User")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "returns User details")
    })
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @Operation(summary = "Update an existing User")
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    description = "if update fails throw exception")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Integer id, @RequestBody UserDTO user) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @Operation(summary = "Login with email and password")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "returns User details")
    })
    @PostMapping("/login")
    public ResponseEntity<UserDTO> LoginUser(@RequestBody UserDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.login(user));
    }
}
