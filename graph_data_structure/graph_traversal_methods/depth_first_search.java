// keep going to the first neighbour in DFS
package graph_data_structure.graph_traversal_methods;

import java.util.*;

// THE TIME COMPLEXITY OF THE DFS ALGORITHM IS O(vertices + edges)   //O(V+E)
public class depth_first_search {
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

    // DFS THROUGH RECURSION
    public static void DEPTH_FIRST_SEARCH(int curr_node, ArrayList<Edge> graph[], boolean visited[]) {
        
            System.out.print(curr_node + " ");
            visited[curr_node] = true;
            for (int i = 0; i < graph[curr_node].size(); i++) {
                Edge e = graph[curr_node].get(i);
                if (visited[e.dest]==false) {       
                             
                    DEPTH_FIRST_SEARCH(e.dest, graph, visited);
                }
            }
        }
    

    static int vertices = 7;

    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        boolean visited[] = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {  // if the graph is not connected 
            if (visited[i]==false) {
                DEPTH_FIRST_SEARCH(i, graph, visited);
            }
        }
      
        // DEPTH_FIRST_SEARCH(0, graph, visited);

    }
}
