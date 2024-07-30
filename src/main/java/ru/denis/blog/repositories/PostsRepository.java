package ru.denis.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denis.blog.models.Author;
import ru.denis.blog.models.Post;

public interface PostsRepository extends JpaRepository<Post, Integer> {
}
