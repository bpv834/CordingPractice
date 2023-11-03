package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class StealBar {
    static Scanner sc = new Scanner(System.in);

    private static int sb(String str) {
        int answer=0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }
            else {
                stack.pop();
                if (str.charAt(i - 1) == '(') {
                    answer += stack.size();
                }
                else {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(sb(sc.next()));
    }
}
