package com.politecnico.main.controller;

import com.politecnico.main.entity.Product;
import com.politecnico.main.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public String findAll(Model model) {
        List<Product> products=this.repository.findAll();
        model.addAttribute("products", products);
        return "product-list";
    }
    @GetMapping("/new")
    public String getForm(Model model) {
        model.addAttribute("products", new Product(8L,"prueba1",3.4,3));
        return "product-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("product")Product product){
        this.repository.save(product);
        return "redirect:/products";
    }
}
