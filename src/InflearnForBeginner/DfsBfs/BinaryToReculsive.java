package InflearnForBeginner.DfsBfs;

import java.util.Scanner;

public class BinaryToReculsive {
    static Scanner sc = new Scanner(System.in);
    static String answer="";

    private static void btr(int n) {
        if (n > 1) {
            btr(n / 2);
            answer +=" "+ n % 2;
        } else {
            answer += 1;
        }

    }

    public static void main(String[] args) {
        btr(11);
        System.out.println(answer);
    }
}
