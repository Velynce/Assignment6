/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author c0642607
 */
public class Message {

    private int id;
    private String title;
    private String content;
    private String author;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public JsonObject toJson() {
        DateFormat format = new SimpleDateFormat("MM/DD/YYYY");

        JsonObject json = Json.createObjectBuilder()
                .add("id", getId())
                .add("title", getTitle())
                .add("content", getContent())
                .add("author", getAuthor())
                .add("date", format.format(date))
                .build();
        return json;
    }

}
