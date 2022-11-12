import java.util.ArrayList;
import java.util.Scanner;
public class Program {
    private static final int ZERO = 0;
    private static ArrayList<Drink> drinks = new ArrayList<Drink>(); //массив с координатами точек, введенными юзером или рандомом
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
                    addNullDrink(); // пользовательский ввод точек в массив Dot2d this.arrDotsIn[]
                    setIsChanged(true); // поднимаем флаг изменения данных
                    setIsProcessed(false); // опускаем флаг что данные уже обработанны
                }
                case NUll_IN -> {
                    addNullDrink(); // метод ввода рандомных точек в массив
                    setIsChanged(true);
                    setIsProcessed(false);
                }
                case SORT -> {
                    if (isChanged) {
                        setIsChanged(false);
                        setIsProcessed(true);
                    }
                }
                case OUTPUT_RESULT -> {
                    if (isProcessed) System.out.println(drinks); // мы не можем вывести данные если они не были обработаны
                    else
                        System.out.println("Пожалуйста, введите что-нибудь в список напитков."); // иначе выкидываем исключение
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

    private void addNullDrink() {
        drinks.add(new Drink());
    }
}
