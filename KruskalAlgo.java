package competitiveProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class KruskalAlgo {
    private static Scanner sc = new Scanner(System.in);

    private static class Edge{
        private int src;
        private int dest;
        private int weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static int findParent(int vertex, int[] parent) {
        if (vertex == parent[vertex])
            return vertex;
        else return findParent(parent[vertex], parent);
    }

    public static void kruskals(Edge[] input, int V, int E) {
        Arrays.sort(input, (a, b) -> a.weight - b.weight);
        Edge[] output = new Edge[V-1];
        int[] parent = new int[V];
        for (int i=0; i<V; i++) {
            parent[i] = i;
        }

        int i = 0;
        int count = 0;
        while (count != V-1) {
            Edge currEdge = input[i];
            int srcParent = findParent(currEdge.src, parent);
            int dstParent = findParent(currEdge.dest, parent);
            if (srcParent != dstParent) {
                output[count] = currEdge;
                parent[srcParent] = dstParent;
                count++;
            }
            i++;
        }

        int minWeight = 0;
        System.out.println("\nOUTPUT");
        for (int k=0; k<V-1; k++) {
            minWeight += output[k].weight;
            if (output[k].src < output[k].dest) {
                System.out.println(output[k].src + " - " + output[k].dest + " : " + output[k].weight);
            } else {
                System.out.println(output[k].dest + " - " + output[k].src + " : " + output[k].weight);
            }
        }
        System.out.println("Weight of MST: " + minWeight);
    }

    public static void main(String[] args) {
        System.out.println("Enter number of Vertices: ");
        int V = sc.nextInt();
        System.out.println("Enter number of Edges: ");
        int E = sc.nextInt();
        Edge[] input = new Edge[E];

        System.out.println("Input Edges: ");
        for (int i=0; i<E; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            input[i] = new Edge(src, dest, weight);
        }
        kruskals(input, V, E);
    }
}
