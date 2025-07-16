package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Library {
    private static final Logger log = LogManager.getLogger(Library.class);

    private final Map<String, Book> books = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();
    private final List<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
        log.info("Book added: {}", book.getId());
    }

    public void registerMember(Member member) {
        members.put(member.getId(), member);
        log.info("Member registered: {}", member.getId());
    }

    public boolean lendBook(String bookId, String memberId) {
        Book b = books.get(bookId);
        Member m = members.get(memberId);
        if (b != null && m != null) {
            loans.add(new Loan(b, m));
            log.info("Lent book {} to member {}", bookId, memberId);
            return true;
        }
        log.warn("Failed to lend book {} to member {}: not found", bookId, memberId);
        return false;
    }

    public boolean returnBook(String bookId, String memberId) {
        Optional<Loan> loan = loans.stream()
                .filter(l -> l.getBook().getId().equals(bookId)
                        && l.getMember().getId().equals(memberId))
                .findFirst();
        if (loan.isPresent()) {
            loans.remove(loan.get());
            log.info("Returned book {} from member {}", bookId, memberId);
            return true;
        }
        log.warn("Failed to return book {} from member {}: loan not found", bookId, memberId);
        return false;
    }

    public void listLoans() {
        log.info("Listing all loans (total {})", loans.size());
        loans.forEach(l -> log.info(l.toString()));
    }
}