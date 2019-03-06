package Algorithms;
import java.util.*;
public class BalancedString {

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        Stack<Character> strStack = new Stack<Character>();

        while (sc.hasNext()) {
            String input = sc.next();
            char[] inputArr = input.toCharArray();
            boolean balanced = true;
            for (int i = 0; i < inputArr.length && balanced; i++) {
                //Complete the code
                switch (inputArr[i]) {
                    case '{':
                    case '[':
                    case '(':
                        strStack.push(inputArr[i]);
                        break;
                    default:
                        if(strStack.empty()){
                            balanced = false;
                        }
                        else {
                            char c = strStack.pop();
                            if (!isMatch(c, inputArr[i])) balanced = false;
                        }
                        break;
                }

            }
            if(strStack.size()>0) balanced = false;
            System.out.println(balanced ? "true" : "false");
        }

    }

    public static boolean isMatch(char a, char b){
        switch(a){
            case '{':
                return b == '}';
            case '[':
                return b == ']';
            case '(':
                return b == ')';
            default:
                return false;
        }
    }

}
