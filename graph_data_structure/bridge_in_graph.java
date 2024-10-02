
// tarjan's algorithm
// it is used  to find the bridges in the graph such that the graph is divided into connected components

package graph_data_structure;

import java.util.ArrayList;

public class bridge_in_graph {
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
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        // graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));

    }

    public static void dfs_bridge(ArrayList<Edge> graph[], int curr, boolean vis[], int dt[], int low[], int time,int parent) {

        vis[curr]=true;
        
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // 3 cases of tarjans algorithm

            if (e.dest == parent) {
                continue;
            }

            else if (!vis[e.dest]) {
                dfs_bridge(graph, e.dest, vis, dt, low, time, curr);
                low[curr] = Math.min(low[curr],low[e.dest]);
                if(dt[curr]<low[e.dest]){
                    System.out.println("the bridge edge is : "+curr+"->"+e.dest);
                }
            }
            
            else{
                low[curr] = Math.min(low[curr] , dt[e.dest]);
            }

            
        }



    }

    public static void get_bridge(ArrayList<Edge> graph[], int v) {
        int dt[] = new int[v]; // discovery time of each vertex
        int low[] = new int[v]; // low time of each vertex
        int time = 0;
        boolean vis[] = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                // call dfs
                dfs_bridge(graph, i, vis, dt, low, time, -1);
            }
        }

    }

    public static void main(String[] args) {
        int vertices = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[vertices];

        createGraph(graph);
        get_bridge(graph, vertices);

    }
}
