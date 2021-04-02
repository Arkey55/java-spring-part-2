package ru.romankuznetsov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.romankuznetsov.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {
}
