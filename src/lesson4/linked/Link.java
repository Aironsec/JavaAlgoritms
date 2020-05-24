package lesson4.linked;

public class Link {
    private String name;
    private int age;

    public Link next;

    public Link(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Имя: " + name + ", возрвст: " + age);
    }

    public String getName() {
        return name;
    }
}
