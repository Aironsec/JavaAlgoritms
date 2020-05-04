package lesson3.Deque;

import lesson3.Queue.QueueImpl;

public class DequeImpl<E> extends QueueImpl<E> {
    public static void main(String[] args) {
        DequeImpl<Integer> dq = new DequeImpl<>(5);
        dq.leftInsert(1);
        dq.leftInsert(2);
        dq.leftInsert(3);
        dq.rightInsert(4);
        System.out.println(dq.leftRemove());
        System.out.println(dq.leftRemove());
        System.out.println(dq.rightRemove());
        System.out.println(dq.leftRemove());
        System.out.println(dq.leftRemove());
    }

    public DequeImpl(int size) {
        super(size);
    }

    public void rightInsert(E value) {
        super.insert(value);
    }

    public E leftRemove() {
        return super.remove();
    }

    public void leftInsert(E value) {
        if (isFull()) {
            System.out.println("Эл. " + value + " не добавлен. Очередь заполнена");
            return;
        }
        if (front - 1 < 0)
            front = data.length;

        data[--front] = value;
        size++;
    }

    public E rightRemove() {
        if (isEmpty()) return null;

        if (rear < 0)
            rear = data.length - 1;

        size--;
        return data[rear--];
    }
}
