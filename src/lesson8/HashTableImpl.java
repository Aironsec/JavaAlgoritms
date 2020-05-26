package lesson8;

import java.util.LinkedList;
import java.util.List;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    static class Item<K, V> {
        private final K key;
        private V value;
        private List<Item<K, V>> items;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
            this.items = new LinkedList<>();
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private final Item<K, V>[] data;
    private int size;
    private Item<K, V> currentItem;

    public HashTableImpl(int maxSize) {
        this.data = new Item[maxSize * 2];
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);
        Item<K, V> newItem = new Item<>(key, value);

        if (data[index] == null) {
            data[index] = new Item<>(null, null);
            data[index].items.add(newItem);
            size++;
            return true;
        }

        List<Item<K, V>> listItem = data[index].items;

        for (Item<K, V> item : listItem) {
            if (keyExist(item, newItem, value) || collision(item, newItem, listItem)) {
                return true;
            }
        }
        return false;
    }

    private boolean keyExist(final Item<K, V> item,
                             final Item<K, V> newItem,
                             final V value) {
        if (newItem.key.equals(item.key) &&
                !newItem.value.equals(item.value)) {
            item.value = value;
            return true;
        }
        return false;
    }

    private boolean collision(final Item<K, V> item,
                              final Item<K, V> newItem,
                              final List<Item<K, V>> listItem) {
        if (hashFunc(item.key) == hashFunc(newItem.key) &&
                !newItem.key.equals(item.key)) {
            listItem.add(newItem);
            return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }
        return currentItem.value;
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }
        List<Item<K, V>> listItem = data[index].items;

        listItem.remove(currentItem);
        return currentItem.value;
    }

    private int indexOf(K key) {
        currentItem = null;
        int index = hashFunc(key);
        if (data[index] != null) {
            List<Item<K, V>> listItem = data[index].items;
            for (Item<K, V> item : listItem) {
                if (item.key.equals(key)) {
                    currentItem = item;
                    return index;
                }
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    protected int getStep(K key) {
        return 1;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) System.out.printf("%d = %s", i, data[i].items);
            else System.out.printf("%d = %s", i, data[i]);
            System.out.println();
        }
        System.out.println("----------");
    }
}
