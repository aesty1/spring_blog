package ru.denis.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.denis.blog.models.Author;
import ru.denis.blog.models.Post;
import ru.denis.blog.repositories.PostsRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Autowired
    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public Post getById(int id) {
        Optional<Post> post = postsRepository.findById(id);

        return post.orElse(null);
    }

    public List<Post> getAll() {
        return postsRepository.findAll();
    }

    public void create(Post post) {
        post.setUpload_time(new Date());
        postsRepository.save(post);
    }

    public void delete(int id) {
        postsRepository.deleteById(id);
    }

    public void change(int id, Post post) {
        post.setPost_id(id);

        postsRepository.save(post);
    }


}
