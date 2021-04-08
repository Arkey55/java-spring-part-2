package ru.romankuznetsov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.romankuznetsov.entity.Person;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByLastName(String lastName);
    Optional<Person> findByLogin(String login);
}
