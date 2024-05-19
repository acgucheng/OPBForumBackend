package me.brimon.openbox.forum.post.controller;

import me.brimon.openbox.forum.post.dto.PostDTO;
import me.brimon.openbox.forum.post.entity.Post;
import me.brimon.openbox.forum.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/{postId}")
    public PostDTO getpost(@PathVariable Integer postId)
    {
        return postService.getPost(postId).generateDTO();
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping()
    public PostDTO addPost(@RequestBody PostDTO postDTO){
        Post post = Post.fromDTO(postDTO);
        System.out.println(postDTO);

        return postService.addPost(post).generateDTO();
    }

    @PutMapping("/{postId}")
    public PostDTO modifyPost(@PathVariable Integer postId, @RequestBody PostDTO postDTO){
        return postService.modifyPost(postId, postDTO.getTitle(), postDTO.getContent()).generateDTO();
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Integer postId){
        postService.deletePost(postId);
    }

    @PostMapping("/{topicId}/comment")
    public PostDTO addComment(@PathVariable Integer topicId, @RequestBody PostDTO postDTO){
        //postDTO.setType("COMMENT");
        Post post = Post.fromDTO(postDTO);
        return postService.addComment(topicId,post).generateDTO();
    }


}
