package trie_data_structure; 
// we have to write the package name as folder name when the file is inside the folder
public class startswithPREFIX {
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
    
}


    public static boolean StartsWith(String prefix){
        node curr_root = root;
        for (int i = 0; i < prefix.length(); i++) {
            char curr_char = prefix.charAt(i);
            int idx = curr_char - 'a';
            if (curr_root.children[idx]==null) {
                return false;
            }
            curr_root  = curr_root.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String words[]={"apple","app","mango","man","woman"};
        // String prefix = "app"; // true
        String prefix = "moon"; // false
        for (String word : words) {
            insertvalueinTRIE(word);
        }
        System.out.println(StartsWith(prefix));
    }
}