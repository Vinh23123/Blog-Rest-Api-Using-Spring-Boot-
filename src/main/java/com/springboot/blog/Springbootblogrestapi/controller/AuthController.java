package com.springboot.blog.Springbootblogrestapi.controller;

import com.springboot.blog.Springbootblogrestapi.payload.JwtAuthResponse;
import com.springboot.blog.Springbootblogrestapi.payload.LoginDto;
import com.springboot.blog.Springbootblogrestapi.payload.SignupDto;
import com.springboot.blog.Springbootblogrestapi.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(
        name = "CRUD REST APIs for Auth Resource"
)
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // build Login REST API
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JwtAuthResponse> login (@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    // build register REST API
    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<String> register (@RequestBody SignupDto signupDto){
        String response = authService.register(signupDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
