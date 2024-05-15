package me.brimon.openbox.forum.post.service;

import me.brimon.openbox.forum.post.dto.CommentDTO;
import me.brimon.openbox.forum.post.dto.PostDTO;
import me.brimon.openbox.forum.post.dto.PutDTO;
import me.brimon.openbox.forum.post.entity.Post;
import me.brimon.openbox.forum.post.entity.Topic;
import me.brimon.openbox.forum.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    public Post getPost(Integer id){
        return postRepository.getPostById(id);
    }
    public Post addPost(PostDTO postDTO){
        Post post = new Topic();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setPublisher(postDTO.getPublisher());
        post.setPublishedTime(ZonedDateTime.now());
        return postRepository.save(post);

    }
    public PutDTO modifyPost(Integer id,PostDTO postDTO){
        Post post = postRepository.getPostById(id);
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setPublisher(postDTO.getPublisher());
        Post returnedPost = postRepository.save(post);
        PutDTO putDTO = new PutDTO();
        putDTO.setContent(returnedPost.getContent());
        putDTO.setTitle(returnedPost.getTitle());
        return putDTO;
    }
    public void deletePost(Integer id){
        postRepository.deleteById(id);
    }
    public void addComment(Integer id, CommentDTO commentDTO){
       //
    }

}

