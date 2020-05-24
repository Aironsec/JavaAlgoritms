package lesson3.Stack;

public class StringRev {
    public static void main(String[] args) {
        String str = "павлин мавлин";
        Stack<Character> strStack = new StackImpl<>(str.length());
        while (!strStack.isFull()) {
            strStack.push(str.charAt(strStack.top() + 1));
        }
        while (!strStack.isEmpty()) {
            System.out.print(strStack.pop());
        }
    }
}
