package DfsBfs;

import java.util.Scanner;

public class ReculsiveFunction {
    static Scanner sc = new Scanner(System.in);

    private static int rf(int x) {
        int answer=0;

        if (x == 1) {
            return 1;
        } else answer = x + rf(x - 1);
        return answer;
    }

    private static int facto(int x) {
        int answer=0;

        if (x == 1) {
            return 1;
        } else answer = x * facto(x - 1);
        return answer;
    }

    private static void Nprint(int n) {
        String answer = "";
        if (n == 0) {
            return;
        }
        else {
            Nprint(n - 1);
            System.out.println(n+" ");
        }
    }



    public static void main(String[] args) {
        String answer = "";
        Nprint(sc.nextInt());
    }
}
