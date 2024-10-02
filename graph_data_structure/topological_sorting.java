package graph_data_structure;
// it is used for directed acyclic graph(DAG) is a directed graph with no cycles.

// it is used for DAG'S
// the topological sorted order shows the dependencies of the nodes

// for topological sorting we use dfs  //modified dfs
import java.util.*;

public class topological_sorting {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>(); // adding the empty array list to the graph of array
        }
        // graph[0].add(new Edge(0, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        // graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(2, 1));

        graph[2].add(new Edge(2, 3));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    public static void topological_sort_graph(ArrayList<Edge> graph[], int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topological_sort_graph(graph, e.dest, vis, s);
            }
        }
        s.push(curr); // adding in the stack the curr value after the return of function call
    }

    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        boolean[] visited = new boolean[vertices];
        Stack<Integer> st = new Stack<>();
        createGraph(graph);
        for (int i = 0; i < vertices; i++) { // in the case of non connected graph
            if (!visited[i]) {
                topological_sort_graph(graph, i, visited, st);
            }
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

}
