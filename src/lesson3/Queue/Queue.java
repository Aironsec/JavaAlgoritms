package lesson3.Queue;

public interface Queue<E> {
    boolean isFull();

    default boolean isEmpty() {
        return size() == 0;
    }

    int size();

    void insert(E value);

    E remove();

    E peek();
}
