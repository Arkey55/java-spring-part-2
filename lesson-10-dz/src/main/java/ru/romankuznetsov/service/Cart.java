package ru.romankuznetsov.service;

import org.springframework.stereotype.Component;
import ru.romankuznetsov.entity.Person;
import ru.romankuznetsov.entity.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Cart {
    private Map<Person, List<Product>> cart = new HashMap<>();

    public Map<Person, List<Product>> getCart() {
        return cart;
    }

    public void setCart(Map<Person, List<Product>> cart) {
        this.cart = cart;
    }
}
