package String;

import java.util.Scanner;

public class ExtractionDigit {
    private static void ed(String str){
        String result = "";
        char ch[] = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(ch[i])) {
                result += ch[i];
            }
        }
        System.out.println(Integer.parseInt(result));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ed(sc.nextLine());
    }
}
