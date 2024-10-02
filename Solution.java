// import java.util.*;
// class Solution {
//     public static int romanToInt(String s) {
//         int res=0,temp=0;
//         HashMap<String,Integer> h1 = new HashMap<>();
//         h1.put("I", 1);
//         h1.put("V", 5);
//         h1.put("X", 10);
//         h1.put("L", 50);
//         h1.put("C", 100);
//         h1.put("D", 500);
//         h1.put("M", 1000);
//         for(int i=0;i<s.length();i++){
//             temp=h1.get(s.charAt(i));
//             if(s.charAt(i)=='I'){
//                 if(s.charAt(i+1)=='V' || s.charAt(i+1)=='X'){
//                     temp=h1.get(s.charAt(i+1))-1;
//                 }
//             } 
//             else if(s.charAt(i)=='X'){
//                 if(s.charAt(i+1)=='C' || s.charAt(i+1)=='L'){
//                     temp=h1.get(s.charAt(i+1))-10;
//                 }
//             }
//             else if(s.charAt(i)=='C'){
//                 if(s.charAt(i+1)=='D' || s.charAt(i+1)=='M'){
//                     temp=h1.get(s.charAt(i+1))-100;
//                 }
//             }
//             res=res+temp;

//         }
//         return res;
//     }
//     public static void main(String[] args){
//         String s =new String("MCMXCIV") ;
//         int num=romanToInt(s);
//         System.out.println(num);
//     }
// }

// GPT

// import java.util.HashMap;

// class Solution {
//     public static int romanToInt(String s) {
//         // Map of Roman numerals and their integer values
//         HashMap<Character, Integer> romanMap = new HashMap<>();
//         romanMap.put('I', 1);
//         romanMap.put('V', 5);
//         romanMap.put('X', 10);
//         romanMap.put('L', 50);
//         romanMap.put('C', 100);
//         romanMap.put('D', 500);
//         romanMap.put('M', 1000);

//         int total = 0;

//         // Traverse the Roman numeral string
//         for (int i = 0; i < s.length(); i++) {
//             // Get the value of the current character
//             int value = romanMap.get(s.charAt(i));

//             // Check if the next character exists and if it's greater than the current one
//             if (i + 1 < s.length() && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
//                 total -= value;  // Subtract the value
//             } else {
//                 total += value;  // Add the value
//             }
//         }

//         return total;
//     }

//     public static void main(String[] args) {
//         // Test cases
//         String s1 = "III";
//         String s2 = "LVIII";
//         String s3 = "MCMXCIV";
//         System.out.println(s3.contains("M"));
//         System.out.println(romanToInt(s1));  // Output: 3
//         System.out.println(romanToInt(s2));  // Output: 58
//         System.out.println(romanToInt(s3));  // Output: 1994
//     }
// }

// import java.util.*;

// class Solution {
//     public List<String> letterCombinations(String digits) {
//     ArrayList<String> l1 = new ArrayList<>();
//     HashMap<String,String> h1 = new HashMap<>();
//     h1.put("2","abc");
//     h1.put("3","def");
//     h1.put("4","ghi");
//     h1.put("5","jkl");
//     h1.put("6","mno");
//     h1.put("7","pqrs");
//     h1.put("8","tuv");
//     h1.put("9","wxyz");

//     // l1 = res(digits);
//     String val[] =  new String[digits.length()];
//     for(int i=0;i<digits.length();i++)      ///23
//     {
//         val[i]  = h1.get(digits.charAt(i));
//     }
//     for(int i=0;i<val[i].length();i++){
//         for()
//     }
//     return l1; 

//     }

// }

import java.util.*;;

class Solution {
    public static void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> columns = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for (int row : rows) {

            for (int i = 0; i < matrix[row].length; i++) {
                matrix[row][i] = 0;
            }
        }
        for (int column : columns) {

            for (int j = 0; j < matrix.length; j++) {
                matrix[j][column] = 0;
            }
        }

    }
    // for (int i = 0; i < matrix.length; i++) {
    // for (int j = 0; j < matrix[i].length; j++) {
    // System.out.print(matrix[i][j]);}System.out.println();}

  

    public static void main(String[] args) {
        int[][] max = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        setZeroes(max);

    }
}
