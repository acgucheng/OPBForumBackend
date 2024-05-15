package me.brimon.openbox.forum.post.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity
@Table(name="opb_post")
public abstract class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private ZonedDateTime publishedTime;
    private ZonedDateTime lastModified;
    private String publisher;
}
