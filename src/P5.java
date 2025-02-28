import java.util.Stack;

public class P5 {
    public static void main(String[] args){
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]ef"));
        System.out.println(decodeString("2[abc]3[cd]ef"));

    }
    /*
    Time Complexity
    n = s.length()
    k = max # of letters enclosed in a single bracket in the encoded string ex "3[a]2[bcef]" k=4
    l = max # of digits in string ex "23[a]2[bc]", l=2
    p = max number that is being multiplied in the string ex. "3[a]2[bc]" p=3
    m = max length of string that is multiplied ex. "3[a2[c]]2[ef]" m="accaccacc".length()==9
    c = length of decoded string
    Note I use the maxes here since the loops that run through the temporary variables that hold the
    string that is multiplied, the multiplied string, and the number the string is multiplied with will
    at most runs these max times in a given run of the outer loop

    O(1)+O(1)+O(1)+O(1)+O(1)+O(1)+O(1)+O(n(k+l+p+m) + O(c)
    Which simplifies to O(nk+nl+np+nm) + O(c) = O(nk+nl+np+nm)

    Space Complexity
    No new variables are initialized in the loop, so the
    space complexity would be
    O(c) + O(7) = O(c), which represents how the stack is the part of memory that changes as input changes.
     */
    public static String decodeString(String s) {
        int count = 0; //O(1)
        Stack<Character> c = new Stack<>(); //O(c)
        int j = 0; //O(1)
        String tempS = ""; //O(1)
        String tempD = ""; //O(1)
        String tempS2 = ""; //O(1)
        int k; //O(1)
        while(count < s.length()){ //O(s.length)
            //System.out.println(j);
            if(s.charAt(count) == ']'){ //O(1)
                while(c.peek() != '['){
                    if(c.peek() != ']')
                        tempS = c.pop() + tempS; //O(1)
                    else
                        c.pop();
                }
                c.pop(); //O(1)
                while(!c.empty() && isDigit(c.peek())){
                    tempD = c.pop() + tempD;
                }
                //System.out.println(tempD);
                k = Integer.parseInt(tempD);
                for(int i = 0; i < k; i++){ //O(k)
                    tempS2 += tempS;
                }
                // System.out.println(tempS2);
                // System.out.println(c);
                for(int i = 0; i < tempS2.length(); i++){ //O(tempS2.length) the string that is being added to the stack after multiplication of the string
                    c.push(tempS2.charAt(i));
                }
                //c.push(']'); //O(1)
                //System.out.println(c);
            }
            if(s.charAt(count) != ']')
                c.push(s.charAt(count)); //O(1)
            k=0; //O(1)
            tempD=""; //O(1)
            tempS=""; //O(1)
            tempS2=""; //O(1)
            count++; //O(1)
        }
        int size = c.size(); //
        for(int i = 0; i < size; i++){
            tempS2 = c.peek() + tempS2;
            c.pop();
        }

        return tempS2;
    }
    public static boolean isDigit(Character c){
        return c >= 48 && c <= 57;
    }
}
