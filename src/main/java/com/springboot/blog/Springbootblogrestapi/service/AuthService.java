package com.springboot.blog.Springbootblogrestapi.service;

import com.springboot.blog.Springbootblogrestapi.payload.LoginDto;
import com.springboot.blog.Springbootblogrestapi.payload.SignupDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(SignupDto signupDto);
}
