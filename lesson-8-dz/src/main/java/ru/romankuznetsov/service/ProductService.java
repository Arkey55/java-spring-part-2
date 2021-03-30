package ru.romankuznetsov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.romankuznetsov.entity.Product;
import ru.romankuznetsov.repository.ProductRepository;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final List<Product> products;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        products = productRepository.findAll();
    }

    public Page<Product> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Product> list;

        if (products.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, products.size());
            list = products.subList(startItem, toIndex);
        }

        Page<Product> productPage = new PageImpl<Product>(list, PageRequest.of(currentPage, pageSize), products.size());

        return productPage;
    }
}
