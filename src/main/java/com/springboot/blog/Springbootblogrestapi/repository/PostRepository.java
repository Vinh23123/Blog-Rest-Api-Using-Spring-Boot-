package com.springboot.blog.Springbootblogrestapi.repository;

import com.springboot.blog.Springbootblogrestapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByCategoryId(Long id);
}
