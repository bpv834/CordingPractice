package String;

import java.util.Scanner;

public class TranslationOnCrypto {
    private static void toc(String str) {
        //특수문자로 변환
        str= str.replaceAll("#", "1");
        str=str.replaceAll("\\*", "0");
        int Lcnt = str.length()/7;
        String result[] = new String[Lcnt];
        String crypto = "";
        int cnt=0;
        for (int i = 0; i < Lcnt; i++) {
            result[i]=str.substring(cnt, cnt+7);
            cnt+=7;
        }
        //10진수 변환 코드
        for (int i = 0; i < Lcnt; i++) {
            int cord=0;
            int index=0;
            while (index < 7) {
                switch (index) {
                    case 0:
                        if (result[i].charAt(index) == '1') {
                            cord+=64;
                        }
                        index++;
                    case 1:
                        if (result[i].charAt(index) == '1') {
                            cord+=32;
                        }
                        index++;
                    case 2:
                        if (result[i].charAt(index) == '1') {
                            cord+=16;
                        }
                        index++;
                    case 3:
                        if (result[i].charAt(index) == '1') {
                            cord+=8;
                        }
                        index++;
                    case 4:
                        if (result[i].charAt(index) == '1') {
                            cord+=4;
                        }
                        index++;
                    case 5:
                        if (result[i].charAt(index) == '1') {
                            cord+=2;
                        }
                        index++;
                    case 6:
                        if (result[i].charAt(index) == '1') {
                            cord+=1;
                        }
                        index++;

                }
            }
            crypto+=(char)cord;
        }

        System.out.println(crypto);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        toc(sc.nextLine());
        String binary = "1000001";
        int num = Integer.parseInt(binary, 2);
        System.out.println(num);
    }
}
