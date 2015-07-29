package com.tradeshift.controller;

import com.tradeshift.bean.Person;
import com.tradeshift.dao.PersonDAO;
import com.tradeshift.dto.PersonBConvertD;
import com.tradeshift.dto.PersonDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by hushuai on 15/7/22.
 */
@Component
@Scope("singleton")
public class MessageService {

    //@Autowired
    //private PersonDAO personDAO;
    private PersonDAO personDAO = new PersonDAO();

    public MessageService() {}

    public List<PersonDTO> listAllPerson() {
        List<PersonDTO> personDTOList = PersonBConvertD.BeanToDto(personDAO.read());
        return personDTOList;
    }

    public PersonDTO readPerson(String name) {
        return PersonBConvertD.BeanToDto(personDAO.read(name));
    }

    public String updatePerson(PersonDTO personDTO) {
        boolean result = personDAO.update(PersonBConvertD.DtoToBean(personDTO));
        if(result) {
            System.out.println(result + ": update person successfully!");
        } else {
            System.out.println(result + ": update person unsuccessfully!");
        }
        return result + ": update person successfully!";
    }

    public String addPerson(PersonDTO personDTO) {
        boolean result = personDAO.insert(PersonBConvertD.DtoToBean(personDTO));
        return result + ": insert person successfully!";
    }

    public String deletePerson(String name) {
        boolean result = personDAO.delete(name);
        if(result) {
            System.out.println(result + ": delete person successfully!");
        } else {
            System.out.println(result + ": delete person unsuccessfully!");
        }
        return result + ": delete person successfully!";
    }
}
