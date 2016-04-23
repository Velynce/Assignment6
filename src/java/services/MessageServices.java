/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    @Produces("application/json")
    public JsonObject getById(@PathParam("id") int id) {
        JsonObject json = messageController.getById(id).toJson();
        if (json != null) {
            return json;
        }
        return null;
    }

    @GET
    @Path("{from}/{to}")
    @Produces("application/json")
    public JsonArray getByDate(@PathParam("from") Date from, @PathParam("to") Date to) {
        return messageController.getJsonFrom(from, to);
    }

//    @POST
//    public JsonArray add(String message) {
//      JsonObject json = Json.createReader(new StringReader(message)).readObject();
//      messageController.add(json.getString("title"));
//      return getAll();
//
//    }

}
