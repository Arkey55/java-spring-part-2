package ru.romankuznetsov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.romankuznetsov.entity.Person;
import ru.romankuznetsov.repository.PersonRepository;

@Controller
public class ThymeleafController {

    private final PersonRepository repository;

    public ThymeleafController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/login")
    public String showMyLoginPage(){
        return "login";
    }


    @GetMapping
    public String index(Model model){
        model.addAttribute("hello", "hello");
        model.addAttribute("name", "Роман");
//        List<Person> persons = repository.findAll();
        model.addAttribute("persons", repository.findAll());
        return "index";
    }

    @GetMapping("/api/v1/person/addperson")
    public String getAddPerson(Model model){
        model.addAttribute("person", new Person());
        return "add_person";
    }

    @PostMapping(value = "/api/v1/person/addperson")
    public String addPerson(Person person){
        repository.save(person);
        return "redirect:/api/v1/person/addperson";
    }
}
