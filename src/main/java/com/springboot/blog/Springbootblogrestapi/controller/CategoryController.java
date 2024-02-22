package com.springboot.blog.Springbootblogrestapi.controller;

import com.springboot.blog.Springbootblogrestapi.payload.CategoryDto;
import com.springboot.blog.Springbootblogrestapi.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Tag(
        name = "CRUD REST APIs for Category Resource"
)
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    // build Add Category REST API
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto savedCategory =  categoryService.addCategory(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }
    // build Get Category REST API
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable("categoryId") Long categoryId){
        CategoryDto categoryDto = categoryService.getCategory(categoryId);
        return ResponseEntity.ok(categoryDto);
    }
    // build get all Categories REST API
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
    // build Put (update) Category REST API
    @PutMapping("/{categoryID}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryDto> updatedCategory(@RequestBody CategoryDto categoryDto,
                                                       @PathVariable("categoryID") Long categoryId){
        return ResponseEntity.ok(categoryService.updateCategory(categoryDto, categoryId ));
    }

    // build Delete Category REST API
    @DeleteMapping("{categoryId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deletedCategory(@PathVariable("categoryId") Long categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted successfully");
    }
}
