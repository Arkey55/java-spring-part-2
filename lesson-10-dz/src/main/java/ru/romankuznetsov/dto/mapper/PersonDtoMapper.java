package ru.romankuznetsov.dto.mapper;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.romankuznetsov.dto.PersonDto;
import ru.romankuznetsov.entity.Person;

@Mapper
public interface PersonDtoMapper {
    PersonDtoMapper MAPPER = Mappers.getMapper(PersonDtoMapper.class);
    @Mapping(target = "lastName", source = "personDto.secondName")//делается в случае, когда имена полей отличаются
    Person toPerson(PersonDto personDto);
    @InheritInverseConfiguration //инвертирует конфигурацию, можно прописать полностью, как в предыдущем случае
    PersonDto toPersonDto(Person person);
}
