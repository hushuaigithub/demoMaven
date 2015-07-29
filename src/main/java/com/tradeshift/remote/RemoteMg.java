package com.tradeshift.remote;

import com.tradeshift.bean.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hushuai on 15/7/22.
 */
@Path("/jersey")
public class RemoteMg {
    private Map<Integer, Person> persons = new HashMap<Integer, Person>();

    public RemoteMg() {
        if(persons.size() == 0) {
            persons.put(1, new Person("Harry", 55));
        }
    }

    @GET
    @Path("index")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Person getPerson(@PathParam("index") int index) {
       if(persons.containsKey(index)) {
           return persons.get(index);
       } else {
            return new Person("NIL", 0);
        }
    }

    @GET
    @Path("list")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Person> getAllPerson() {

        persons.put(5, new Person("Vincent", 90));
        List<Person> personsList = new ArrayList<Person>();

        personsList.addAll(persons.values());
        return personsList;
    }

}
