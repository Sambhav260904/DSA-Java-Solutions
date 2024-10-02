import java.util.*;
public class root_to_leafnode {
    static class node {
        int data;
        node left,right;
        node(int data)
        {
            this.data=data;
        }
        }   
        public static class bst
        {
             public static node build(node root,int value)
             {
                 if (root == null) {
                    root = new node(value);
                    return root;
                 }
                 if (root.data>value) {
                    root.left=build(root.left, value);
                 }
                 else
                 {
                    root.right=build(root.right, value);
                 }
                return root;
            }
        }
    public static void printnde2leaf(node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            System.out.println(path);
        }
        else
        {
            printnde2leaf(root.left,path);
            printnde2leaf(root.right,path);  
        }
        path.remove(path.size()-1);
    }
    public static void main(String[] args) {
        int values[]={5,1,3,4,2,7};
        ArrayList<Integer> path= new ArrayList<>();
        node root=null;
        for(int i=0;i<values.length;i++)
        {
            root = bst.build(root,values[i]);        
        }
        printnde2leaf(root,path);
    }
}
