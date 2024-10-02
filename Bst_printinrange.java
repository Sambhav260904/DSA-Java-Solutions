public class Bst_printinrange {
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
        public static void printrange(node root)
        {
            if (root==null) {
                return;
            }
            printrange(root.left);
           // System.out.print(root.data+" ");
           helper(root.data); 
           printrange(root.right);
        }
        public static void helper(int val)
          {
            if (x<=val && val<=y) {
                System.out.println(val);
            }
            return;
          }  
        static int x=3,y=7;
    public static void main(String[] args) {
        int values[]={5,1,3,4,2,7};
        node root=null;
        for(int i=0;i<values.length;i++)
        {
          root = bst.build(root,values[i]);        
        }
        System.out.println("root ="+root.data);
        printrange(root);
    }
}
