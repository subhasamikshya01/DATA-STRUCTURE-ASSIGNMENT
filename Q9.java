package Q9;
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

    public void readGraph(Scanner scanner) {
        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();
        System.out.println("Enter edges (source destination):");
        for (int i = 0; i < E; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            addEdge(src, dest);
        }
    }

    public void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int adjVertex : adjList[v]) {
            if (!visited[adjVertex]) {
                DFSUtil(adjVertex, visited);
            }
        }
    }

    public void DFS(int startVertex) {
        boolean[] visited = new boolean[V];
        System.out.println("Depth-First Traversal (starting from vertex " + startVertex + "):");
        DFSUtil(startVertex, visited);
        System.out.println();
    }
}

public class Q9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        Graph graph = new Graph(V);
        graph.readGraph(scanner);

        System.out.print("Enter the starting vertex for DFS: ");
        int startVertex = scanner.nextInt();
        graph.DFS(startVertex);

        scanner.close();
    }
}
