package BaekJoonPractice.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int ans=0;
        int arr[] = new int[n];
        int diff[] = new int[n - 1];
        String str = br.readLine();
        StringTokenizer tk = new StringTokenizer(str);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(diff);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(diff));
        for (int i = 0; i < n  - k; i++) {
            ans+=diff[i];
        }
        if (n <= k) {
            System.out.println(0);
        }
        else {
            System.out.println(ans);
        }
    }
}
