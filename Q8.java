import java.util.*;

class Graph {
    private int V;
    private boolean[][] adjMatrix;
    private LinkedList<Integer>[] adjList;

    public Graph(int v) {
        V = v;
        adjMatrix = new boolean[V][V];
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = true;
        adjMatrix[dest][src] = true;
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    public void displayAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adjMatrix[i][j])
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }

    public void displayAdjacencyList() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (int dest : adjList[i]) {
                System.out.print(dest + " ");
            }
            System.out.println();
        }
    }
}

public class Q8 {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        Graph graph = new Graph(V);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.displayAdjacencyMatrix();
        graph.displayAdjacencyList();
    }
}
