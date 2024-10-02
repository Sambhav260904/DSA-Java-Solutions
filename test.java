// import java.util.*;
// class Solution {
//     public static int lengthOfLongestSubstring(String s) {
//         HashSet<String> set = new HashSet<>();
//         String longest= "";
//         for(int i=0;i<s.length();i++){
//             for(int j=i;j<s.length();j++){
//                 if(set.contains(s.charAt(j))){
//                     break;
//                 }
//                 else{
//                     set.add(s.charAt(j));
//                 }
//             }
//             if(longest.length()<set.size()){

//                     longest=set.toString();
//                 }
//             }
//         return longest.length();
//         }

//     public static void main(String args[]){
//         String s1 = "sambhav";
//         int res=lengthOfLongestSubstring(s1);
//         System.out.println(res);
//     }
// }

// by gpt sliding window problem

// import java.util.*;

// class test{
//     public static int lengthOfLongestSubstring(String s) {
//         Set<Character> set = new HashSet<>();
//         int left = 0, right = 0, maxLength = 0;

//         while (right < s.length()) {
//             if (!set.contains(s.charAt(right))) {
//                 set.add(s.charAt(right));
//                 right++;
//                 maxLength = Math.max(maxLength, set.size());
//             } else {
//                 set.remove(s.charAt(left));
//                 left++;
//             }
//         }
//         System.out.println(set);
//         return maxLength;
//     }

//     public static void main(String[] args) {
//         String s1 = "sambhav";
//         int res = lengthOfLongestSubstring(s1);
//         System.out.println(res);  // Output should be the length of the longest substring without repeating characters
//     }
// }

// import java.util.*;
// class test {
//     public static boolean isValid(String s) {
//         int j;
//         Stack<Character> c = new Stack<>();
//         for(int i=0;i<s.length();i++){
//             if (s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[' ) {
//                 c.push(s.charAt(i));
//             }
//             else{
//                 while (!c.isEmpty()) {
//                     if (s.charAt(i)==')' && c.peek()=='(') {
//                         c.pop();
//                      }
//                      else if (s.charAt(i)=='}' && c.peek()=='{' ) {
//                          c.pop();
//                      }
//                      else
//                      {
//                          if (c.peek()=='[') {
//                              c.pop();
//                          }
//                      }
//                 }

//             }
//         }
//        return c.isEmpty() ? true : false;

//     }
//     public static void main(String[] args) {
//         String s1 = "([)]";
//         boolean res = isValid(s1);
//         System.out.println(res);
//     }
// }

// import java.util.Stack;

// class test {
//     public static int longestisValid(String s) {
//         Stack<Character> c = new Stack<>();
//         int count=0;
//         boolean flag = false;
//         for(int i = 0; i < s.length(); i++) {
//             char current = s.charAt(i);
//             if (current=='(') {
//                 c.push('(');
//                 flag = true;
//             }
//             else{
//                 if (!c.isEmpty() && flag ==true) {                    
//                     if (current == ')' && c.peek()=='(') {
//                         c.pop();
//                         count+=2;
//                         flag=false;
//                     }
//                 }
//             }

//     }
//     return count;
// }

//     public static void main(String[] args) {
//         String s1 = "(()";
//         int res =longestisValid(s1);
//         System.out.println(res);  // Output should be false because the input is not valid

//         String s2 = ")()())";
//         System.out.println(longestisValid(s2));  // Output should be true

//         String s3 = "";
//         System.out.println(longestisValid(s3));  // Output should be false
//     }
// }

// import java.security.Key;

// class test{
//     public static void main(String[] args) {
//        String key = "12334";
//        for (int j = 1; j <= key.length(); j++) {

//            System.out.println(key.substring(0,j));
//        }
//         // System.out.println("hash code: "+key.toString().hashCode());
//     }
// }

import java.util.HashMap;

class MapSum {
    static class node {
        node[] children;
        int valuesum;
        boolean endofword;

        public node() {
            children = new node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            endofword = false;
            valuesum = 0;
        }

    }

    static node root;
    static HashMap<String, Integer> map;
    // insert in the trie

    public MapSum() {
        root = new node();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int difference_ofVALUE = val - map.getOrDefault(key, 0);
        map.put(key, val);
        node curr = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new node();
            }
            curr = curr.children[idx];
            curr.valuesum += difference_ofVALUE;
        }
        curr.endofword = true;
    }

    public int sum(String prefix) {
        node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                return 0;
            }
            curr = curr.children[idx];
        }
        return curr.valuesum;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap")); // return 3 (apple = 3)
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));// return 5 (apple + app = 3 + 2 = 5)
    }
}
