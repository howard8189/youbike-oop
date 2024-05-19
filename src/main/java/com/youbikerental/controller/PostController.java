package com.youbikerental.controller;

import com.youbikerental.model.Post;
import com.youbikerental.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a RESTful controller
@RequestMapping("/api/posts") // Base URL for all handlers in this controller
public class PostController {
    @Autowired // Automatically injects PostService instance
    private PostService postService;

    // Create a new post
    @PostMapping // Maps HTTP POST requests onto this method
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post newPost = postService.createPost(post);
        return ResponseEntity.ok(newPost); // Returns the newly created post with 200 OK
    }

    // Get all posts
    @GetMapping // Maps HTTP GET requests onto this method
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.findAllPosts();
        return ResponseEntity.ok(posts); // Returns all posts with 200 OK
    }

    // Get post by ID
    @GetMapping("/{id}") // Maps HTTP GET requests for individual posts onto this method
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.findPostById(id);
        return post != null ? ResponseEntity.ok(post) : ResponseEntity.notFound().build(); // Returns the found post or 404 Not Found
    }

    // Update post information
    @PutMapping("/{id}") // Maps HTTP PUT requests onto this method
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        Post updatedPost = postService.updatePost(id, post);
        return updatedPost != null ? ResponseEntity.ok(updatedPost) : ResponseEntity.notFound().build(); // Returns the updated post or 404 Not Found
    }

    // Delete a post
    @DeleteMapping("/{id}") // Maps HTTP DELETE requests onto this method
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok().build(); // Returns 200 OK on successful deletion
    }
}
