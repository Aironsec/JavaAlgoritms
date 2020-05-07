package lesson4.linked;

public class StackLinked extends LinkedList{

    public void push(String name, int age){
        super.insert(name, age);
    }

    public Link pop(){
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
