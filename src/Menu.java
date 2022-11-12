
public class Menu {
    enum MenuItems { // перечисение выбора пользователя в меню
        USER_IN("Пользовательский ввод"),
        NUll_IN("Добавление \"пустого\" напитка"),
        REDACTOR("Редактирование полей"),
        SORT("Сортировка"),
        OUTPUT_RESULT("Вывод результата"),
        EXIT("Выход");
        final String description; // описание действия пункта меню
        private MenuItems(String annotation){
                this.description = annotation;
            }
    }

    public Menu(){}

    public void execute() {// запускает вывод на экран меню пользователя
        printMenu();
    }
    private void printMenu(){
        // проходимся по всему enum и выводим описание каждого пункта меню
        // так же выодится значение пункта, по которому пользователь может выбрать соответствующее действие меню
        for (int i = 0; i < MenuItems.values().length; i++){
            MenuItems menuItem = MenuItems.values()[i];
            System.out.println(i + ". " + menuItem.description);
        }
        System.out.println("Введите номер пункта меню: ");
    }
}