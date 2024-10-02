package graph_data_structure.cycle_detection;

import java.util.*;

// cycle detection in directed graph
public class cycle_detection_in_graph {
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
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }

    public static boolean detect_cycle_in_directed_graph(ArrayList<Edge> graph[], boolean[] recursive_stack,
            boolean[] visited, int curr_node) {
        visited[curr_node] = true;
        recursive_stack[curr_node] = true;

        // getting the neighbours
        for (int i = 0; i < graph[curr_node].size(); i++) {
            Edge e = graph[curr_node].get(i);
            if (recursive_stack[e.dest]) { // cycle detection
                return true; // cycle is detected
            }
            if (!visited[e.dest]) {
                if (detect_cycle_in_directed_graph(graph, recursive_stack, visited, e.dest)) {
                    return true;
                }
            }

        }
        recursive_stack[curr_node] = false; // when the funtion returns from the call

        return false; // if no cycle is been detected
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        boolean visited[] = new boolean[V];
        boolean recursive_stack[] = new boolean[V];

        createGraph(graph);
        boolean res = detect_cycle_in_directed_graph(graph, recursive_stack, visited, 0);
        System.out.println(res);
    }
}
