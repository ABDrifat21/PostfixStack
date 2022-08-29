package StackPractice;
import java.util.*;
public class Postfix {
    public static Stack<Character> postFix(String infix){
        Stack<Character> stack = new Stack<>();
        Stack<Character> postFixStack = new Stack<>();
        for (int i = 0;i<infix.length();i++) {
            char symbol = infix.charAt(i);
            if (symbol == '(') {
                stack.push(symbol);
            } else if (symbol == ')') {
                char previous = stack.pop();
                while (previous != '(') {
                    postFixStack.push(previous);
                    previous = stack.pop();
                }
            } else if (symbol == '^' || symbol == '*' || symbol == '/' || symbol == '+' || symbol == '-') {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(symbol)) {
                    postFixStack.push(stack.pop());
                }
                stack.push(symbol);
            }else {
                postFixStack.push(symbol);
            }
        }

            while (!stack.isEmpty())
                postFixStack.push(stack.pop());
            
        return postFixStack;

    }
    public static int priority(char symbol){
        if(symbol=='^')
            return 3;
        else if(symbol=='*' || symbol=='/')
            return 2;
        else if(symbol=='+' || symbol=='-')
            return 1;

        return 0;
    }
    public static void main(String[] args) {

        System.out.println( postFix("a/b-c+d*e-a*c"));
    }
}
