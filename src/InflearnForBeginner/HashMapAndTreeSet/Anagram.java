package InflearnForBeginner.HashMapAndTreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
    static Scanner sc = new Scanner(System.in);

    private static void a(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();
        int sum1=0,sum2=0;
        for (char x:str1.toCharArray()
             ) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char x:str2.toCharArray()
        ) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                System.out.println("NO");
                return;
            }
                map.put(x, map.get(x) - 1);

        }
        System.out.println("YES");


    }

    public static void main(String[] args) {
        String str1 = sc.next();
        String str2 = sc.next();

        a(str1, str2);
    }
}
