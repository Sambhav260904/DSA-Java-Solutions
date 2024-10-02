package graph_data_structure.minimum_spanning_tree;
//MST is a minimum weighted tree with no cycles and is a sub graph of the graph with all the vertices included init.
// mst is possible only when the graph is undirected and edge weighted graph
//to calcalute the mst we use prim's algorithm MST Set concept

/* mst:
1. all nodes are connected
2. no cycles are formed
3. cost is less/minimum
**/
import java.util.*;
public class minimum_spanning_tree {
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
        int cost;
        int parent;
        public pair(int node, int cost,int parent) {
            this.node = node;
            this.cost =cost;
            this.parent = parent;  // Track the parent node
        }

        @Override
        public int compareTo(pair p2) {
            return this.cost - p2.cost; // priority queue sorts the pair in ascending order of cost
            // return p2.cost - this.cost; // priority queue sorts the pair in
            // descending order of cost
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>(); // adding the empty array list to the graph of array
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2,50 ));


    }
            //time complexity =  O(E+Log E)
    public static Integer  minimum_spanning_tree_using_prims_algorithm(ArrayList<Edge> graph[]){
        PriorityQueue<pair> non_mst_set  = new PriorityQueue<>();
        ArrayList<Edge> edges_of_MST = new ArrayList<>(); 
        boolean[] mst_set = new boolean[vertices];         // mst set
        Integer mst_cost=0;
        non_mst_set.add(new pair(0,0,-1));
        while (!non_mst_set.isEmpty()) {
            pair curr = non_mst_set.poll();
            int curr_node = curr.node;
            if (!mst_set[curr_node]) {  // if curr node is not visited / not in mst set
                mst_set[curr_node] = true;
                mst_cost+=curr.cost;
                
                // If parent exists, add the edge to the MST list
                if (curr.parent != -1) {
                    edges_of_MST.add(new Edge(curr.parent, curr_node, curr.cost));
                }

                for (int i = 0; i < graph[curr_node].size(); i++) {  // adding neighbour nodes in non mst set
                    Edge e = graph[curr_node].get(i);
                    int v=  e.dest; 
                    if (!mst_set[v]) {
                        non_mst_set.add(new pair(v,e.weight,curr_node));
                    }   
                }               
            }
        }
        // Print the edges of the MST
        System.out.println("Edges in MST:");
        for (Edge e : edges_of_MST) {
            System.out.println(e.src + " - " + e.dest + " : " + e.weight);
        }

        return mst_cost; 
    }


    static int vertices  = 4;
    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        // int src = 0;
        createGraph(graph);
        Integer minimum_cost  = minimum_spanning_tree_using_prims_algorithm(graph);
        System.out.println(minimum_cost);

    }
}
