import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int arr[][] = new int[n][2];
    static int tmp[] = new int[2];
    static int cnt=0;

    static void arrList(int arr[][]) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0]-o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
    }

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        arrList(arr);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 1; j++) {
                if (arr[i][0] >= tmp[1]) {
                    ++cnt;
                    tmp[0] = arr[i][0];
                    tmp[1] = arr[i][1];
                }
            }
        }
        System.out.println(cnt);
    }
}


