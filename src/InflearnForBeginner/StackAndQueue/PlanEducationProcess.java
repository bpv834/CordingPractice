package InflearnForBeginner.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PlanEducationProcess {
    static Scanner sc = new Scanner(System.in);

    private static String pep(String str1,String str2) {
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();
        for (char c:str1.toCharArray()
             ) {
            Q.offer(c);
        }

        for (char c:str2.toCharArray()
             ) {
            if (Q.contains(c)) {
                if (Q.peek() == c) {
                    Q.poll();
                }
                else {
                    answer = "NO";
                    break;
                }
            }
        }
        if (!Q.isEmpty()) {
            answer = "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println( pep(sc.next(),sc.next()));
    }
}
