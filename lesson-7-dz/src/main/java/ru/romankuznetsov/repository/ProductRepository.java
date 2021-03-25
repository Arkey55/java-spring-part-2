package ru.romankuznetsov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.romankuznetsov.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
