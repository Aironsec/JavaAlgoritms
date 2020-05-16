package lesson7;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орёл");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdges("Тула", "Липецк");
        graph.addEdges("Рязань", "Тамбов");
        graph.addEdges("Калуга", "Орёл");
        graph.addEdges("Воронеж", "Липецк", "Саратов", "Курск");
        graph.addEdges("Тамбов", "Саратов");
        graph.addEdges("Орёл", "Курск");

        System.out.println("Кратчайший путь:");
        graph.bfs("Москва", "Воронеж");
    }

}
