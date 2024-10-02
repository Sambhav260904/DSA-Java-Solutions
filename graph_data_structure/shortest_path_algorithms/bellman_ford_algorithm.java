package graph_data_structure.shortest_path_algorithms;

// it is an solution for drawback of dijkstras algorithm where the negative weight can be considered and it gives correct answer

// BFA it does not work for negative weight cycles
import java.util.*;

class bellman_ford_algorithm {
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>(); // adding the empty array list to the graph of array
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
        // graph[4].add(new Edge(4, 1, -10)); if we remove the above edge and add this edge it forms negative weighted cycle by which we cannot find the shortest path from source to all vertices

    }

    public static void bellman_ford_algo(int[] dist, ArrayList<Edge> graph[], int src) {


        // loop for vertices from src to verteces-1
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            edges.addAll(graph[i]);
        }
        for (int i = 0; i < vertices - 1; i++) { // O(V)
            // O(E)
            for (Edge edge : edges) {
                int u = edge.src;
                int v = edge.dest;

                if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + edge.weight) {
                    dist[v] = dist[u] + edge.weight; // relaxation code
                }

            }
        }
        

         // Check for negative weight cycles  if they exist in the graph then we cannot find the shortest path hence we have to return
         for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int weight = edge.weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weighted cycle so we cannot find the shortest path from source to all vertices");
                return;
            }
        }


        // printing the distances
        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i]);
        } 



    }

    static int vertices = 5;

    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        int src = 0;
        int dist[] = new int[vertices];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        createGraph(graph);
        bellman_ford_algo(dist, graph, src);
    }
}