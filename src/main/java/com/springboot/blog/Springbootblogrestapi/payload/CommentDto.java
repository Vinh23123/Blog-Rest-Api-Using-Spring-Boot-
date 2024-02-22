package com.springboot.blog.Springbootblogrestapi.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class CommentDto {
    private long id;
    // name should not be empty or null
    @NotEmpty(message = "Name should not be bull or empty")
    private String name;
    // email should not be null or empty
    // email field validation
    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;
    // comment body should not be null or empty
    // comment body must be minimum 10 characters
    @NotEmpty
    @Size(min = 10, message = "comment body must be minimum 10 characters")
    private String body;
}
