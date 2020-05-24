package lesson4.linked;

public class LinkedList {
    private Link first;
    private Link last;

    public LinkIterator getIterator (LinkedList list){
        return new LinkIterator(this);
    }

    public Link getFirst() {
        return first;
    }

    public void setFirst(Link first) {
        this.first = first;
    }

    public Link getLast() {
        return last;
    }

    public void setLast(Link last) {
        this.last = last;
    }

    public LinkedList() {
        this.first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(String name, int age){
        Link newLink = new Link(name, age);
        if (isEmpty()) last = newLink;
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(String name, int age){
        Link newLink = new Link(name, age);
        if (isEmpty()){
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }


    public Link delete(){
        if (isEmpty()) return null;
        Link temp = first;
        if (first.next == null) last = null;
        first = first.next;
        return temp;
    }

    public void display()   {
        Link current = first;
        while(current != null)
        {
            current.display();
            current = current.next;
        }
    }

    public Link find(String name){
        Link current = first;
        while(current.getName() != name){
            if(current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public Link delete(String name){
        Link current = first;
        Link previous = first;
        while(current.getName() != name){
            if(current.next == null)
                return null;
            else{
                previous = current;
                current = current.next;
            }
        }
        if(current == first)
            first = first.next;
        else
            previous.next = current.next;
        return current;
    }
}
