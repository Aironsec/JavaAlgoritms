package lesson4.linked;

public class Test {
    public static void main(String[] args) {
//        linked();
//        stackLinked();
//        queueLinked();
        iterator();
    }

    private static void iterator() {
        LinkedList list = new LinkedList();
        LinkIterator iter = new LinkIterator(list);
        list.insert("Витя", 30);
        list.insert("Катя", 20);
//        iter.insertBefore("Артём", 90);
        list.insert("Саша", 40);
        list.insert("Петя", 45);
//        iter.insertAfter("Артём", 10);
        iter.reset();
        iter.getCurrent().display();
//        list.display();
    }

    public static void linked(){
        LinkedList list = new LinkedList();
        list.insert("Витя", 30);
        list.insert("Катя", 20);
        list.insert("Саша", 40);
        list.insertLast("Петя", 45);
//        list.delete();
//        list.delete();
//        list.find("Катя").display();
//        list.delete("Катя").display();
        list.display();
    }

    public static void stackLinked() {
        StackLinked stackLink = new StackLinked();
        stackLink.push("Коля", 20);
        stackLink.push("Валя", 45);
        stackLink.push("Оля", 40);
        stackLink.push("Серёжа", 60);
        stackLink.pop();
        stackLink.display();
    }

    public static void queueLinked() {
        QueueLinked queueLink = new QueueLinked();
        queueLink.insert("Коля", 20);
        queueLink.insert("Валя", 45);
        queueLink.insert("Оля", 40);
        queueLink.insert("Серёжа", 60);
        queueLink.remove();
        queueLink.display();
    }
}
