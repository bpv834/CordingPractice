package Array;

import java.util.Scanner;

public class InterimClassLeader {
    static Scanner sc = new Scanner(System.in);

    private static void icl(int n) {
        int arr[][] = new int[n][5];
        int leader=0;
        int value=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

            for (int i = 0; i < n; i++) {
                int cnt=1;
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < n; k++) {
                        if (k!=i && arr[i][j] == arr[k][j]) {
                            cnt++;
                            break;
                        }
                    }

            }
                if (cnt > value) {
                    value=cnt;
                    leader=i+1;
                }
        }
        System.out.println(leader);
        }
    public static void main(String[] args) {
        icl(sc.nextInt());
    }
}
