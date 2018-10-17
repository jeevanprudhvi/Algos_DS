import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jstadiko on 2018-10-17.
 */
public class InfixToPrefix {

    public int prec(char ch){
        switch (ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
    public String convertInfixToPrefix(String exp){
        StringBuilder expSb = new StringBuilder(exp);
        expSb.reverse();
        char[] chars = expSb.toString().toCharArray();
        Stack<Character> st = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< chars.length; i++){
            if(chars[i] == ')')
                st.push(chars[i]);
            else if(chars[i] == '('){
                while (st.peek() != ')')
                    sb.append(st.pop());
                st.pop();
            }
            else if(Character.isLetterOrDigit(chars[i])){
                sb.append(chars[i]);
            }
            else{
                while (!st.isEmpty() && prec(chars[i]) <= prec(st.peek())){
                    sb.append(st.pop());
                }
                st.push(chars[i]);
            }
        }
        while(!st.isEmpty())
            sb.append(st.pop());
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();
        InfixToPrefix obj = new InfixToPrefix();
        System.out.println(obj.convertInfixToPrefix(exp));
    }
}
