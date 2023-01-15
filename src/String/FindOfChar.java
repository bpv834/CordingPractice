package String;

import java.util.Scanner;

public class FindOfChar {
    public static void Counter(String a, String b){
        int cnt=0;
        a = a.toLowerCase();
        b = b.toLowerCase();
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)==b.charAt(0))
                cnt++;
        }
        System.out.println(cnt);
    }
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String str1=sc.next();
        String str2 = sc.next();
        Counter(str1,str2);
    }
}
