package com.tradeshift.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hushuai on 15/7/27.
 */

@XmlRootElement(name = "Person")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PersonDTO {
    private String name;
    private int age;

    public PersonDTO() {}

    public PersonDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
