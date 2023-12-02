package com.alex.watchlist.model;

import javax.persistence.*;

@Entity
@Table(name = "reports")
public class HelloMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nickname")
    private String from;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private String time;

    public HelloMessage() {
    }

    public HelloMessage(final String from, final String text, final String time) {

        this.from = from;
        this.text = text;
        this.time = time;
    }

    public String getFrom() {
        return from;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setName(String name) {
        this.from = name;
    }
}
