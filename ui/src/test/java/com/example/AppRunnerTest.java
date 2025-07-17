package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.Mockito.*;

class AppRunnerTest {

    @Mock
    private Library lib;

    @InjectMocks
    private AppRunner runner;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void run_shouldInvokeLibraryMethodsInOrder() {
        // Запускаем с пустыми аргументами
        runner.run(new String[0]);

        // Проверяем, что сначала добавили две книги
        verify(lib, times(1)).addBook(argThat(b -> "1984".equals(b.getTitle())));
        verify(lib, times(1)).addBook(argThat(b -> "Crime and Punishment".equals(b.getTitle())));

        // Проверяем, что зарегистрировали двух читателей
        verify(lib).registerMember(argThat(m -> "Alice".equals(m.getName())));
        verify(lib).registerMember(argThat(m -> "Bob".equals(m.getName())));

        // Проверяем выдачу и возврат книги
        InOrder ord = inOrder(lib);
        ord.verify(lib).lendBook("B1", "M2");
        ord.verify(lib).listLoans();
        ord.verify(lib).returnBook("B1", "M2");
        ord.verify(lib).listLoans();

        // Убедитесь, что больше не было взаимодействий
        verifyNoMoreInteractions(lib);
    }

    @Test
    void run_withArgs_shouldStillWork() {
        runner.run(new String[]{"foo", "bar"});
        // просто проверяем, что библиотечные вызовы не зависят от args
        verify(lib, times(2)).addBook(any());
    }
}
