/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author c0642607
 */
@Path("/messages")
@ApplicationScoped
public class MessageServices {

    @Inject
    MessageController messageController;

    @GET
    @Produces("application/json")
    public JsonArray getAll() {
        JsonArrayBuilder json = Json.createArrayBuilder();
        for (Message m : messageController.getAll()) {
            json.add(m.toJson());

        }
        return json.build();

    }
    
    @GET
    @Path("{id}")
    public Json getById(int id) {
        return null;
    }
    
    @GET
    @Path("{to}/{from}")
    public JsonArray getByDate(List<Message> message) {
        return null;
    }
    
}
