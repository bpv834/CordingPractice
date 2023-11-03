package InflearnForBeginner.String;

import java.util.Scanner;

public class TurnOverSpecialWord {
    static Scanner sc = new Scanner(System.in);

    static void tosw(String str){
        int lt = 0, rt = str.length() - 1;
        char ch[]=str.toCharArray();
        while (lt<rt){
            //특수문자면
            if(!Character.isAlphabetic(str.charAt(lt)))
                lt++;
            if(!Character.isAlphabetic(str.charAt(rt)))
                rt--;
            if(Character.isAlphabetic(str.charAt(lt))&&Character.isAlphabetic(str.charAt(rt))){
                char c=ch[lt];
                ch[lt] = ch[rt];
                ch[rt]=c;
                lt++;
                rt--;
            }
        }
        String result = "";
        for (char c:ch
        ) {
            result+=c;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        tosw(sc.next());
    }
}
