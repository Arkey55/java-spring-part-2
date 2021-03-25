package ru.romankuznetsov.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.romankuznetsov.entity.Product;
import ru.romankuznetsov.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    private final ProductRepository repository;

    public MainController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/app/products/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public Product findById(@PathVariable Long id){
        Optional<Product> product = repository.findById(id);
        return product.orElse(null);
    }

    @GetMapping(path = "/app/products", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Product> findAll(){
        return repository.findAll();
    }

    @PostMapping(path = "/app/products/{title}/{price}")
    public void addProduct(@PathVariable String title, @PathVariable int price){
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        repository.save(product);
    }

    @GetMapping(path = "/app/products/delete/{id}")
    public void removeProduct(@PathVariable long id){
        repository.deleteById(id);
    }
}
