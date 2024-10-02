// import java.util.Stack;

// class gpt {
//     public static int longestValidParentheses(String s) {
//         Stack<Integer> stack = new Stack<>();
//         stack.push(-1); 
//         int maxLength = 0;

//         for (int i = 0; i < s.length(); i++) {
//             char current = s.charAt(i);

//             if (current == '(') {
//                 stack.push(i); 
//             } else {
//                 stack.pop();  

//                 if (stack.isEmpty()) {
//                     stack.push(i);  
//                 } else {
//                     int length = i - stack.peek();  
//                     maxLength = Math.max(maxLength, length); 
//                 }
//             }
//         }

//         return maxLength;
//     }

//     public static void main(String[] args) {
//         String s1 = "(()";
//         System.out.println(longestValidParentheses(s1));  

//         String s2 = ")()())";
//         System.out.println(longestValidParentheses(s2));  

//         String s3 = "";
//         System.out.println(longestValidParentheses(s3));  
//     }
// }



    // // Function to check if the character is an operator
    // static boolean isOperator(char c) {
    // return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    // }

    // // Function to return the precedence of the operators
    // static int precedence(char c) {
    // switch (c) {
    // case '+':
    // case '-':
    // return 1;
    // case '*':
    // case '/':
    // return 2;
    // case '^':
    // return 3;
    // }
    // return -1;
    // }

    // // Function to convert infix to postfix
    // static String infixToPostfix(String exp) {
    // StringBuilder result = new StringBuilder();
    // Stack<Character> stack = new Stack<>();

    // for (int i = 0; i < exp.length(); i++) {
    // char c = exp.charAt(i);

    // // If the scanned character is an operand, add it to output
    // if (Character.isLetterOrDigit(c)) {
    // result.append(c);
    // }
    // // If the scanned character is an '(', push it to the stack
    // else if (c == '(') {
    // stack.push(c);
    // }
    // // If the scanned character is an ')', pop and output from the stack
    // // until an '(' is encountered
    // else if (c == ')') {
    // while (!stack.isEmpty() && stack.peek() != '(') {
    // result.append(stack.pop());
    // }
    // stack.pop(); // Remove '(' from the stack
    // }
    // // An operator is encountered
    // else if (isOperator(c)) {
    // while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
    // result.append(stack.pop());
    // }
    // stack.push(c);
    // }
    // }

    // // Pop all the operators from the stack
    // while (!stack.isEmpty()) {
    // result.append(stack.pop());
    // }

    // return result.toString();
    // }

    import java.util.Stack;

    public class Calculator {
        public static int calci(String s) {
            Stack<Character> st_operator = new Stack<>();
            Stack<Integer> st_operand = new Stack<>();
            
            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);
                
                // If the current character is a digit
                if (Character.isDigit(current)) {
                    int num = 0;
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + (s.charAt(i) - '0');
                        i++;
                    }
                    i--;  // to adjust for the increment in the loop
                    st_operand.push(num);
                } 
                // If the current character is an operator or opening parenthesis
                else if (current == '+' || current == '-' || current == '/' || current == '*' || current == '(') {
                    st_operator.push(current);
                } 
                // If the current character is a closing parenthesis
                else if (current == ')') {
                    while (st_operator.peek() != '(') {
                        char operator = st_operator.pop();
                        int operand2 = st_operand.pop();
                        int operand1 = st_operand.pop();
                        int result = applyOperation(operand1, operand2, operator);
                        st_operand.push(result);
                    }
                    st_operator.pop();  // pop the '('
                }
            }
            
            // Apply remaining operators
            while (!st_operator.isEmpty()) {
                char operator = st_operator.pop();
                int operand2 = st_operand.pop();
                int operand1 = st_operand.pop();
                int result = applyOperation(operand1, operand2, operator);
                st_operand.push(result);
            }
            
            return st_operand.peek();  // Final result
        }
    
        private static int applyOperation(int operand1, int operand2, char operator) {
            switch (operator) {
                case '+': return operand1 + operand2;
                case '-': return operand1 - operand2;
                case '*': return operand1 * operand2;
                case '/': return operand1 / operand2;
                default: throw new IllegalArgumentException("Invalid operator");
            }
        }
        
        public static void main(String[] args) {
            String expression = "(1+(4+5+2)-3)+(6+8)";
            int res = calci(expression);
            System.out.println("the result = "+res);  // Output: 23
        }
    }
    