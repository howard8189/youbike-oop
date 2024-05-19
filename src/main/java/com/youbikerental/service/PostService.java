package com.youbikerental.service;

import com.youbikerental.model.Post;
import com.youbikerental.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service // Marks this class as a Spring service
public class PostService {
    @Autowired // Automatically injects PostRepository instance
    private PostRepository postRepository;

    // Create a new post and save it to the database
    public Post createPost(Post post) {
        return postRepository.save(post); // Saves the Post object to the database
    }

    // Retrieve all posts from the database
    public List<Post> findAllPosts() {
        return postRepository.findAll(); // Returns all Post records from the database
    }

    // Find a post by ID
    public Post findPostById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElse(null); // Returns the post if found, or null otherwise
    }

    // Update post information based on ID
    public Post updatePost(Long id, Post updatedPost) {
        return postRepository.findById(id)
                .map(post -> {
                    post.setStationId(updatedPost.getStationId());
                    post.setRepairInfo(updatedPost.getRepairInfo());
                    return postRepository.save(post); // Saves the updated post
                }).orElse(null); // If the post is not found, return null
    }

    // Delete a post by its ID
    public void deletePost(Long id) {
        postRepository.deleteById(id); // Deletes the post by ID from the database
    }
}
