import java.util.*;
public class preorder_java_byme {
    static class  node {
        int data;
        node left,right;
    }
    static Scanner sc = new Scanner(System.in);
    static node create()
    {
        int x;
        node newnode = new node();
        System.out.println("enter the data(-1 for no node): ");
        x=sc.nextInt();
        if (x==-1) {
            return null;
        }
        newnode.data=x;
        System.out.println("enter the left child of "+x+": ");
        newnode.left=create();
        System.out.println("enter the right child of "+x+": ");
        newnode.right=create();
        return newnode;
    }
    public static void preorder(node root)
    {
        if (root==null) {
            return;
        }
        System.out.print(" "+root.data);
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        node root=preorder_java_byme.create();
        preorder(root);
        sc.close();
    }    
}
