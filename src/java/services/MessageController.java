/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author c0642607
 */
@ApplicationScoped
public class MessageController {

    private Message message;
    private List<Message> messages = new ArrayList<>();
    
    public MessageController() {
        Message m = new Message();
        m.setAuthor("Bob");
        m.setContent("Test");
        m.setDate(new Date());
        m.setId(0);
        m.setTitle("OK");
        messages.add(m);
    }

    public Message getById(int id) {
        for (Message m : messages) {
            if (id == m.getId()) {
                return m;
            }
        }
        return null;
    }

    public List<Message> getFrom(Date from, Date to) {
        // Make a New, Empty List
            List<Message> messageList = new ArrayList<>();
        // For Every Message in messages
        for (Message m : messages) {
            if (message.getDate().after(from) && message.getDate().before(to)) // - Check if its date is after "from" and before "to"
            {
                 // - If so, add it to the new List
                // Return the new List
                messageList.add(m);
                return messageList;
                
            }
        }
        return null;
    }

    public JsonArray getJsonFrom(Date from, Date to) {
        List<Message> msgs = getFrom(from, to);
        JsonArrayBuilder json = Json.createArrayBuilder();
        for (Message m : msgs) {
            json.add(m.toJson());
        }
        return json.build();
    }

    public void add(Message message) {
        messages.add(message);

    }

    public void edit(int id, Message message) {
        // Find  by ID
        // Make found one match passed one
        // - set Author
        // - set Date, etc...
        messages.set(id,message);        
    }

    public void delete(int id) {
        messages.remove(id);
    }

    public List<Message> getAll() {
        return messages;
    }

}
