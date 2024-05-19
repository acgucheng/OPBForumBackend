package me.brimon.openbox.forum.post.service;

import me.brimon.openbox.forum.post.dto.PostDTO;
import me.brimon.openbox.forum.post.entity.Comment;
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
    public Post addPost(Post post){
        return post.save(postRepository,post);

    }
    public Post modifyPost(Integer id, String title, String comment){
        Post post = postRepository.getPostById(id);
        return post.modify(postRepository, title, comment);
    }
    public void deletePost(Integer id){
        Post post = postRepository.getPostById(id);
        post.delete(postRepository,post);
    }
    public Comment addComment(Integer topicId, Post post){
        Post topic = getPost(topicId);
        return topic.comment(postRepository,post);
    }

}

