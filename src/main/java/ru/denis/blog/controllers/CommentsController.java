package ru.denis.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.denis.blog.models.Comment;
import ru.denis.blog.services.CommentsService;
import ru.denis.blog.services.PostsService;

@Controller
@RequestMapping("/comments")
public class CommentsController {
    private final CommentsService commentsService;
    private final PostsService postsService;

    @Autowired
    public CommentsController(CommentsService commentsService, PostsService postsService) {
        this.commentsService = commentsService;
        this.postsService = postsService;
    }

    @PostMapping("/{id}")
    public String create(@ModelAttribute("comment") Comment comment, @PathVariable("id") int id) {
        comment.setPost(postsService.getById(id));
        commentsService.create(comment);

        return "redirect:/posts";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        commentsService.delete(id);

        return "redirect:/posts";
    }
}
