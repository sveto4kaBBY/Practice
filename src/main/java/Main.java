//Программа моделирует работу библиотеки: добавляет книги с указанием автора, регистрирует читателей,
// позволяет выдавать и принимать книги, а также отображает список текущих выдач.
public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        // Добавляем книги и читателей
        lib.addBook(new Book("B1", "1984", "George Orwell"));
        lib.addBook(new Book("B2", "Crime and Punishment", "Fyodor Dostoevsky"));
        lib.registerMember(new Member("M1", "Alice"));
        lib.registerMember(new Member("M2", "Bob"));

        // Выдаём и возвращаем
        lib.lendBook("B1", "M2");
        lib.listLoans();

        lib.returnBook("B1", "M2");
        lib.listLoans();
    }
}