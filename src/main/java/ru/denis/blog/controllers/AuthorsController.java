package ru.denis.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.denis.blog.models.Author;
import ru.denis.blog.services.AuthorsService;
import ru.denis.blog.services.PostsService;

@Controller
@RequestMapping("/authors")
public class AuthorsController {
    private final AuthorsService authorsService;
    private final PostsService postsService;

    @Autowired
    public AuthorsController(AuthorsService authorsService, PostsService postsService) {
        this.authorsService = authorsService;
        this.postsService = postsService;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("authors", authorsService.getAll());

        return "authors/all";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") int id, Model model) {
        model.addAttribute("author", authorsService.getById(id));
        model.addAttribute("posts", postsService.getAuthorPosts(authorsService.getById(id)));

        return "authors/one";
    }

    @GetMapping("/new")
    public String createPage(@ModelAttribute("author") Author author) {
        return "authors/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("author") Author author) {
        authorsService.create(author);

        return "redirect:/authors";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        authorsService.delete(id);

        return "redirect:/authors";
    }

    @GetMapping("/{id}/edit")
    public String editPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("author", authorsService.getById(id));

        return "authors/edit";
    }

    @PatchMapping("/{id}")
    public String edit(@PathVariable("id") int id, @ModelAttribute("author") Author author) {
        authorsService.change(id, author);

        return "redirect:/authors";
    }
}
