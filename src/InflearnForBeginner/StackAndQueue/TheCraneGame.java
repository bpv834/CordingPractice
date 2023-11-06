package InflearnForBeginner.StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class TheCraneGame {
    static Scanner sc = new Scanner(System.in);

    private static int tcg(int arr[][], int moves[]) {
        int answer=0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            int index=0;
            while (index  <arr.length) {
                if (arr[index][moves[i]-1] != 0) {
                    if(!stack.isEmpty()) {
                        if (stack.peek() != arr[index][moves[i] - 1]) {
                            stack.push(arr[index][moves[i] - 1]);

                        } else {
                            stack.pop();
                            answer++;
                            answer++;

                        }
                        arr[index][moves[i] - 1] = 0;
                        break;
                    }
                    else {
                        stack.push(arr[index][moves[i] - 1]);
                        arr[index][moves[i] - 1] = 0;

                        break;
                    }
                }
                index++;
            }
        }



        return answer;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int moves[] = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }
        System.out.println(tcg(arr, moves));
    }

}
