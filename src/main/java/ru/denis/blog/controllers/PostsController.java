package ru.denis.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.denis.blog.models.Author;
import ru.denis.blog.models.Comment;
import ru.denis.blog.models.Post;
import ru.denis.blog.services.AuthorsService;
import ru.denis.blog.services.CommentsService;
import ru.denis.blog.services.PostsService;

@Controller
@RequestMapping("/posts")
public class PostsController {
    private final AuthorsService authorsService;
    private final PostsService postsService;
    private final CommentsService commentsService;

    @Autowired
    public PostsController(AuthorsService authorsService, PostsService postsService, CommentsService commentsService) {
        this.authorsService = authorsService;
        this.postsService = postsService;
        this.commentsService = commentsService;
    }


    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("posts", postsService.getAll());

        return "posts/all";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") int id, Model model, @ModelAttribute("comment") Comment comment) {
        model.addAttribute("post", postsService.getById(id));
        model.addAttribute("comments", commentsService.findAllByPost(postsService.getById(id)));

        return "posts/one";
    }

    @GetMapping("/new")
    public String createPage(@ModelAttribute("post") Post post, Model model) {
        model.addAttribute("authors", authorsService.getAll());
        return "posts/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("post") Post post) {
        post.setAuthor(authorsService.getById(1));

        postsService.create(post);

        return "redirect:/posts";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        postsService.delete(id);

        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String editPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("post", postsService.getById(id));
        return "posts/edit";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("post") Post post, @PathVariable("id") int id) {
        post.setUpload_time(postsService.getById(id).getUpload_time());
        post.setAuthor(postsService.getById(id).getAuthor());
        postsService.change(id, post);

        return "redirect:/posts";
    }
}
