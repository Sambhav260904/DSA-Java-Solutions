package trie_data_structure; 
// we have to write the package name as folder name when the file is inside the folder

// the trie data structure is also known as prefix tree ,digital search tree , retrieval tree
// k-arry tree
public class Trie_DS {
    static class node {
        node[] children;
        boolean endofword;
        public node(){
            children  = new node[26];
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            endofword = false;
        }

    }
    static node root = new node();
    // insert in the trie
    public static void insertvalueinTRIE(String word){
        node curr_root = root;
        for(int i=0;i<word.length();i++){  // time complexity is O(L) which is length of the word
            char curr_char = word.charAt(i);
            int indx = curr_char-'a';
            // if (i==word.length()-1) {
            //    curr_root.endofword= true;
            // }
            if(curr_root.children[indx]==null){
                curr_root.children[indx]=new node();
        }
        curr_root = curr_root.children[indx];


    } 
    curr_root.endofword= true;
    // System.out.println("hi");
}
    public static boolean searchinTRIE(String word){
        node curr_root= root;
        
        for(int i=0;i<word.length();i++){  // time complexity is O(L) which is length of the word
            char curr_char = word.charAt(i);
            int indx = curr_char-'a';
            if(curr_root.children[indx]==null){
                return false;
            }
        
        curr_root= curr_root.children[indx];
        
    }
    return curr_root.endofword;
}
    public static void main(String[] args) {
        String words[] ={"sambhav","ram","sita","laxmi"};
        for (String word : words) {
            insertvalueinTRIE(word);
        }
        System.out.println("\n"+searchinTRIE("sambhav")); //true 
        System.out.println(searchinTRIE("rawani")); //false
        System.out.println(searchinTRIE("ram")); //true 
    }
}
