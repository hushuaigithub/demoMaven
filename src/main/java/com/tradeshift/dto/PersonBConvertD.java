package com.tradeshift.dto;

import com.tradeshift.bean.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hushuai on 15/7/27.
 */
public class PersonBConvertD {

    public static PersonDTO BeanToDto(Person person) {
        return new PersonDTO(person.getName(), person.getAge());
    }

    public static Person DtoToBean(PersonDTO personDTO) {
        return new Person(personDTO.getName(), personDTO.getAge());
    }

    public static List<PersonDTO> BeanToDto(List<Person> persons) {
        List<PersonDTO> personDTOList = new ArrayList<PersonDTO>();
        for(int i=0; i<persons.size(); i++) {
            personDTOList.add(PersonBConvertD.BeanToDto(persons.get(i)));
        }
        return personDTOList;
    }
}
