package String;

import java.util.Scanner;

public class StringPress {
    private static void sp(String str) {
        String result = "";
        String ch = "";
        int cnt=1;
        for (int i = 0; i < str.length(); i++) {
            if (!ch.equals(str.substring(i, i + 1))) {
                if(cnt!=1)
                    result+=cnt;
                cnt=1;
                ch = str.substring(i, i + 1);
                result+=ch;
            }
            else {
                cnt++;
            }
        }
        if(cnt!=1)
            result+=cnt;
        System.out.println(result);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sp(sc.nextLine());
    }
}
