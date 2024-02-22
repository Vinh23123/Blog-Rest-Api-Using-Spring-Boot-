package com.springboot.blog.Springbootblogrestapi.service;

import com.springboot.blog.Springbootblogrestapi.entity.Post;
import com.springboot.blog.Springbootblogrestapi.payload.PostDto;
import com.springboot.blog.Springbootblogrestapi.payload.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo,
                             int pageSize,
                             String sortBy,
                             String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

    List<PostDto> getPostByCategory(Long categoryId);
}
