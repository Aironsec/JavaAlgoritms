package lesson3.Stack;

public class StackImpl<E> implements Stack<E>{

    public static void main(String[] args) {
        Stack<Integer> intStack = new StackImpl<>(5);

        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);
        intStack.push(5);
        intStack.push(6);

        while (!intStack.isEmpty()){
            System.out.printf("%d ", intStack.pop());
        }
    }

    private final int maxSize;
    private final E[] data;
    private int top;

    @SuppressWarnings("unchecked")
    public StackImpl(int size) {
        maxSize = size;
        data = (E[]) new Object[size];
        top = -1;
    }

    @Override
    public void push(E value) {
        if (!isFull()) data[++top] = value;
        else System.out.println("Стек заполнен: размер - " + maxSize + " эл.");
    }

    @Override
    public int size() {
        return maxSize;
    }

    @Override
    public int top() {
        return top;
    }

    @Override
    public E pop() {
        if (!isEmpty()) return data[top--];
        System.out.println("Стек пуст");
        return null;
    }

    @Override
    public E peek() {
        return data[top];
    }
}
