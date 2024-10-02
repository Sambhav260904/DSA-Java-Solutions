public class preorder_traversal {
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
    public static void preorder(node root)
    {
        if (root==null) {
            System.out.print(" -1");
            return;
        }
        System.out.print(" "+root.data);
        preorder(root.leftchild);
        preorder(root.rightchild);
    }
   public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        preorder tree = new preorder();
        node root=tree.bt(nodes);
        System.out.println(root.data);
        preorder(root);
    }    
}
