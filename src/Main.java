/*
программа-помощник баристе
функции
1. хранит список напитков
2. имеет функцию ввода напитка со стандартными занчениями,
   а так же напитка, который ввел пользователь
3. имеет возможность редактирования любого поля любого напитка
4. есть вывод всех напитков в введенном списке
5. реализована функция определения объема напитка
 */

public class Main {
    public static void main(String[] args) {
        Program program = Program.getAppInstance();
        program.run();
    }
}