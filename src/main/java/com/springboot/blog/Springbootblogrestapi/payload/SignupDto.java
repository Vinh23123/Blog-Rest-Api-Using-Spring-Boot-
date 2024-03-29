package com.springboot.blog.Springbootblogrestapi.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {
    private String name;
    private String username;
    private String email;
    private String password;

}
