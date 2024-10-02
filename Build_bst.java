public class Build_bst {
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
        public static void inorder(node root)
        {
            if (root==null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        public static boolean search_bst(node root,int key)  // time complexity of the bst is O(height of tree) O(H)
        {
            if (root==null) {
                // System.out.println("error: Tree is empty");
                return false;
            }
            if (root.data==key) {
                return true;
            }
            else if (root.data > key) {
                return search_bst(root.left, key);
            }
            else
                return search_bst(root.right, key);
           //    return false;    
        }
        public static node delete(node root,int val)
        {
            if (root==null) {
                return null;
            }
            if(root.data>val) {
               root.left=delete(root.left, val);
            } 
            else if (root.data<val) {
                root.right= delete(root.right, val);
            }
            else
            {       // root.data == val
                // case 1 both left and right  subtrees are null
                if (root.left==null && root.right==null) {
                    return null;
                }
                // case 2 if one of sub tree is null
                if (root.left==null) {
                    return root.right;
                }
                else if(root.right==null)
                {
                    return root.left;
                }
                else
                {
                    node IS = inordersuccessor(root.right);
                    root.data= IS.data;
                    root.right  = delete(root.right, IS.data);
                }
            }
            
            return root;
        }
        public static node inordersuccessor(node root){
            while (root.left!=null) {
                root=root.left;
            }
            return root;
        }
    public static void main(String[] args) {
        int values[]={5,1,3,4,2,7};
        node root=null;
        for(int i=0;i<values.length;i++)
        {
          root = bst.build(root,values[i]);        
        }
        System.out.println(root.data);
        inorder(root);  // it will print in the ascending order to verify our output is correct
        System.out.println();
        int key=6;
        if (search_bst(root, key)) {
            System.out.println(key+" found");
        }
        else
        {
            System.out.println(key+" not found");
        }
        inorder(root);
        System.out.println();
        delete(root,1);
        inorder(root);

    }   
}
