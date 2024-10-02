
// THE TIME COMPLEXITY OF THE BFS ALGORITHM IS O(vertices + edges)   //O(V+E)
// GO TO IMMEDIATE NEIGHBOURS FIRST
package graph_data_structure.graph_traversal_methods;

import java.util.*;

public class breadth_first_search {
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

    public static int[] getNeighbours(int vertex, ArrayList<Edge> graph[]) {
        // System.out.println("The Neighbour vertices of the vertex " + vertex + " are :
        // ");
        int neighbours[] = new int[graph[vertex].size()];
        for (int i = 0; i < graph[vertex].size(); i++) {
            Edge e = graph[vertex].get(i);
            neighbours[i] = e.dest;
        }
        return neighbours;
    }

    public static void BFS_TRAVERSAL(int start_node, ArrayList<Edge> graph[]) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[vertices];
        // for (int i = 0; i < visited.length; i++) {
        //     visited[i] = false;
        // }
        queue.add(start_node);
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            if (visited[curr] == false) {
                System.out.print(curr + " ");
                visited[curr] = true;
                int neighbours[] = getNeighbours(curr, graph);
                for (int i = 0; i < neighbours.length; i++) {
                    queue.add(neighbours[i]);
                }
            }
        }

    }

    static int vertices = 7;

    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        // getNeighbours(2, graph);
        // System.out.println();
        BFS_TRAVERSAL(0, graph);

    }

}
