import java.util.Stack;

public class P6 {
    public static void main(String[] args){
        System.out.println(infixToPostfix("(a+b)*c"));
//        System.out.println(infixToPostfix("(a+b)*(c-d)"));
//        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
    }

    /*
    Time Complexity
    n = expression.length()
    m = # of operators and parentheses in expression
    O(1) + O(1) + O(n(m)) + O(m)=O(2+n*m+m)=O(n*m+m)=O(m(n+1))=O(n*m)

    Space Complexity
    The only space that changes as the input changes is the stack which will contain at most
    m characters
    O(m)
     */
    public static String infixToPostfix(String expression){
        Stack<Character> c = new Stack<>();
        String postfix = "";
        for(int i = 0; i < expression.length(); i++){
            if(!isOperator(expression.charAt(i))){
                postfix += expression.charAt(i);
            } else if (expression.charAt(i) == '(') {
                c.push('(');
            } else if (expression.charAt(i) == ')') {
                while(!c.isEmpty() && c.peek() != '('){
                    postfix += c.pop();
                }
                c.pop();
            } else {
                while(!c.isEmpty() && precedence(c.peek()) >= precedence(expression.charAt(i))){//
                    postfix += c.pop();
                }
                c.push(expression.charAt(i));
            }
        }
        while(!c.isEmpty()){
            postfix += c.pop();
        }
        return postfix;
    }

    public static boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')';
    }

    public static int precedence(char c){
        if(c == '^')
            return 3;
        if(c == '*' || c == '/')
            return 2;
        if(c == '+' || c == '-')
            return 1;
        return -1;
    }

}
