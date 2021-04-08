package ru.romankuznetsov.config.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.romankuznetsov.entity.Person;
import ru.romankuznetsov.exceptions.PersonNotFoundException;
import ru.romankuznetsov.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final PersonRepository personRepository;

    public UserService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Person> personOptional = personRepository.findByLogin(s);
        if (personOptional.isEmpty()){
            throw new PersonNotFoundException("User not found...");
        }
        Person person = personOptional.get();
        return new User(person.getLogin(), person.getPassword(),
                List.of(new SimpleGrantedAuthority(person.getRole().getName())));
    }
}
