package pl.pawlas.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pawlas.warehouse.model.Author;
import pl.pawlas.warehouse.service.AuthorService;

import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "author/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAuthor(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "author/add";
        } else {
            authorService.save(author);
            return "redirect:/author/all";
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getAuthorForm(@PathVariable Long id, Model model) {
        model.addAttribute("author", authorService.getById(id));
        return "author/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateAuthor(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "author/update";
        } else {
            authorService.update(author);
            return "redirect:/author/all";
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        authorService.delete(id);
        return "redirect:/author/all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "author/all";
    }
}
