package com.example;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class LoanTest {
    @Test
    void testDueDateIsTwoWeeksFromLoanDate() {
        Book book = new Book("B1", "1984", "George Orwell");
        Member member = new Member("M1", "Bob");
        Loan loan = new Loan(book, member);
        LocalDate expectedDue = LocalDate.now().plusWeeks(2);
        assertEquals(expectedDue, loan.getDueDate(), "Due date should be 2 weeks after loan date");
    }

    @Test
    void testToStringContainsAllInfo() {
        Book book = new Book("B2", "Crime and Punishment", "Dostoevsky");
        Member member = new Member("M2", "Carol");
        Loan loan = new Loan(book, member);
        String repr = loan.toString();
        assertTrue(repr.contains("Crime and Punishment"));
        assertTrue(repr.contains("Dostoevsky"));
        assertTrue(repr.contains("Carol"));
        assertTrue(repr.contains(loan.getDueDate().toString()));
    }
}
