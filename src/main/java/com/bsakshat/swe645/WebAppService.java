package com.bsakshat.swe645;

import javax.ws.rs.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.MediaType;
import java.awt.*;


@Path("/")
public class WebAppService {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Survey getSurvey(@PathParam("id")int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("student");
        EntityManager entitymanager = factory.createEntityManager();
        Survey info = entitymanager.find(Survey.class, id);
        if (info == null) {
            throw new NullPointerException();
        }
        System.out.println("Survey information of " + info.getFirst());
        entitymanager.close();
        factory.close();
        return info;
    }

}
