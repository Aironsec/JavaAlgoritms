package lesson5.backpack;

public class Item {
    private String name;
    private int wight;
    private int price;

    public Item(String name, int wight, int price) {
        this.name = name;
        this.wight = wight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWight() {
        return wight;
    }

    public int getPrice() {
        return price;
    }
}
