import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sumofnodesat_kth_level {
    static class node{
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
    public static void levelorder(node root)
    {
        if (root == null) {
            System.out.println("tree has no nodes");
            return;
        }
        Queue<node> qu = new LinkedList<>();
        qu.add(root);
        qu.add(null);
        while (!qu.isEmpty()) {
            node currnode=qu.remove();;
            if (currnode==null) {
                System.out.println();
                if (qu.isEmpty()) {
                    break;
                }
                else
                {
                    qu.add(null);
                }
            }
            else{
            System.out.print(currnode.data);
            if (currnode.left!=null) {
                qu.add(currnode.left);
            }
            if (currnode.right!=null) {
                qu.add(currnode.right);
            }
        }
        }
    }
    public static void main(String[] args) {
        node root=sumofnodesat_kth_level.create();
        System.out.println("level order traversal: ");
        levelorder(root);
    }
}
