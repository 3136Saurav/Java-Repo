package competitiveProgramming;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDirected {
    private static class Graph{
        private int V;
        private List<Integer>[] adj;

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList[V];
            for (int i=0; i<V; i++)
                adj[i] = new ArrayList<>();
        }

        public void addEdges(int u, int v) {
            this.adj[u].add(v);
        }
    }

    public static boolean hasCycle_rec(List<Integer>[] graph, int currNode, boolean[] visited) {
        if (visited[currNode]) return true;
        else visited[currNode] = true;

        for (int i=0; i<graph[currNode].size(); i++) {
            if (hasCycle_rec(graph, graph[currNode].get(i), visited)) return true;
        }
        visited[currNode] = false;
        return false;
    }

    public static boolean hasCycle(List<Integer>[] graph, int V) {
        boolean[] visited = new boolean[V];
        for (int i=0; i<V; i++) {
            if (hasCycle_rec(graph, i, visited)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdges(0, 1);
        graph.addEdges(1, 2);
        graph.addEdges(2, 3);
        graph.addEdges(3, 0);
        graph.addEdges(3, 1);

        if (hasCycle(graph.adj, graph.adj.length))
            System.out.println("Graph contains Cycle");
        else
            System.out.println("Graph does not contains Cycle");
    }
}
