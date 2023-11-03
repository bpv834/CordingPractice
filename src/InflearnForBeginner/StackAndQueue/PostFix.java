package InflearnForBeginner.StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class PostFix {
    static Scanner sc = new Scanner(System.in);

    private static int pf(String str) {
        int answer=0;
        Stack<Integer> stack = new Stack<>();
        int lt=0,rt=0;
        for (char c:str.toCharArray()
             ) {
            if (Character.isDigit(c) == true) {
                stack.push(c-48);
            } else if (c=='+') {
                answer = stack.pop() + stack.pop();
                stack.push(answer);
            }
            else if (c=='-') {
                rt=stack.pop();
                lt = stack.pop();
                answer = lt - rt;
                stack.push(answer);
            }
            else if (c=='*') {
                answer = stack.pop() * stack.pop();
                stack.push(answer);
            }
            else if (c=='/') {
                rt=stack.pop();
                lt = stack.pop();
                answer = lt / rt;
                stack.push(answer);
            }

        }
        answer = stack.get(0);
        return answer;
        }




    public static void main(String[] args) {
        String str = sc.next();
        System.out.println(pf(str));

    }
}
