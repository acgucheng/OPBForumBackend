package me.brimon.openbox.forum.post.repository;

import me.brimon.openbox.forum.post.entity.Post;
import org.springframework.data.repository.Repository;

public interface PostRepository extends Repository<Post,Integer> {
    public Post getPostById(Integer id);
    public Post save(Post post);
    //public void deleteById(Integer id);//We use logical deletion rather than physical deletion
}
