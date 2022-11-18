import java.io.InputStream;
import java.util.*;

public class Program {
    private static ArrayList<Drink> drinks = new ArrayList<>(); //массив с координатами точек, введенными юзером или рандомом
    private static boolean isWork = true,
            isChanged = false,
            isProcessed = false;
    private static final Program appInstance = new Program(); // создается только один экземплр класса

    private Program() {
    }

    public static Program getAppInstance() {
        return appInstance;
    } // возвращает вход для синглтона


    public void run() { //основной метод программы, соединяющий всё вместе
        Menu menu = new Menu(); //отвечает за пользовательский интерфейс
        Scanner scanner = new Scanner(System.in);
        do {
            menu.execute();// выводит для пользователя необходимый текст(пункты меню) для взаимодействия с программой
            int choice = scanner.nextInt();

            // пользователь вводит число, соответствующее пункту меню
            Menu.MenuItems menuItem = Menu.MenuItems.values()[choice];
            // затем объект menuItem cравнивается с объектами enum из класса Menu
            // и выполняются соответствующие действия
            switch (menuItem) {
                case USER_IN -> {
                    addUserDrink();
                    this.setIsChanged(true); // поднимаем флаг изменения данных
                    this.setIsProcessed(false); // опускаем флаг что данные уже обработанны
                }
                case NUll_IN -> {
                    addNullDrink(); // метод ввода рандомных точек в массив
                    this.setIsChanged(true);
                    this.setIsProcessed(false);
                }
                case SORT -> { // сортировка реализованная через переопределнные Comparators класса
                    scanner.skip("\n");
                    MenuSort sortingMenu = new MenuSort();
                    do {
                        sortingMenu.execute();
                        int sortChoice = -1;
                        if(scanner.hasNextInt()) sortChoice = scanner.nextInt();
                        MenuSort.MenuItems sortMenuItem = MenuSort.MenuItems.values()[sortChoice];
                        if (sortMenuItem != MenuSort.MenuItems.BACK) {
                            System.out.println("sds");
                            switch (sortMenuItem) {
                                case SORT_NAME -> drinks.sort(Drink.Comparators.NAME);
                                case SORT_VOLUME -> drinks.sort(Drink.Comparators.VOLUME);
                                case SORT_RECEIPT -> drinks.sort(Drink.Comparators.RECEIPT);
                                case SORT_PRICE -> drinks.sort(Drink.Comparators.PRICE);
                            }
                            this.setIsChanged(false);
                            this.setIsProcessed(true);
                        }
                        else break;
                    } while(!isProcessed);
                }
                case REDACTOR -> {// редактор
                    scanner.skip("\n");
                    System.out.println("Введите индекс напитка: ");
                    if (scanner.hasNextInt()) choice = scanner.nextInt();
                    if(choice < 0 || choice > drinks.size() - 1) {
                        System.out.println("Введите адекватное значение индекса.");
                        break;
                    }
                    Drink userDrink = drinks.get(choice);
                    boolean editIsWork = true;
                    MenuEditing editMenu = new MenuEditing();
                    do {
                        editMenu.execute();
                        int sortChoice = -1;
                        if(scanner.hasNextInt()) sortChoice = scanner.nextInt();
                        MenuEditing.MenuItems editMenuItem = MenuEditing.MenuItems.values()[sortChoice];
                        switch (editMenuItem) {
                            case EDIT_NAME -> userDrink.setName(System.in);
                            case EDIT_PRICE -> userDrink.setPrice(System.in);
                            case EDIT_RECEIPT -> userDrink.setReceipt(System.in);
                            case EDIT_VOLUME -> userDrink.setVolume(System.in);
                            case BACK -> editIsWork = false;
                        }
                        this.setIsChanged(false);
                        this.setIsProcessed(true);
                    } while(editIsWork);
                }

                case OUTPUT_RESULT -> { //вывод списка напитков
                    if (isProcessed) printListDrinks(); // мы не можем вывести данные если они не были обработаны
                    else
                        System.out.println("Пожалуйста, введите что-нибудь в список напитков " +
                                "или произведите сортировку измененного массива");
                }
                case EXIT -> isWork = false; // опускаем флаг о возможности работы программы
            }
        } while (isWork);


    }
    private void setIsChanged ( boolean choice) {
        isChanged = choice;
    }

    private void setIsProcessed(boolean choice) {
        isProcessed = choice;
    }
    private void addNullDrink() { // "добавление в конец списка нулевого напитка"
        //используем конструктор по умолчанию
        Drink nullDrink = new Drink();
        drinks.add(nullDrink);
    }

    private void addUserDrink() { // добавление пользовательского напитка в конец списка напитков
        Drink tempDrink = manualCreateDrink();
        //по заданию необходимо показать умение пользоваться конструктором с параметрами
        Drink userDrink = new Drink(tempDrink.getVolume(),
                                    tempDrink.getPrice(),
                                    tempDrink.getName(),
                                    tempDrink.getReceipt());
        //добавляем введенный пользователем напиток в список напитков
        drinks.add(userDrink);
    }
    private Drink manualCreateDrink() { // пользовательский ввод напитка
        Drink tempDrink = new Drink();
        //в сеттерах проверяем на валидность введенные данные
        InputStream stream = System.in;
        tempDrink.setName(stream);
        tempDrink.setReceipt(stream);
        tempDrink.setPrice(stream);
        tempDrink.setVolume(stream);
        return tempDrink;
    }

    private void printListDrinks() { // вывод списка напитков
        for (Drink el:drinks) {
            int i = drinks.indexOf(el);
            printDrink(i, el);
        }
    }

    private void printDrink(int index, Drink element) {
        System.out.println(index + ". " + element +";");
    }
}
