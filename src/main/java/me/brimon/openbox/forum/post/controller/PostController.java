package me.brimon.openbox.forum.post.controller;

import me.brimon.openbox.forum.post.dto.CommentDTO;
import me.brimon.openbox.forum.post.dto.PostDTO;
import me.brimon.openbox.forum.post.dto.PutDTO;
import me.brimon.openbox.forum.post.entity.Post;
import me.brimon.openbox.forum.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;
    @GetMapping("/{postId}")
    public Post getpost(@PathVariable Integer postId)
    {
        return postService.getPost(postId);
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping()
    public Post addPost(PostDTO postDTO){
        return postService.addPost(postDTO);
    }

    @PutMapping("/{postId}")
    public PutDTO modifyPost(@PathVariable Integer postId, PostDTO postDTO){
        return postService.modifyPost(postId,postDTO);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Integer postId){
        postService.deletePost(postId);
    }

    @PostMapping("/{topicId}/comment")
    public void addComment(@PathVariable Integer topicId, CommentDTO commentDTO){
        postService.addComment(topicId,commentDTO);
    }


}
