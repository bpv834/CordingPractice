package InflearnForBeginner.StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesisCharacterRemove {
    static Scanner sc = new Scanner(System.in);

    private static String pcr(String str) {
        Stack<Character> stack = new Stack<>();
        int cnt=0;
        String answer = "";
        for (char c : str.toCharArray()
        ) {
            if (c == ')') {
                while (stack.pop() != '(') ;

            }
            else stack.push(c);
        }
        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        String str = sc.next();
        System.out.println(pcr(str));
    }
}
