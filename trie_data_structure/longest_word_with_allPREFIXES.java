package trie_data_structure;

class longest_word_with_allPREFIXES {
    
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
static String longest_word_with_allprefix="";

    // MY APPROACH OF SOLVING THE PROBLEM

    // public static void  findprefix(String word){
    //     int n=word.length();
    //     String prefix[] = new String[n];  
    //     for (int i = 1; i <= n; i++) {
    //         prefix[i-1]= word.substring(0, i);
    //         if (!searchinTRIE(prefix[i-1])) {
    //             return;
    //         }
    //         // return;
    //     }
    //     if (longest_word_with_allprefix.length()<=word.length()) {
    //         longest_word_with_allprefix = word;
    //     }
    // }


    // APNA COLLEGE YOU TUBE  APPROACH 
    public static void longest_word(node root,StringBuilder temp){
        // base case
        if (root==null) {
            return;
        }
        for (int i = 0; i <26; i++) {
            if (root.children[i]!=null && root.children[i].endofword==true) {
                 temp = temp.append((char)('a'+i));
                if (temp.length()>longest_word_with_allprefix.length()) {
                   longest_word_with_allprefix= temp.toString(); 
                }
                longest_word(root.children[i],temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    static String words[] ={"a","banana","b","ba","ban","bana","banan","ap","app","appl","apply","apple"};
    public static void main(String[] args) {
        for (String word : words) {
            insertvalueinTRIE(word);
        }   
        // for (String word : words) {
        //     findprefix(word);
        // }   
        // StringBuilder temp = new StringBuilder("");
        longest_word(root, new StringBuilder(""));
        System.out.println(longest_word_with_allprefix);
    }
}