package InflearnForBeginner.Array;

import java.util.Scanner;

public class ReversePrimeNumber {

    private static Scanner sc = new Scanner(System.in);

    static void rpn(int n) {
        String str[]=new String[n];
        String result[] = new String[n];
        int arr[] = new int[n];
        String answer = "";
        for (int i = 0; i < n; i++)
            str[i] = sc.next();
        System.out.println("for문 동작 시작");
        for (int i = 0; i < n; i++) {
            int lt = 0, rt = str[i].length() - 1;
            char temp;
            char ch[] = str[i].toCharArray();
            while (lt < rt) {
                temp = ch[lt];
                ch[lt] = ch[rt];
                ch[rt] = temp;
                lt++;
                rt--;
            }
            result[i] = "";
            for (char c:ch
                 ) {
                result[i]+=c;
            }
            arr[i] = Integer.parseInt(result[i]);
        }
        for (int i = 0; i < n; i++) {
            int cnt=0;
            for (int j = 2; j < arr[i] - 1; j++) {
                if(arr[i]%j==0)
                    cnt++;
            }
            if(cnt==0&arr[i]!=1)
                answer=answer+" "+arr[i];
        }
        answer = answer.substring(1);
        System.out.println(answer);

    }

    public static void main(String[] args) {
        rpn(sc.nextInt());
    }
}
