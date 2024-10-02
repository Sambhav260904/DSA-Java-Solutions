package graph_data_structure;

// problem = all the paths from the source to the target
import java.util.*;

public class problem1 {
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
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        // graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));

    }

    public static void DEPTH_FIRST_SEARCH(ArrayList<Edge> graph[], boolean visited[], String path, int curr_node) {
        if (curr_node == target) { // base case
            System.out.println(path);
            return;
        }

        for (int i = 0; i < graph[curr_node].size(); i++) {
            Edge e = graph[curr_node].get(i);
            if (visited[e.dest] == false) {
                visited[curr_node] = true;
                DEPTH_FIRST_SEARCH(graph, visited, path + e.dest, e.dest);
                visited[curr_node] = false;
            }
        }
    }

    static int vertices = 7;
    static int source = 0;
    static int target = 5;

    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        boolean visited[] = new boolean[vertices];

        System.out.println("the all  possible paths from the source to the destination are: ");
        DEPTH_FIRST_SEARCH(graph, visited, "0", source);

    }
}
