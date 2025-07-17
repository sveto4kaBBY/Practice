package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void toString_containsTitleAndAuthor() {
        Book b = new Book("X","Title","Author");
        String s = b.toString();
        assertTrue(s.contains("Title"));
        assertTrue(s.contains("Author"));
        assertTrue(s.contains("X"));
    }
}