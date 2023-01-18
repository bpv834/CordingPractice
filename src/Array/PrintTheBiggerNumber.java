package Array;

import java.util.Scanner;

public class PrintTheBiggerNumber {
        static Scanner sc = new Scanner(System.in);
        private static void ptvn(int num) {
            String result = "";
            int arr[] = new int[num];
            for (int i =0; i < num; i++) {
                arr[i] = sc.nextInt();
                if (i > 0)
                    if (arr[i] > arr[i - 1]) {
                        result = result +" " + arr[i];
                    }
            }
            System.out.println(arr[0]+result);
        }

        public static void main(String[] args) {
            ptvn(sc.nextInt());
        }
}
