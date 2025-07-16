package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Book {
    private static final Logger log = LogManager.getLogger(Book.class);

    private final String id;
    private final String title;
    private final String author;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        log.info("Created Book: {} by {} (ID: {})", title, author, id);
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    @Override
    public String toString() {
        String repr = title + " by " + author + " (ID: " + id + ")";
        log.debug("Book.toString() -> {}", repr);
        return repr;
    }
}
