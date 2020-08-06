package competitiveProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class DisjointSetDS {
    private static Scanner sc = new Scanner(System.in);

    private static class Edge {
        private int src, dest;
        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static int findParent(int vertex, int[] parent) {
        if (vertex == parent[vertex])
            return vertex;
        return findParent(parent[vertex], parent);
    }

    public static void unionOpn(int fromP, int toP, int[] parent) {
        fromP = findParent(fromP, parent);
        toP = findParent(toP, parent);
        parent[fromP] = toP;
    }

    public static boolean isCyclic(Edge[] input, int V) {
        int[] parent = new int[V];
        for (int i=0; i<V; i++) parent[i] = i;

        for (Edge e : input) {
            int src = e.src;
            int dest = e.dest;
            int fromP = findParent(src, parent);
            int toP = findParent(dest, parent);
            if (fromP != toP)
                unionOpn(fromP, toP, parent);
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Enter number of Vertices: ");
        int V = sc.nextInt();
        System.out.println("Enter number of Edges: ");
        int E = sc.nextInt();
        Edge[] input = new Edge[E];

        System.out.println("Enter Edges: ");
        for (int i=0; i<E; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            input[i] = new Edge(src, dest);
        }
        
        if(isCyclic(input, V)) {
            System.out.println("Cycle Exists!");
        } else {
            System.out.println("No Cycle Exists!");
        }
    }
}
