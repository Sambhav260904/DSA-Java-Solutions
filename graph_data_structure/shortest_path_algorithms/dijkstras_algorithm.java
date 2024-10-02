package graph_data_structure.shortest_path_algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

// dijkstras_algorithm  : it is an shortest path finding algorithm from the source to the vertices
// the graph in dijkstras_algorithm is weighted graph
// it is an greedy algorithm
// it is applicable for only positive edge weight in case of negative edge weight it gives wrong answer
public class dijkstras_algorithm {
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

    static class pair implements Comparable<pair> {
        int node;
        int distance;

        public pair(int node, int distance) {
            this.node = node;
            this.distance = distance;

        }

        @Override
        public int compareTo(pair p2) {
            return this.distance - p2.distance; // priority queue sorts the pair in ascending order of distances
            // return p2.distance - this.distance; // priority queue sorts the pair in
            // descending order of distances
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>(); // adding the empty array list to the graph of array
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    // time complexity is O(E + E logV)
    public static int[] dijkstras_algorithm_shortest_path(ArrayList<Edge> graph[], int[] dis, boolean[] vis, int src) {
        // get the node which is not visited and whose distance is shortest

        // then visit the node as true and update the nodes neighbours distance
        PriorityQueue<pair> priority_queue = new PriorityQueue<>();
        priority_queue.add(new pair(src, 0));
        while (!priority_queue.isEmpty()) {
            pair p = priority_queue.poll();
            int curr = p.node;
            if (!vis[curr]) {
                vis[curr] = true;
                for (int j = 0; j < graph[curr].size(); j++) {
                    Edge e = graph[curr].get(j);
                    int u = e.src;   // source
                    int v = e.dest;  // destination 
                    
                    if (dis[v] > dis[u] + e.weight) { // the shortest distance is updated here
                        dis[v] = dis[u] + e.weight; // IT IS AN RELAXATION CODE IN DIJKSTRAS ALGORITHM
                        priority_queue.add(new pair(v, dis[v]));
                    }

                }
            }
        }
        return dis;
    }

    static int vertices = 6;

    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        int src = 0;
        int dist[] = new int[vertices];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        boolean vis[] = new boolean[vertices];

        createGraph(graph);
        int[] res = dijkstras_algorithm_shortest_path(graph, dist, vis, src);
        System.out.println("source | vertex  = shorest-distance from source to vertex");
        for (int i = 0; i < res.length; i++) {
            System.out.println("  " + src + "        " + i + "             " + res[i]);
        }
    }
}