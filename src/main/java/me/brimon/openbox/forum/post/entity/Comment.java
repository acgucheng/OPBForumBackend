package me.brimon.openbox.forum.post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="opb_forum")
public class Comment extends Post{
    private Integer topic;
}
