import java.io.InputStream;
import java.util.Comparator;
import java.util.Scanner;

public class Drink implements Comparable<Drink>{
    private int volume;
    private double price;
    private String name;
    private String receipt;

    public Drink(int volume, double price, String name, String receipt) {
        setPrice(price);
        setVolume(volume);
        setReceipt(receipt);
        setName(name);
    }

    public Drink() {
        this(0, 0, "null", "null");
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if(volume >= 0) this.volume = volume;
        else System.out.println("Объем не может быть меньше нуля.");
    }

    // перегрузка сеттера, если мы в него передаем поток InputStream
    // запрашивает вводимые данные через этот поток
    public void setVolume(InputStream stream) {
        Scanner scanner = new Scanner(stream);
        System.out.println("Введите объем: ");
        if(scanner.hasNextInt()) this.setVolume(scanner.nextInt());
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price >= 0) this.price = price;
        else System.out.println("Цена не может быть меньше нуля.");
    }
    // перегрузка сеттера, если мы в него передаем поток InputStream
    // запрашивает вводимые данные через этот поток
    public void setPrice(InputStream stream) {
        Scanner scanner = new Scanner(stream);
        System.out.println("Введите цену: ");
        if(scanner.hasNextDouble()) this.setPrice(scanner.nextDouble());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // перегрузка сеттера, если мы в него передаем поток InputStream
    // запрашивает вводимые данные через этот поток
    public void setName(InputStream stream) {
        Scanner scanner = new Scanner(stream);
        System.out.println("Введите введите название напитка: ");
        this.setName(scanner.nextLine());
    }


    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    // перегрузка сеттера, если мы в него передаем поток InputStream
    // запрашивает вводимые данные через этот поток
    public void setReceipt(InputStream stream) {
        Scanner scanner = new Scanner(stream);
        System.out.println("Введите рецепт:");
//        scanner.skip("\n");
        String buffer = "";
        boolean isWork = true;
        do {
            String bufferForCheck = scanner.nextLine();
            buffer = String.format("%s\n%s", buffer, bufferForCheck);
            if (bufferForCheck.equals("") && buffer.length() != 0) {
                System.out.println(buffer);
                isWork = false;
            }
        } while (isWork);
        this.setReceipt(buffer);
    }

    private String portionSize() { // пользовательская функция определния объема
        String portion;
        if(volume >= 300) portion = "Large";
        else if (volume >= 100) portion = "Medium";
        else portion = "Small";
        return portion;
    }

    @Override
    public String toString() { // при преобразовании всего объекта в string
        return "Drink{" +
                "volume=" + volume +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", receipt='" + receipt + '\'' +
                "}\n" + portionSize();
    }

    @Override
    public int compareTo(Drink drinkObj) { //реализация сортировки по любому полю
        return Comparators.NAME.compare(this, drinkObj);
    }


    public static class Comparators {

        public static Comparator<Drink> NAME = Comparator.comparing(obj -> obj.name); // по полю NAME
        public static Comparator<Drink> RECEIPT = Comparator.comparingInt(obj -> obj.receipt.length()); // Receipt
        public static Comparator<Drink> PRICE = (obj1, obj2) -> (int) (obj1.price - obj2.price); // PRICE
        public static Comparator<Drink> VOLUME = Comparator.comparingInt(obj -> obj.volume); // volume
    }
}
