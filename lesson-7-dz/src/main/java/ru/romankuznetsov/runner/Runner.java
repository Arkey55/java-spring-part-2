package ru.romankuznetsov.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.romankuznetsov.entity.Product;
import ru.romankuznetsov.repository.ProductRepository;

@Service
public class Runner implements CommandLineRunner {

    private final ProductRepository repo;

    public Runner(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
//        repo.findById(17L).ifPresent(p -> System.out.println(p.toString()));
        Pageable pageable = PageRequest.of(0, 5, Sort.by("price"));
        Page<Product> page = repo.findAll(pageable);
        page.getContent().forEach(p -> System.out.println(p.toString()));
    }
}
