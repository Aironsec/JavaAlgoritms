package lesson3.Queue;

public class QueueImpl<E> implements Queue<E>{

    /*public static void main(String[] args) {
        Queue<Integer> qu = new QueueImpl<>(5);

        qu.insert(1);
        qu.insert(2);
        qu.insert(3);
        qu.insert(4);
        qu.insert(5);
        qu.insert(6);
        System.out.printf("%d ", qu.remove());
        System.out.printf("%d ", qu.remove());
        System.out.printf("%d ", qu.remove());
        System.out.println();
        qu.insert(7);
        qu.insert(8);
        System.out.printf("%d ", qu.remove());
        System.out.println();

        while (!qu.isEmpty()) {
            System.out.printf("%d ", qu.remove());
        }
        System.out.println(qu.peek());
    }*/

    protected final E[] data;
    protected int size;
    protected int front;
    protected int rear;

    @SuppressWarnings("unchecked")
    public QueueImpl(int size) {
        data = (E[]) new Object[size];
        front = 0;
        rear = -1;
    }

    @Override
    public boolean isFull() {
        return data.length == size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(E value) {
        if (isFull()) {
            System.out.println("Эл. " + value + " не добавлен. Очередь заполнена");
            return;
        }
        if (rear == data.length - 1) rear = -1;
        data[++rear] = value;
        size++;
    }

    @Override
    public E remove() {
        if (isEmpty()) return null;
        E item = data[front++];
        if (front == data.length) front = 0;
        size--;
        return item;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return data[front];
    }
}
