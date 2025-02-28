import java.util.Stack;

public class P4 {
    public static void main(String[] args){
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("{{[[(())]]}}"));
    }

    /*
    Time Complexity
    n = s.length()

    O(1) + O(n/2) + O(1) + O(n/2) + O(1) + O(n/2) + O(n/2) + O(1)
    O(2n)=O(n)

    Space complexity
    O(n/2)=O(n)

     */
    public static String isBalanced(String s){
        Stack<Character> c = new Stack<>();
        for(int i = 0; i < s.length()/2; i++){
            c.push(s.charAt(i));
        }
        String p = "";

        while(!c.isEmpty()){
            p += c.pop();
        }
        String secondHalf = "";
        for(int i = s.length()/2; i < s.length(); i++){
            secondHalf += s.charAt(i);
        }
        for(int i = 0; i < p.length(); i++){
            if(!matchingBrackets(p.charAt(i), secondHalf.charAt(i)))
                return "NO";
        }
        return "YES";
    }
    public static boolean matchingBrackets(char c, char d){
        if(c == '(' && d == ')')
            return true;
        if(c == '[' && d == ']')
            return true;
        if(c == '{' && d == '}')
            return true;
        return false;
    }
}
