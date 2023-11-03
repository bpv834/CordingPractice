package String;

import java.util.Scanner;

public class RemoveForOverlappedWord {
    static Scanner sc = new Scanner(System.in);

    static void rfolw(String str){
        boolean check[] = new boolean[str.length()];
        char ch[] = str.toCharArray();
        String result = "";
        for(int i=0;i<str.length();i++){
            if(!check[i]){
                result += ch[i];
                for(int j=i+1;j<str.length();j++){
                    if(ch[i]==ch[j])
                        check[j]=true;
                }

            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        rfolw(sc.next());
    }
}
