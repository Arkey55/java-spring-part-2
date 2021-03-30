package ru.romankuznetsov.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.romankuznetsov.entity.Product;
import ru.romankuznetsov.repository.ProductRepository;
import ru.romankuznetsov.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class WebController {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductService productService;

//    @GetMapping
//    public String index(Model model){
//        model.addAttribute("products", repository.findAll());
//        model.addAttribute("newproduct", new Product());
//        return "index";
//    }

//    @GetMapping
//    public String index(
//            Model model,
//            @PageableDefault(sort = {"title"}) Pageable pageable
//    ){
//        Page<Product> page = repository.findAll(pageable);
//        model.addAttribute("products", page);
//        model.addAttribute("utl", "/");
//        model.addAttribute("newproduct", new Product());
//        return "index";
//    }
    @GetMapping(value = "/products")
    public String listBooks(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Page<Product> productPage = productService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("products", productPage);
        model.addAttribute("newproduct", new Product());

        int totalPages = productPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "index";
    }


    @PostMapping
    public String addProduct(Product product){
        repository.save(product);
        return "redirect:/products";
    }

    @PostMapping("/products/delete/{id}")
    public String delProduct(@PathVariable long id){
        repository.deleteById(id);
        return "redirect:/products";
    }
}
