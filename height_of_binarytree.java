// height_of_binarytree by recursion
public class height_of_binarytree {
    static class node{
        int data;
        node left,right;
        node(int data)
        {
            this.data=data;
            this.left=null;
            this.right=null;
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
            newnode.left=bt(nodes);
            newnode.right = bt(nodes);
            return newnode; 
        } 
    }
    public static int height_bt(node root)
    {
        if (root==null) {
            return 0;            
        }
        int lefttree_height= height_bt(root.left);
        int righttree_height = height_bt(root.right);
        return (lefttree_height >= righttree_height ? lefttree_height+1 : righttree_height+1);
    }
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,7,-1,-1};
        node root = preorder.bt(nodes);
        int res=height_bt(root);
        System.out.println("the height of the binary tree is: "+res);
    }
}
