package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library lib;
    @BeforeEach
    void setUp() {
        lib = new Library();
    }
    @Test
    void addAndLendAndReturnBook_happyPath() {
        lib.addBook(new Book("B1","T","A"));
        lib.registerMember(new Member("M1","M"));
        assertTrue(lib.lendBook("B1","M1"));
        assertTrue(lib.returnBook("B1","M1"));
        assertFalse(lib.returnBook("B1","M1"), "Cannot return twice");
    }
}