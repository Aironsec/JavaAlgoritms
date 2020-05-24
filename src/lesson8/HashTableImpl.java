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

        public List<Item<K, V>> getItems() {
            return items;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
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

        if (data[index].key == null) {
            data[index] = new Item<>(null, null);
            data[index].items.add(newItem);
            size++;
            return true;
        }
        
        List<Item<K, V>> listItem = data[index].getItems();

        for (Item<K, V> item : listItem) {
            if (keyExist(item, newItem, value) || collision(item, newItem, listItem)) {
                return true;
            }
        }
        return false;
    }

    private boolean keyExist(final Item<K,V> item,
                             final Item<K,V> newItem,
                             final V value) {
        if (newItem.key.equals(item.key) &&
                !newItem.value.equals(item.value)) {
            item.value = value;
            return true;
        }
        return false;
    }

    private boolean collision(final Item<K,V> item,
                              final Item<K,V> newItem,
                              final List<Item<K, V>> listItem) {
        if (hashFunc(item.key) == hashFunc(newItem.key) ) {
            // TODO: 24.05.2020  
            return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return index != -1 ? data[index].value : null;
    }
    
    @Override
    public V remove(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }

        Item<K, V> item = data[index];
        data[index] = null;
        size--;
        return item.value;
    }

    private int indexOf(K key) {
        int index = hashFunc(key);
        int count = 0;
        while (data[index] != null && count < data.length) {
            Item<K, V> item = data[index];
            if (item.key.equals(key)) {
                return index;
            }
            count++;
            index += getStep(key);
            index %= data.length;
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
            System.out.printf("%d = [%s]", i, data[i]);
            System.out.println();
        }
        System.out.println("----------");
    }
}
