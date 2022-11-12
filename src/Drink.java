import java.util.ArrayList;
import java.util.Comparator;

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

    public double getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if(volume >= 0) this.volume = volume;
        else System.out.println("Объем не может быть меньше нуля.");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price >= 0) this.price = price;
        else System.out.println("Цена не может быть меньше нуля.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    private String portionSize() {
        String portion;
        if(volume >= 300) portion = "Large";
        else if (volume >= 100) portion = "Medium";
        else portion = "Small";
        return portion;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "volume=" + volume +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", receipt='" + receipt + '\'' +
                "}\n" + portionSize();
    }

    @Override
    public int compareTo(Drink drinkObj) {
        return Comparators.NAME.compare(this, drinkObj);
    }


    public static class Comparators {

        public static Comparator<Drink> NAME = new Comparator<Drink>() {
            @Override
            public int compare(Drink obj1, Drink obj2) {
                return obj1.name.compareTo(obj2.name);
            }
        };
        public static Comparator<Drink> RECEIPT = new Comparator<Drink>() {
            @Override
            public int compare(Drink obj1, Drink obj2) {
                return obj1.receipt.compareTo(obj2.receipt);
            }
        };
        public static Comparator<Drink> PRICE = new Comparator<Drink>() {
            @Override
            public int compare(Drink obj1, Drink obj2) {
                return (int) (obj1.price - obj2.price);
            }
        };
        public static Comparator<Drink> VOLUME = new Comparator<Drink>() {
            @Override
            public int compare(Drink obj1, Drink obj2) {
                return obj1.volume - obj2.volume;
            }
        };
    }
}
