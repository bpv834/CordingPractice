package Array;


import java.util.Scanner;

public class FibonacciSequence {
    static Scanner sc = new Scanner(System.in);

    private static void fs(int n) {
        int arr[] = new int[n];
        arr[0]=arr[1]=1;
        String result = "1 1";
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
            result = result + " " + arr[i];
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        fs(sc.nextInt());
    }
}