package lesson5;

public class Exponentiation {

    public static void main(String[] args) {
        System.out.println(exp(2, -2));
        System.out.println(exp(2, 8));
        System.out.println(exp(2, 2));
    }

    public static double exp(int x, int y) {
        if (y > 0)
            return x * exp(x, y - 1);
        else if (y < 0)
            return 1 / (x * exp(x, -y - 1));
        else
            return 1;
    }

}
