package com.springboot.blog.Springbootblogrestapi.repository;

import com.springboot.blog.Springbootblogrestapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
