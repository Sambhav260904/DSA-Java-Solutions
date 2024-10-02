//to find the scc strongly connected component
// the approach used here is reverse_DFS  
// it is possible only in directed graph
// time complexity is O(V+E)  

package graph_data_structure.strongly_connected_component;

import java.util.*;

public class KOSARAJUS_ALGORITHM {
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
        // graph[0].add(new Edge(0, ));

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

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

    // performing dfs on the transpose graph
    public static void dfs(int curr_node, ArrayList<Edge> transpose_graph[], boolean visited[]) {

        System.out.print(curr_node + " ");
        visited[curr_node] = true;
        for (int i = 0; i < transpose_graph[curr_node].size(); i++) {
            Edge e = transpose_graph[curr_node].get(i);
            if (visited[e.dest] == false) {

                dfs(e.dest, transpose_graph, visited);
            }
        }
        // System.out.println();

    }

    public static void kosaraju_algorithm(ArrayList<Edge> graph[], int v) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[v];
        // step 1 - topological sort
        for (int i = 0; i < v; i++) { // in the case of non connected graph
            if (!visited[i]) {
                topological_sort_graph(graph, i, visited, st);
            }
        }

        // step 2 - transpose the graph
        ArrayList<Edge> transpose_graph[] = new ArrayList[vertices];
        for (int i = 0; i < transpose_graph.length; i++) {
            visited[i] = false;
            transpose_graph[i] = new ArrayList<>(); // adding the empty array list to the graph of array
        }

        // transposing the graph

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose_graph[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // step 3 - dfs on the transpose graph
        while (!st.isEmpty()) {
            int curr = st.pop();
            if (!visited[curr]) {
                dfs(curr, transpose_graph, visited);
                System.out.println();
            }
        }

    }

    static int vertices = 5;

    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[vertices];

        createGraph(graph);
        kosaraju_algorithm(graph, vertices);

    }

}