package pl.pawlas.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pawlas.warehouse.model.Product;
import pl.pawlas.warehouse.service.AuthorService;
import pl.pawlas.warehouse.service.CategoryService;
import pl.pawlas.warehouse.service.ProductService;
import pl.pawlas.warehouse.service.SupplierService;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final AuthorService authorService;


    private enum ProductType {
        BOOK,
        EBOOK,
        DVD,
        CD,
        BLU_RAY,
        PUZZLE,
        BOARD_GAME,
        TOY
    };

    private final CategoryService categoryService;

    private final SupplierService supplierService;


    public ProductController(ProductService productService, AuthorService authorService, CategoryService categoryService, SupplierService supplierService) {
        this.productService = productService;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProductForm(Model model) {
        model.addAttribute("productAuthor", authorService.findAll());
        model.addAttribute("productCategory", categoryService.findAll());
        model.addAttribute("productTypes", ProductType.values());
        model.addAttribute("productSupplier", supplierService.findAll());
        model.addAttribute("product", new Product());
        return "product/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product/add";
        } else {
            productService.save(product);
            return "redirect:/product/all";
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getProductForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "author/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateProduct(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product/update";
        } else {
            productService.update(product);
            return "redirect:/product/all";
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/product/all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/all";
    }

    @RequestMapping(value = "/all/{authorId}", method = RequestMethod.GET)
    public String findAllByAuthor(Model model, @PathVariable Long authorId) {
        model.addAttribute("products", productService.findByAuthor(authorId));
        return "product/all";
    }

    @RequestMapping(value = "/all/{categoryId}", method = RequestMethod.GET)
    public String findAllByCategory(Model model, @PathVariable Long categoryId) {
        model.addAttribute("products", productService.findAll());
        return "product/all";
    }

//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    public String findAllBySupplierType(Model model){
//        model.addAttribute("products", productService.findBySupplier(supplierType));
//        return "product/all";
//    }
//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    public String findAllByProductType(Model model){
//        model.addAttribute("products", productService.findByProductType(productType));
//        return "product/all";
//    }


}
