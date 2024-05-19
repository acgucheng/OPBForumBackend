package me.brimon.openbox.forum.post.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class PostDTO {
    private Integer id;
    private String type;
    private String title;
    private String content;
    private String publisher;
    private ZonedDateTime publishedTime;
    private ZonedDateTime lastModified;
    private Integer topicId;
}
