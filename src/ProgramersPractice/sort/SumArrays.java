package ProgramersPractice.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumArrays {
    static BufferedReader br;

    public static void main(String[] args) {
        br=new BufferedReader(new InputStreamReader(System.in));
        int[] arr1 = new int[]{1,3,5};
        int[] arr2 = new int[]{2,4,6,7};
        int[] sortedArr=new int[arr1.length + arr2.length];
        int p1=0;
        int p2=0;
        int p3 = 0;

        while (p1 < arr1.length && p2 < arr2.length){
            sortedArr[p3++] = arr1[p1] > arr2[p2]? arr2[p2++] : arr1[p1++];
        }
        for(int i=p1;i<arr1.length;i++){
            sortedArr[p3++] = arr1[p1++];
        }
        for(int i=p2;i<arr2.length;i++){
            sortedArr[p3++] = arr2[p2++];
        }

        System.out.println(Arrays.toString(sortedArr));

    }
}
