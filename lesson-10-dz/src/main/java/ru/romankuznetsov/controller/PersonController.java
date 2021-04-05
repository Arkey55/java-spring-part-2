package ru.romankuznetsov.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import ru.romankuznetsov.dto.PersonDto;
import ru.romankuznetsov.dto.mapper.PersonDtoMapper;
import ru.romankuznetsov.entity.Person;
import ru.romankuznetsov.exceptions.PersonNotFoundException;
import ru.romankuznetsov.repository.PersonRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@SessionScope
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public List<Person> getPeople(){
        return personRepository.findAll();
    }

    @GetMapping("{id}")
    public Person findPerson(@PathVariable long id){
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(
                        String.format("пользователь c ID{%s} не найден", id)
        ));
    }

    @PostMapping
    public Person savePerson(@RequestBody @Valid PersonDto personDto){
        Person person = PersonDtoMapper.MAPPER.toPerson(personDto);
        personRepository.save(person);
        return person;
    }

    @PutMapping
    public void updatePerson(@RequestBody @Valid Person person){
        personRepository.save(person);
    }

    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable long id){
        personRepository.delete(personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(
                        String.format("пользователь c ID{%s} не найден", id))));
    }
}
