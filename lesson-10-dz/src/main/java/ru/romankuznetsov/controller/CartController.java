package ru.romankuznetsov.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import ru.romankuznetsov.entity.Product;
import ru.romankuznetsov.entity.Person;
import ru.romankuznetsov.exceptions.PersonNotFoundException;
import ru.romankuznetsov.exceptions.ProductNotFoundException;
import ru.romankuznetsov.repository.PersonRepository;
import ru.romankuznetsov.repository.ProductRepository;
import ru.romankuznetsov.service.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@SessionScope
@RequestMapping("api/v1/cart")
public class CartController {
    private final PersonRepository personRepository;
    private final ProductRepository productRepository;
    private final Cart cart;

    public CartController(PersonRepository personRepository, ProductRepository productRepository, Cart cart) {
        this.personRepository = personRepository;
        this.productRepository = productRepository;
        this.cart = cart;
    }

    @GetMapping
    public Map<Person, List<Product>> showAll(){
        return cart.getCart();
    }

    @GetMapping("{id}")
    public List<Product> showById(@PathVariable long id){
        Person person = personRepository.findById(id).orElseThrow(
                () -> new PersonNotFoundException(String.format("клиент с ID [%s] не найден", id))
        );
        return cart.getCart().get(person);
    }

    @PostMapping("{personId}/{productId}")
    public void addToCart(@PathVariable long personId, @PathVariable long productId){
        Person person = personRepository.findById(personId).orElseThrow(
                () -> new PersonNotFoundException(String.format("клиент с ID [%s] не найден", personId))
        );
        List<Product> productList = new ArrayList<>();
        productList.add(productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException(String.format("продукт с ID [%s] не найден", productId))
        ));
        for (Product p : productList) {
            cart.getCart().computeIfAbsent(person, k -> new ArrayList<>()).add(p);
        }
    }

//    @DeleteMapping("{personId}/{productId}")
//    public void deleteFromCart(@PathVariable long personId, @PathVariable long productId){
//        Person person = personRepository.findById(personId).orElseThrow(() -> new PersonNotFoundException(String.format("клиент с ID [%s] не найден", personId)));
//        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(String.format("продукт с ID [%s] не найден", productId)));
//        if (cart.getCart().get(person).contains(product)) {
//            cart.getCart().get(person).remove(product);
//        }
//    }


}
