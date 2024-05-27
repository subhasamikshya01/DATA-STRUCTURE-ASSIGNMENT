package Q10;
import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer>[] adjList;

    public Graph(int v) {
        V = v;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    public void BFS(int startVertex) {
        boolean[] visited = new boolean[V];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.println("Breadth-First Traversal (starting from vertex " + startVertex + "):");

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int adjVertex : adjList[vertex]) {
                if (!visited[adjVertex]) {
                    visited[adjVertex] = true;
                    queue.add(adjVertex);
                }
            }
        }

        System.out.println();
    }
}

public class Q10 {
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.BFS(2);
    }
}
