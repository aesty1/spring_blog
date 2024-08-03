package ru.denis.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denis.blog.models.Author;
import ru.denis.blog.models.Post;

import java.util.List;

public interface PostsRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllByAuthor(Author author);
}
