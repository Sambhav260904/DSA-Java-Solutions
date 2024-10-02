// sum of the nodes by recursion
public class sum_of_node_bt {
    static class node{
        int data;
        node leftchild,rightchild;
    node(int data)
    {
        this.data=data;
        this.leftchild=null;
        this.rightchild=null;
    }
    }
    static class preorder
    {
        static int i=-1;
        public static node bt(int nodes[])
        {
            i++;
            if (nodes[i]==-1) {
                return null;
            }
            node newnode = new node(nodes[i]);
            newnode.leftchild=bt(nodes);
            newnode.rightchild = bt(nodes);
            return newnode; 
        } 
    } 
    public static int sum_nodes(node root)
    {
        if (root==null) {
            return 0;
        }
        int leftsum = sum_nodes(root.leftchild);
        int rightsum = sum_nodes(root.rightchild);
        return leftsum+rightsum+root.data;
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,7,-1,-1};
        node root = preorder.bt(nodes);
       System.out.println("the sum of nodes in the tree are: "+sum_nodes(root));
}   
}
