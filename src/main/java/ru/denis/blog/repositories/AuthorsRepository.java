package ru.denis.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denis.blog.models.Author;

public interface AuthorsRepository extends JpaRepository<Author, Integer> {
}
