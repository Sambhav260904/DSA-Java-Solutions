package trie_data_structure; 
// we have to write the package name as folder name when the file is inside the folder
public class wordbreakproblem__TRIE_DATA_STRUCTURE {

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
        // System.out.println("hi");
    }

    public static boolean searchinTRIE(String word) {
        node curr_root = root;

        for (int i = 0; i < word.length(); i++) { // time complexity is O(L) which is length of the word
            char curr_char = word.charAt(i);
            int indx = curr_char - 'a';
            if (curr_root.children[indx] == null) {
                return false;
            }

            curr_root = curr_root.children[indx];

        }
        return curr_root.endofword;
    }

    public static boolean searchwordproblem(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            String firstpart = key.substring(0, i);
            String secondpart = key.substring(i,key.length());
            if (searchinTRIE(firstpart) && searchwordproblem(secondpart)) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {

        String words[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        String key = "ilikesamsung";
        for (String word : words) {
            insertvalueinTRIE(word);
        }
        System.out.println(searchwordproblem(key));
    }
}
