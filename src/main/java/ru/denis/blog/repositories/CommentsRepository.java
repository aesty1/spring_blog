package ru.denis.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denis.blog.models.Author;
import ru.denis.blog.models.Comment;
import ru.denis.blog.models.Post;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByPost(Post post);
}
