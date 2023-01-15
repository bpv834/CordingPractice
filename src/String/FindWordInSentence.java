package String;

import java.util.Scanner;

public class FindWordInSentence {
    private static void splitWord(String string){
        String str[]=string.split(" ");
        String str2=str[0];
        for(int i=0; i<str.length;i++){
            if(str[i].length()>str2.length())
                str2 = str[i];
        }
        System.out.println(str2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        splitWord(sc.nextLine());
    }
}
