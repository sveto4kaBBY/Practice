package com.example;

import java.time.LocalDate;

public class Loan {
    private final Book book;
    private final Member member;
    private final LocalDate loanDate;
    private final LocalDate dueDate;

    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.loanDate = LocalDate.now();
        this.dueDate  = loanDate.plusWeeks(2);
    }
    public Book getBook() { return book; }
    public Member getMember() { return member; }
    public LocalDate getDueDate() { return dueDate; }

    @Override
    public String toString() {
        return book + " loaned to " + member + " until " + dueDate;
    }
}