package pl.pawlas.warehouse.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pawlas.warehouse.model.Supplier;
import pl.pawlas.warehouse.service.SupplierService;

import javax.validation.Valid;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    private enum SupplierType{
        WHOLESALER,
        PUBLISHER
    }

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addSupplierForm(Model model) {
        model.addAttribute("supplierType", SupplierType.values());
        model.addAttribute("supplier", new Supplier());
        return "supplier/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addSupplier(@Valid Supplier supplier, BindingResult result) {
        if (result.hasErrors()) {
            return "supplier/add";
        } else {
            supplierService.save(supplier);
            return "redirect:/supplier/all";
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getSupplierForm(Model model, @PathVariable Long id) {
        model.addAttribute("supplier", supplierService.getById(id));
        return "supplier/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateSupplier(@Valid Supplier supplier, BindingResult result) {
        if (result.hasErrors()) {
            return "supplier/update";
        } else {
            supplierService.update(supplier);
            return "redirect:/supplier/all";
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        supplierService.delete(id);
        return "redirect:/supplier/all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("suppliers", supplierService.findAll());
        return "supplier/all";
    }
}
