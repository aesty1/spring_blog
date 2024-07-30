package ru.denis.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denis.blog.models.Author;
import ru.denis.blog.models.Post;
import ru.denis.blog.repositories.AuthorsRepository;

import javax.persistence.Temporal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorsService {
    private AuthorsRepository authorsRepository;

    @Autowired
    public AuthorsService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    public Author getById(int id) {
        Optional<Author> author = authorsRepository.findById(id);

        return author.orElse(null);
    }

    public List<Author> getAll() {
        return authorsRepository.findAll();
    }

    public void create(Author author) {
        author.setRegistration_time(new Date());

        authorsRepository.save(author);
    }

    public void delete(Author author) {
        authorsRepository.delete(author);
    }

    public void change(Author author) {
        authorsRepository.save(author);
    }


}
