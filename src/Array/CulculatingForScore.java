package Array;

import java.util.Scanner;

public class CulculatingForScore {
    static Scanner sc = new Scanner(System.in);

    private static void cfs(int n) {
        int cnt=0;
        int result=0;
        boolean toggle=false;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1)
                toggle = true;
            System.out.println(arr[i]+" "+toggle);
            if (toggle) {
                cnt++;
                toggle = false;
            }
            else {
                toggle=false;
                cnt=0;
            }
            result+=cnt;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        cfs(sc.nextInt());
    }
}
