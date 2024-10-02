package graph_data_structure.cycle_detection;

import java.util.ArrayList;

// detecting cycle in undirected graph using DFS
public class undirected_graph {
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
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));
        graph[1].add(new Edge(1, 0));

        // graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        // graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));
        
        graph[5].add(new Edge(5, 4));

    }

    public static boolean detect_cycle_in_undirectedgraph(ArrayList<Edge> graph[], boolean[] vis, int curr,
            int parent_node) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.dest] && e.dest != parent_node) {
                return true;
            }
            if (!vis[e.dest]) {
                if (detect_cycle_in_undirectedgraph(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        boolean[] visited = new boolean[vertices];
        createGraph(graph);
        System.out.println(detect_cycle_in_undirectedgraph(graph, visited, 0, -1));

    }
}
