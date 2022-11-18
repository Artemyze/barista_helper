import java.util.stream.IntStream;

public class Menu {
    protected enum MenuItems { // перечисение выбора пользователя в меню
        USER_IN("Пользовательский ввод"),
        NUll_IN("Добавление \"пустого\" напитка"),
        REDACTOR("Редактирование полей"),
        SORT("Сортировка"),
        OUTPUT_RESULT("Вывод результата"),
        EXIT("Выход");
        final String description; // описание действия пункта меню
        MenuItems(String annotation){
            this.description = annotation;
        }
    }

    public Menu(){}
    public void execute() {// запускает вывод на экран меню пользователя
        printMenu();
    }
    protected void printMenu(){
        // проходимся по всему enum и выводим описание каждого пункта меню
        // так же выодится значение пункта, по которому пользователь может выбрать соответствующее действие меню
        IntStream.range(0, MenuItems.values().length).forEach(i -> {
            MenuItems menuItem = MenuItems.values()[i];
            System.out.println(i + ". " + menuItem.description);
        });
        System.out.println("Введите номер пункта меню: ");
    }
}

class MenuSort extends Menu {

    protected enum MenuItems {
        SORT_NAME("Сортировка по полю Имя"),
        SORT_RECEIPT("Сортироввка по полю Рецепт"),
        SORT_VOLUME("Сортировка по полю Объем"),
        SORT_PRICE("Сортировка по полю Цена"),
        BACK("Назад");
        final String description; // описание действия пункта меню
        MenuItems(String annotation){
            this.description = annotation;
        }
    }
    public MenuSort(){}
    @Override
    protected void printMenu(){
        // проходимся по всему enum и выводим описание каждого пункта меню
        // так же выодится значение пункта, по которому пользователь может выбрать соответствующее действие меню
        IntStream.range(0, MenuItems.values().length).forEach(i -> {
            MenuItems menuItem = MenuItems.values()[i];
            System.out.println(i + ". " + menuItem.description);
        });
        System.out.println("Введите номер пункта меню: ");
    }
}

class MenuEditing extends Menu {

    protected enum MenuItems {
        EDIT_NAME("Редактирование поля Имя"),
        EDIT_RECEIPT("Редактирование поля Рецепт"),
        EDIT_VOLUME("Редактирование поля Объем"),
        EDIT_PRICE("Редактирование поля Цена"),
        BACK("Назад");
        final String description; // описание действия пункта меню
        MenuItems(String annotation){
            this.description = annotation;
        }
    }
    public MenuEditing(){}
    @Override
    protected void printMenu(){
        // проходимся по всему enum и выводим описание каждого пункта меню
        // так же выодится значение пункта, по которому пользователь может выбрать соответствующее действие меню
        IntStream.range(0, MenuItems.values().length).forEach(i -> {
            MenuItems menuItem = MenuItems.values()[i];
            System.out.println(i + ". " + menuItem.description);
        });
        System.out.println("Введите номер пункта меню: ");
    }
}