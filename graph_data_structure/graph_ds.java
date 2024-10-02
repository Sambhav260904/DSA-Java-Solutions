
/**  storing the graph:
    1.adjacency list    mostly used
    2.adjacency matrix
    3.edge list
    4.2D matrix(IMPLICIT GRAPH)
**/
package graph_data_structure;

import java.util.*;

// adjacency list = list of lists where the edges are stored in lists  
public class graph_ds {
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

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));

    }

    public static void getNeighbours(int vertex, ArrayList<Edge> graph[]) {
        System.out.println("The Neighbour vertices of the vertex " + vertex + " are : ");
        for (int i = 0; i < graph[vertex].size(); i++) {
            Edge e = graph[vertex].get(i);
            System.out.print(e.dest + " ");
        }
    }

    public static void main(String[] args) {
        int vertices = 4;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        getNeighbours(2, graph);
    }

}
