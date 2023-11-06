package InflearnForBeginner.TwoPointerAndSlidingWindow;

import java.util.Arrays;
import java.util.Scanner;

public class MaxLengthOfCuncencutiveSequence {
    static Scanner sc = new Scanner(System.in);

    private static void mlocs(int m, int k) {
        int arr[] = new int[m];
        int zero[] = new int[m];
        int index=0;
        int cnt=0;
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        int answer=0;
        int lt=0,rt=0;
        int l=0;
        while (rt < m) {

            if (arr[rt] == 0) {
                zero[index++]=rt;
                if (cnt < k) {
                    System.out.println("1.lt= "+lt+" rt= "+rt+" answer= "+answer+" cnt= "+cnt+ " "+Arrays.toString(arr)+" "+Arrays.toString(zero));
                    cnt++;
                    arr[rt++]=1;
                }
                else if (cnt>=k){
                    //cnt>=k
                    System.out.println("2.lt= "+lt+" rt= "+rt+" answer= "+answer+" cnt= "+cnt+ " "+Arrays.toString(arr)+" "+Arrays.toString(zero));
                    lt = zero[l++];
                    arr[lt]=0;
                    arr[rt++]=1;
                }
            }
            else if(arr[rt]==1){
                System.out.println("3.lt= "+lt+" rt= "+rt+" answer= "+answer+" cnt= "+cnt+ " "+Arrays.toString(arr)+" "+Arrays.toString(zero));
                answer=Math.max(rt-lt,answer);
                rt++;
            }
        }
        System.out.println("정답= "+answer);
    }

    public static void main(String[] args) {
        int m = sc.nextInt();
        int k = sc.nextInt();
        mlocs(m,k);
    }
}
