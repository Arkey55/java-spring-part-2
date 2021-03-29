package ru.romankuznetsov.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.romankuznetsov.entity.Product;
import ru.romankuznetsov.repository.ProductRepository;

@Controller
public class WebController {

    @Autowired
    ProductRepository repository;
    @GetMapping
    public String index(Model model){
        model.addAttribute("products", repository.findAll());
        model.addAttribute("newproduct", new Product());
        return "index";
    }

    @PostMapping
    public String addProduct(Product product){
        repository.save(product);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delProduct(@PathVariable long id){
        repository.deleteById(id);
        return "redirect:/";
    }
}
