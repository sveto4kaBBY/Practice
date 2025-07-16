package com.example;

import java.util.*;

public class Library {
    private final Map<String, Book> books = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();
    private final List<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }
    public void registerMember(Member member) {
        members.put(member.getId(), member);
    }
    public boolean lendBook(String bookId, String memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);
        if (book != null && member != null) {
            loans.add(new Loan(book, member));
            return true;
        }
        return false;
    }
    public boolean returnBook(String bookId, String memberId) {
        Optional<Loan> loan = loans.stream()
                .filter(l -> l.getBook().getId().equals(bookId)
                        && l.getMember().getId().equals(memberId))
                .findFirst();
        if (loan.isPresent()) {
            loans.remove(loan.get());
            return true;
        }
        return false;
    }
    public void listLoans() {
        loans.forEach(System.out::println);
    }
}