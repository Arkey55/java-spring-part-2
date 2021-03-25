package ru.romankuznetsov.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.romankuznetsov.entity.Person;
import ru.romankuznetsov.oldRepo.PersonRepo;
import ru.romankuznetsov.repository.PersonRepository;

@Service
public class Runner implements CommandLineRunner {

    @Autowired
    PersonRepository repo;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        Optional<Person> person = repo.findById(10L);
//        person.ifPresent(p -> System.out.println(p.toString()));

//        Person person1 = new Person("Vova", "Marvel");
//        repo.save(person1);

//        List<Person> personList = (List<Person>) repo.findAll();
//        personList.forEach(p -> System.out.println(p.toString()));

//        repo.findByLastName("Bulba").ifPresent(p -> System.out.println(p.toString()));

//        Pageable pageable = PageRequest.of(0, 3, Sort.by("id").ascending());
//        Page<Person> page = repo.findAll(pageable);
//        page.getContent().forEach(p -> System.out.println(p.toString()));
    }
}
