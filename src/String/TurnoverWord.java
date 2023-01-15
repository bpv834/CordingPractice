package String;

import java.util.Scanner;

public class TurnoverWord {
    static Scanner sc = new Scanner(System.in);
    static void turnoverWord(int n) {
        String strarr[]=new String[n];
        String arrriv[] = new String[n];
        for (int i = 0; i < strarr.length; i++) {
            strarr[i] = sc.next();
        }
        for (int i = 0; i < strarr.length; i++) {
            String riverse = "";
            for (int j = strarr[i].length(); j > 0; j--) {
                riverse = riverse + strarr[i].substring(j-1, j );
            }
            arrriv[i]=riverse;
        }
        for (String s : arrriv) {
            System.out.println(s);
        }


    }
    public static void main(String[] args) {
        turnoverWord(sc.nextInt());
    }

}
