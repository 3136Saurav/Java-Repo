package competitiveProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class PrimAlgo {
    private static Scanner sc = new Scanner(System.in);

    public static int findMinVertex(int[] weights, boolean[] visited) {
        int minVertex = -1;
        for (int i=0; i<weights.length; i++) {
            if (!visited[i] && (minVertex == -1 || weights[i] < weights[minVertex]))
                minVertex = i;
        }
        return minVertex;
    }

    public static void prims(int[][] edges, int V, int E) {
        int[] parent = new int[V];
        boolean[] visited = new boolean[V];
        int[] weights = new int[V];

        Arrays.fill(weights, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        weights[0] = 0;
        parent[0] = -1;
        int n = V;

        for (int i=0; i < n-1; i++) {
            int minVertex = findMinVertex(weights, visited);
            visited[minVertex] = true;
            for (int j=0; j < n; j++) {
                if (edges[minVertex][j] != 0 && !visited[j]){
                    if (edges[minVertex][j] < weights[j]) {
                        weights[j] = edges[minVertex][j];
                        parent[j] = minVertex;
                    }
                }
            }
        }

        for (int i=1; i<V; i++) {
            if (parent[i] > i) {
                System.out.println(i + " -> " + parent[i] + ": " + weights[i]);
            } else {
                System.out.println(parent[i] + " -> " + i + ": " + weights[i]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter number of Vertices: ");
        int V = sc.nextInt();
        System.out.println("Enter number of Edges");
        int E = sc.nextInt();
//        Edge[] input = new Edge[E];

        int[][] edges = new int[V][V];
        for (int[] edge : edges)
            Arrays.fill(edge, 0);

        System.out.println("Enter Input: ");
        for (int i=0; i<E; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            edges[src][dest] = weight;
            edges[dest][src] = weight;
        }

        prims(edges, V, E);
    }
}
