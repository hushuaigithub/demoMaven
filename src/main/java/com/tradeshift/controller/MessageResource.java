package com.tradeshift.controller;

import com.tradeshift.bean.Person;
import com.tradeshift.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by hushuai on 15/7/22.
 */
@Path("/spring")
@Component
public class MessageResource {

    @Autowired
    private MessageService messageService;

    public MessageResource() {}

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonDTO> getAllPerson() {
        //System.out.println("go to here!");
        messageService = new MessageService();
        return messageService.listAllPerson();
    }

    @GET
    @Path("get/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public PersonDTO getPerson(@PathParam("name") String name) {
        return messageService.readPerson(name);
    }

    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public String updatePerson(@QueryParam("age") Integer age, @QueryParam("name") String name) {
        return messageService.updatePerson(new PersonDTO(name, age));
    }

    @POST
    @Path("add/{name}/{age}")
    @Produces(MediaType.TEXT_PLAIN)
    public String addPerson(@PathParam("name") String name, @PathParam("age") Integer age) {
        return messageService.addPerson(new PersonDTO(name, age));
    }

    @DELETE
    @Path("delete/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String remotePerson(@PathParam("name") String name) {
        return messageService.deletePerson(name);
    }
}
