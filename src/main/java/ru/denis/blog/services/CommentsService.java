package ru.denis.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denis.blog.models.Comment;
import ru.denis.blog.models.Post;
import ru.denis.blog.repositories.CommentsRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {
    private CommentsRepository commentsRepository;

    @Autowired
    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public List<Comment> findAllByPost(Post post) {
        return commentsRepository.findAllByPost(post);
    }

    public Comment getById(int id) {
        Optional<Comment> comment = commentsRepository.findById(id);

        return comment.orElse(null);
    }
    
    public void delete(int id) {
        commentsRepository.deleteById(id);
    }

    public void create(Comment comment) {
        comment.setUpload_time(new Date());
        commentsRepository.save(comment);
    }
}
