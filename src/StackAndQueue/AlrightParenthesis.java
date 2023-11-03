package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class AlrightParenthesis {
    static Scanner sc = new Scanner(System.in);

    private static String ap (String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();

        for (char c:str.toCharArray()
             ) {
            if (c == '(') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return "NO";
        }
        return answer;

    }

    public static void main(String[] args) {
        String str = sc.next();
        System.out.println(ap(str));
    }
}
