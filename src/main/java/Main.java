/**
 * Программа моделирует работу библиотеки:
 * - добавляет книги с указанием автора
 * - регистрирует читателей
 * - позволяет выдавать и принимать книги
 * - отображает список текущих выдач
 */
public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        System.out.println("\n=== Инициализация библиотеки ===");

        // Добавление книг
        System.out.println("\nДобавление книг в каталог:");
        lib.addBook(new Book("B1", "1984", "George Orwell"));
        lib.addBook(new Book("B2", "Преступление и наказание", "Фёдор Достоевский"));
        System.out.println("Книги успешно добавлены");

        // Регистрация читателей
        System.out.println("\nРегистрация читателей:");
        lib.registerMember(new Member("M1", "Алиса"));
        lib.registerMember(new Member("M2", "Боб"));
        System.out.println("Читатели зарегистрированы");

        // Операции с книгами
        System.out.println("\n=== Работа с книгами ===");

        System.out.println("\nВыдача книги '1984' читателю Боб:");
        lib.lendBook("B1", "M2");

        System.out.println("\nТекущие выдачи:");
        lib.listLoans();

        System.out.println("\nВозврат книги '1984':");
        lib.returnBook("B1", "M2");

        System.out.println("\nИтоговый список выдач:");
        lib.listLoans();

        System.out.println("\n=== Работа завершена ===");
    }
}