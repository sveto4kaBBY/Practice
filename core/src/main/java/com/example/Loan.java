package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

public class Loan {
    private static final Logger log = LogManager.getLogger(Loan.class);

    private final Book book;
    private final Member member;
    private final LocalDate loanDate;
    private final LocalDate dueDate;

    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.loanDate = LocalDate.now();
        this.dueDate  = loanDate.plusWeeks(2);
        log.info("New Loan: {} loaned to {} until {}", book.getId(), member.getId(), dueDate);
    }

    public Book getBook() { return book; }
    public Member getMember() { return member; }
    public LocalDate getDueDate() { return dueDate; }

    @Override
    public String toString() {
        String repr = book + " loaned to " + member + " until " + dueDate;
        log.debug("Loan.toString() -> {}", repr);
        return repr;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }
}
