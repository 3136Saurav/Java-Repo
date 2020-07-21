package competitiveProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class DetectCycleUndirected {
    private static class Graph{
        private int V;
        private List<Integer>[] adj;
        public Graph(int V) {
            this.V = V;
            this.adj = new ArrayList[V];
            for (int i=0; i<V; i++)
                adj[i] = new ArrayList<>();
        }

        public void addEdge(int u, int v) {
            this.adj[u].add(v);
            this.adj[v].add(u);
        }
    }

    public static boolean hasCycle_Rec(List<Integer>[] adj, int currNode, int parent, boolean[] visited) {
        visited[currNode] = true;
        for (int v : adj[currNode]) {
            if (visited[v] && v!=parent) return true;
            if (!visited[v] && hasCycle_Rec(adj, v, currNode, visited)) return true;
        }

        return false;
    }

    public static boolean hasCycle(List<Integer>[] adj, int V) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        for (int i=0; i<adj.length; i++) {
            if (!visited[i] && hasCycle_Rec(adj, i, -1, visited)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(3, 1);

        if (hasCycle(graph.adj, graph.V))
            System.out.println("Graph contains Cycle");
        else
            System.out.println("Graph does not contains Cycle");

    }
}
