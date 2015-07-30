package com.tradeshift.dao;

import com.tradeshift.bean.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by hushuai on 15/7/23.
 */

@Component
public class PersonDAO {

    public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost/maven";
    public static final String USER_NAME = "root";
    public static final String USER_PWD = "hs000000";

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public PersonDAO() {}

    public List<Person> read() {
        List<Person> persons = new ArrayList<Person>();
        Person person = null;
        String sql = "select * from person";
        try {
            Class.forName(DRIVER_CLASS_NAME);
            connection = DriverManager.getConnection(URL, USER_NAME, USER_PWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                person = new Person();
                person.setName(resultSet.getString("name"));
                person.setAge(Integer.parseInt(resultSet.getString("age")));
                persons.add(person);
            }

            closeResource();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return persons;
    }

    public Person read(String name) {
        //Person person = new Person("test", 100);
        Person person = null;

        String sql = "select * from person where name = '" + name + "'";
        try {
            Class.forName(DRIVER_CLASS_NAME);
            connection = DriverManager.getConnection(URL, USER_NAME, USER_PWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                person = new Person();
                person.setName(resultSet.getString("name"));
                person.setAge(Integer.parseInt(resultSet.getString("age")));
                //persons.add(person);
            }
            closeResource();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return person;
    }

    public boolean insert(Person person) {
        boolean flag = false;
        String sql = "insert into person(name, age) values" + "('" + person.getName() +
                "', " + person.getAge() + ")";
        System.out.println(sql);
        try {
            Class.forName(DRIVER_CLASS_NAME);
            connection = DriverManager.getConnection(URL, USER_NAME, USER_PWD);
            statement = connection.createStatement();
            flag = statement.execute(sql);
            closeResource();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }
    public boolean update(Person person) {
        boolean flag = false;
        String sql = "update person set age = " + person.getAge() + " where name = '" + person.getName().toString() + "'";
        System.out.println(sql);
        try {
            Class.forName(DRIVER_CLASS_NAME);
            connection = DriverManager.getConnection(URL, USER_NAME, USER_PWD);
            statement = connection.createStatement();
            flag = statement.execute(sql);
            closeResource();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    public boolean delete(String name) {
        boolean flag = false;
        String sql = "delete from person where name = '" + name + "'";
        try {
            Class.forName(DRIVER_CLASS_NAME);
            connection = DriverManager.getConnection(URL, USER_NAME, USER_PWD);
            statement = connection.createStatement();
            flag = statement.execute(sql);
            closeResource();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    public void closeResource() throws SQLException {
        if(resultSet != null) {
            resultSet.close();
        }
        if(statement != null) {
            statement.close();
        }
        if(connection != null) {
            connection.close();
        }
    }

}
