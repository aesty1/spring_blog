package ru.denis.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denis.blog.models.Comment;
import ru.denis.blog.repositories.CommentsRepository;

import java.util.Date;
import java.util.Optional;

@Service
public class CommentsService {
    private CommentsRepository commentsRepository;

    @Autowired
    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public Comment getById(int id) {
        Optional<Comment> comment = commentsRepository.findById(id);

        return comment.orElse(null);
    }
    
    public void delete(Comment comment) {
        commentsRepository.delete(comment);
    }

    public void create(Comment comment) {
        comment.setUpload_time(new Date());
    }
}
