package me.brimon.openbox.forum.post.entity;

import jakarta.persistence.*;
import lombok.Data;
import me.brimon.openbox.forum.post.dto.PostDTO;
import me.brimon.openbox.forum.post.repository.PostRepository;

import java.time.ZonedDateTime;

@Data
@Entity
@Table(name="opb_post")
@DiscriminatorColumn(name = "type")
@DiscriminatorValue(value = "POST")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private ZonedDateTime publishedTime;
    private ZonedDateTime lastModified;
    private String publisher;
    private Boolean deleted;
    public PostDTO generateDTO(){
        PostDTO postDTO = new PostDTO();
        postDTO.setId(id);
        postDTO.setTitle(title);
        postDTO.setContent(content);
        postDTO.setPublisher(publisher);
        postDTO.setLastModified(lastModified);
        postDTO.setPublishedTime(publishedTime);
        postDTO.setType("POST");
        return postDTO;
    }


    public static Post fromDTO(PostDTO postDTO){
        Post post;
        if(postDTO.getType().equals("POST"))
            post = new Post();
        else{
            post = new Comment();
        }
        post.setId(postDTO.getId());
        post.setPublisher(postDTO.getPublisher());
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setLastModified(postDTO.getLastModified());
        post.setPublishedTime(postDTO.getPublishedTime());
        System.out.println(post);
        return post;
    }
    public Post modify(PostRepository postRepository, String title, String content){
        if(title!=null) this.title = title;
        if(content!=null) this.content = content;
        this.lastModified = ZonedDateTime.now();
        return postRepository.save(this);
    }

    public void delete(PostRepository postRepository,Post post){
        this.deleted = true;
        postRepository.save(this);
    }
    public Post save(PostRepository postRepository,Post post){
        post.setPublishedTime(ZonedDateTime.now());
        post.setDeleted(false);
        return postRepository.save(post);

    }
    public Comment comment(PostRepository postRepository, Post commentPost){
        Comment comment = new Comment();
        comment.setTopicId(this.id);
        comment.setPublisher(commentPost.getPublisher());
        comment.setTitle(commentPost.getTitle());
        comment.setContent(commentPost.getContent());
        comment.setLastModified(ZonedDateTime.now());
        comment.setPublishedTime(ZonedDateTime.now());
        return (Comment) postRepository.save(comment);
    }
}
