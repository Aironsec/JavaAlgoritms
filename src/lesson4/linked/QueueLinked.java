package lesson4.linked;

public class QueueLinked extends LinkedList{

    @Override
    public void insert(String name, int age) {
        super.insertLast(name, age);
    }

    public Link remove() {
        return super.delete();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public void display() {
        super.display();
    }
}
