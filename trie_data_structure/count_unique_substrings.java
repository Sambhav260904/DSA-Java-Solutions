package trie_data_structure; 
// we have to write the package name as folder name when the file is inside the folder
 public class count_unique_substrings {
    static class node {
        node[] children;
        boolean endofword;

        public node() {
            children = new node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            endofword = false;
        }
    }

    static node root = new node();

    // insert in the trie
    public static void insertvalueinTRIE(String word) {
        node curr_root = root;
        for (int i = 0; i < word.length(); i++) { // time complexity is O(L) which is length of the word
            char curr_char = word.charAt(i);
            int indx = curr_char - 'a';
            // if (i==word.length()-1) {
            // curr_root.endofword= true;
            // }
            if (curr_root.children[indx] == null) {
                curr_root.children[indx] = new node();
            }
            curr_root = curr_root.children[indx];

        }
        curr_root.endofword = true;

    }

    public static String[] suffix(String str) {
        int n = str.length();
        String suffix[] = new String[n];
        // suffix[0]="";
        for (int i = 0; i < n; i++) {
            suffix[i] = str.substring(i);
        }
        return suffix;
    }

    public static int Count_Unique_Substrings(node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += Count_Unique_Substrings(root.children[i]);
                // char c = (char) ('a' + i);
                // System.out.println(c);
            }
        }
        return count + 1;
    }

    // using trie data structure
    public static void main(String[] args) {
        // for any string the substrings are :
        // 1.all prefix of all suffix
        // 2.all suffix of all prefix
        // we are going to solve the problem using case 1

        // step 1 is used to find the suffixes of the string
        // step 2 is used to build a trie of the above suffix
        // step 3 is ot count number of nodes of the trie which is equal to number of
        // the substrings of the string
        // total number unique sub strings of string = total no. of nodes of the trie
        String str = "ababa";
        String suffixes[] = suffix(str);
        // for(String s:suffixes){
        // System.out.println(s);
        // }
        // System.out.println(suffixes.length);
        for (String suffix : suffixes) {
            insertvalueinTRIE(suffix);
        }
        System.out.println();
        System.out.println("The number of unique substrings are : "+Count_Unique_Substrings(root)); // output = 10
    }
}
