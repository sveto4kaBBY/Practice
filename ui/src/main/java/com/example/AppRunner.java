package com.example;

public class AppRunner {
    private final Library lib;

    public AppRunner(Library lib) {
        this.lib = lib;
    }

    public void run(String[] args) {
        System.out.println("----------------------------------------");
        System.out.println("Welcome to the Library Application!");
        System.out.println("----------------------------------------");

        lib.addBook(new Book("B1", "1984", "George Orwell"));
        lib.addBook(new Book("B2", "Crime and Punishment", "Fyodor Dostoevsky"));
        System.out.println("All books have been added to the library");

        lib.registerMember(new Member("M1", "Alice"));
        lib.registerMember(new Member("M2", "Bob"));

        lib.lendBook("B1", "M2");
        lib.listLoans();

        lib.returnBook("B1", "M2");
        lib.listLoans();
    }
}
