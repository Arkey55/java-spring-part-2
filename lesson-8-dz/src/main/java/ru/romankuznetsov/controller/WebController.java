package ru.romankuznetsov.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.romankuznetsov.repository.ProductRepository;

@Controller
public class WebController {

    @Autowired
    ProductRepository repository;
    @GetMapping
    public String index(Model model){
        model.addAttribute("products", repository.findAll());
        return "index";
    }
}
