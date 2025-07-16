package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Программа моделирует работу библиотеки:
 * - добавляет книги с указанием автора
 * - регистрирует читателей
 * - позволяет выдавать и принимать книги
 * - отображает список текущих выдач
 */
public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("----------------------------------------");
        System.out.println("Welcome to the Library Application!");
        System.out.println("----------------------------------------");

        log.info("Application started");
        if (args.length > 0) {
            log.info("Received arguments: {}", (Object) args);
        }

        Library lib = new Library();

        lib.addBook(new Book("B1", "1984", "George Orwell"));
        lib.addBook(new Book("B2", "Crime and Punishment", "F. Dostoevsky"));
        System.out.println("All books have been added to the library");

        lib.registerMember(new Member("M1", "Alice"));
        lib.registerMember(new Member("M2", "Bob"));

        lib.lendBook("B1", "M2");
        lib.listLoans();

        lib.returnBook("B1", "M2");
        lib.listLoans();

        log.info("Application finished");
    }
}
