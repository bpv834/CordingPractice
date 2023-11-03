package InflearnForBeginner.HashMapAndTreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class ClassCaptian {
    static Scanner sc = new Scanner(System.in);

    private static void cc(int n,String str) {
        char c[] = new char[n];
        int value = Integer.MIN_VALUE;
        c = str.toCharArray();
        char ch = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : c) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : map.keySet()) {
            if (map.get(x) > value) {
                value = map.get(x);
                ch=x;
            }
        }
        System.out.println(ch);
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        String str = sc.next();
        cc(n, str);
    }
}
