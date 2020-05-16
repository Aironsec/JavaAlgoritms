package lesson6;

import java.util.Random;

public class Test6 {

    public static boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    public static void main(String[] args) {
        int countBalance = 0;
        int count = 20;

        Random rand = new Random();
        TreeImpl<Integer> tree;

        for (int i = 0; i < count; i++) {
            tree = new TreeImpl<>(4);
            for (int j = 0; j < 14; j++) {
                tree.add(rand.nextInt(200) - 100);
            }
            if (isBalanced(tree.getRoot())) {
                countBalance++;
            }
        }
        System.out.println("Количество сбалансированных деревьев = " + countBalance);
        System.out.println("Сбалансировано: " + ((countBalance / (count * 1.0)) * 100) + "%");
    }
}
