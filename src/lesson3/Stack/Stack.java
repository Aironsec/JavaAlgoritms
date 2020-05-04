package lesson3.Stack;

public interface Stack<E> {
    default boolean isEmpty() {
        return top() == -1;
    };

    default boolean isFull() {
        return top() == size() - 1;
    };

    void push (E value);

    int size();

    int top();

    E pop();

    E peek();
}
