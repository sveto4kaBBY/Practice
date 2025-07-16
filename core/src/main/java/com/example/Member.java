package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Member {
    private static final Logger log = LogManager.getLogger(Member.class);

    private final String id;
    private final String name;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        log.info("Registered Member: {} (ID: {})", name, id);
    }

    public String getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        String repr = name + " (ID: " + id + ")";
        log.debug("Member.toString() -> {}", repr);
        return repr;
    }
}