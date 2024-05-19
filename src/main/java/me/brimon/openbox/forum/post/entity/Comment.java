package me.brimon.openbox.forum.post.entity;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import me.brimon.openbox.forum.post.dto.PostDTO;

@Data
@Entity
@Table(name="opb_post")
@DiscriminatorValue(value = "COMMENT")
public class Comment extends Post{
    private Integer topicId;

    @Override
    public PostDTO generateDTO(){
        PostDTO postDTO = super.generateDTO();
        postDTO.setType("COMMENT");
        postDTO.setTopicId(topicId);
        return postDTO;
    }
    public static Comment fromDTO(PostDTO postDTO){
        Comment comment = (Comment) Post.fromDTO(postDTO);
        comment.setTopicId(postDTO.getTopicId());
        return comment;
    }

}
