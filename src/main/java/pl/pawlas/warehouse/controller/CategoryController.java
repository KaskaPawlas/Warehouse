package pl.pawlas.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pawlas.warehouse.model.Category;
import pl.pawlas.warehouse.service.CategoryService;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCategoryForm(Model model){
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCategory(@Valid Category category, BindingResult result){
        if(result.hasErrors()){
            return "category/add";
        } else {
            categoryService.save(category);
            return "redirect:/category/all";
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateCategoryForm(Model model, @PathVariable Long id){
        model.addAttribute("category", categoryService.getById(id));
        return "category/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateCategory(@Valid Category category, BindingResult result){
        if(result.hasErrors()){
            return "category/update";
        } else {
            categoryService.update(category);
            return "redirect:/category/all";
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id){
        categoryService.delete(id);
        return "redirect:/category/all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String findAll(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "category/all";
    }

}
