package HashMapAndTreeSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SequenceKnmumber {
    static Scanner sc = new Scanner(System.in);

    private static void sk(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int value=0;
        ArrayList<Integer> answer = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        for (int a:arr
             ) {
            list.add(a);
        }
        Collections.sort(list);
        int L = list.size();
        for (int i = 0;i<L;i++ ) {
            for (int j = 0; j < L; j++) {
                for (int t = 0; t < L;t++ ) {
                    if((i!=j && j!=t && t!=i)) {
                        value = list.get(i) + list.get(j) + list.get(t);
                        answer.add(value);
                    }
                }
            }
        }
        Collections.sort(answer,Collections.reverseOrder());
        list.clear();
        for (int a:answer
             ) {
            if (!list.contains(a)) {
                list.add(a);
            }
        }
        if (list.size() <= k) {
            System.out.println("-1");
        }
        else {
            System.out.println(list.get(k-1));
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int arr[] = new int[n];
        int k = sc.nextInt();
        sk(arr, k);
    }
}
