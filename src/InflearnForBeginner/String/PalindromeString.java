package InflearnForBeginner.String;

import java.util.Scanner;

public class PalindromeString {
    private static void ps(String str){
        boolean checked=true;
        String result=str.toUpperCase();
        int cent=str.length()/2;
        char[] ch = result.toCharArray();
        for(int i=0;i<cent;i++){
            if(ch[i]!=ch[str.length()-i-1]) {
                checked = false;
            }

        }
        if(checked)
            System.out.println("YES");
        else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ps(sc.nextLine());
    }
}
