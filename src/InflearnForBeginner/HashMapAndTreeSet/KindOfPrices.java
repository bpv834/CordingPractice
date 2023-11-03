package InflearnForBeginner.HashMapAndTreeSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class KindOfPrices {
    static Scanner sc = new Scanner(System.in);

    private static void kop(int m, int n,int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int lt=0,rt=n;
        while (rt < m) {
            arrayList.add(map.size());
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            rt++;
            if (map.get(arr[lt]) > 1) {
                map.put(arr[lt], map.get(arr[lt]) - 1);
            }
            else if(map.get(arr[lt]) == 1){
                map.remove(arr[lt]);
            }
            lt++;
        }
        arrayList.add(map.size());
        String result = "";
        for (int i:arrayList
             ) {
            result = result + " " + i;
        }
        result = result.substring(1);
        System.out.println(result);

    }

    public static void main(String[] args) {
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[] = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        kop(m,n,arr);
    }
}
