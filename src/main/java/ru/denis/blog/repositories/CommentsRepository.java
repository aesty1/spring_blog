package ru.denis.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denis.blog.models.Author;
import ru.denis.blog.models.Comment;

public interface CommentsRepository extends JpaRepository<Comment, Integer> {
}
