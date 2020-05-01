package lesson2.sorts;

public interface ArrControl {

    void replaceIndex(int value,int index) throws Throwable;

    void add(int value);

    boolean drop(int value);

    boolean find(int value);

    void random();

    void sortBubble();

    void sortBubbleDeleteDuplicate();

    void sortSelect();

    void sortInsert();
}
