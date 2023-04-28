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



    public static void main(String[] args) {
        System.out.println(rf(10));
        String str = "식빵맨";
        System.out.println(str+1);
        System.out.println(facto(5));
    }
}
