package InflearnForBeginner.String;

import java.util.Scanner;

public class ChangeStringCase {
    static Scanner sc = new Scanner(System.in);

    static void ChangePrint(String str1){
        String str2="";
        for(int i=0;i<str1.length();i++) {
            if(Character.isUpperCase(str1.charAt(i)))
                str2=str2+str1.substring(i,i+1).toLowerCase();
            else str2 = str2 + str1.substring(i, i+1).toUpperCase();
        }
        System.out.println(str2);
    }
    public static void main(String[] args) {
        ChangePrint(sc.next());

    }
}
