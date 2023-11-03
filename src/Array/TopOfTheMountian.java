package Array;

import java.util.Scanner;

public class TopOfTheMountian {
    static Scanner sc = new Scanner(System.in);

    private static void tom(int n) {
        int arr[][] = new int[n][n];
        int dx[] = new int[]{-1, 0, 1, 0};
        int dy[] = new int[]{0, 1, 0, -1};
        int cnt=0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean check = true;
                for (int k = 0; k < 4; k++) {
                    int nx=i+dx[k];
                    int ny=j+dy[k];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] > arr[i][j]) {
                        check=false;
                        break;
                    }
                }
                if(check==true)
                    cnt++;

            }

        }
        System.out.println(cnt);

    }

    public static void main(String[] args) {
        tom(sc.nextInt());
    }
}