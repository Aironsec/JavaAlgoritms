package lesson5.backpack;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Книга", 1, 600));
        items.add(new Item("Бинокль", 2, 5000));
        items.add(new Item("Аптечка", 4, 1500));
        items.add(new Item("Ноутбук", 2, 40000));
        items.add(new Item("Котелок", 1, 500));
        Backpack backpack = new Backpack(5);
        backpack.getResult(items);
        for (Item item : backpack.getItemsResult()) {
            System.out.println(item.getName() + " " + item.getWight() + " " + item.getPrice());
        }
    }

    private final int maxWight;
    private List<Item> itemsResult;

    private int currentMaxSumPrice = 0;

    public Backpack(int maxWight) {
        this.maxWight = maxWight;
    }

    public int sumPrice(List<Item> items) {
        int sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public int sumWight(List<Item> items) {
        int sum = 0;
        for (Item item : items) {
            sum += item.getWight();
        }
        return sum;
    }

    public List<Item> getItemsResult() {
        return itemsResult;
    }

    public void getResult(List<Item> items) {
        if (items.size() == 0) return;

        if (sumWight(items) <= maxWight && sumPrice(items) > currentMaxSumPrice) {
            currentMaxSumPrice = sumPrice(items);
            itemsResult = items;
        }

        for (int i = 0; i < items.size(); i++) {
            List<Item> tmp = new ArrayList<>(items);
            tmp.remove(i);
            getResult(tmp);
        }

    }
}
