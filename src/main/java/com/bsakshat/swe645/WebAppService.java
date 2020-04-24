package com.bsakshat.swe645;

import javax.ws.rs.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Path("/")
public class WebAppService {

    @GET //specifies the GET request
    @Path("{id}") //path to send a GET request where the id is a parameter value
    @Produces(MediaType.APPLICATION_JSON)  //returns a json object
    public Survey getSurvey(@PathParam("id")int id) {
        //creates a entitymanager to persist to the database
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("student");
        EntityManager entitymanager = factory.createEntityManager();
        //finds the record in the database with the provided id attribute
        Survey info = entitymanager.find(Survey.class, id);
        //if it doesn't exist, throws an exception
        if (info == null) {
            throw new NullPointerException();
        }
        System.out.println("Survey information of " + info.getFirst());
        entitymanager.close();
        factory.close();
        return info;
    }

    @POST //specifies the POST request
    @Path("addSurvey") //path to send a POST request
    @Consumes(MediaType.APPLICATION_JSON) //takes in a json object

    public void addSurvey(Survey survey) throws SQLException{
        System.out.println("Adding a survey record!");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("student");
        EntityManager entitymanager = factory.createEntityManager();
        entitymanager.getTransaction().begin();
        //Survey info = entitymanager.find(Survey.class, survey.getId());

        /*if (survey==info) {
            throw new SQLException("The record already exists");
        }*/

        entitymanager.persist(survey);
        System.out.println("Added the survey record");
        entitymanager.getTransaction().commit();
        entitymanager.close();
        factory.close();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getAllSurvey()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("student");
        EntityManager entitymanager = factory.createEntityManager();

        List<Object> all = null;

        entitymanager.getTransaction().begin();
        all = entitymanager.createNamedQuery("getall").getResultList();

        List<String> surveys = new ArrayList<>(all.size());
        for (Object object : all) {
            surveys.add(Objects.toString(object, null));
        }
        return surveys;

    }
}
