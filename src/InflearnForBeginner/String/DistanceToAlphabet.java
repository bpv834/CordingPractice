package InflearnForBeginner.String;

import java.util.Scanner;

public class DistanceToAlphabet {
    private static void dta(String str, String ch){
        String result = "";
        int[] arr=new int[str.length()];
        int dt=1000;
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i,i+1).equals(ch)) {
                dt=0;
            }
            arr[i]=dt;
            dt++;
        }
        for (int i = str.length()-1; i >= 0; i--) {
            if (str.substring(i,i+1).equals(ch)) {
                dt=0;
            }
            if (arr[i] > dt) {
                arr[i]=dt;
            }
            dt++;
        }
        result += arr[0];
        for (int i = 1; i < str.length(); i++) {
            result+=" "+arr[i];
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        String ch = sc.next();
        dta(str, ch);
    }
}
