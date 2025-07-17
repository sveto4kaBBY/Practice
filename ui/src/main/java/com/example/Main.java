/**
 * Программа моделирует работу библиотеки:
 * - добавляет книги с указанием автора
 * - регистрирует читателей
 * - позволяет выдавать и принимать книги
 * - отображает список текущих выдач
 */

package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        log.info("Application started");
        new AppRunner(new Library()).run(args);
        log.info("Application finished");
    }
}
