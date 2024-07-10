package BaekJoonPractice.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj9466 {
    static BufferedReader br;
    static StringTokenizer tk;
    static int res;
    static boolean[] visited;
    static boolean[] done;
    static int arr[];
    static void Dfs(int idx){
        if(done[idx]) return;
        if(visited[idx]){
            done[idx] = true;
            res+=1;
        }
        visited[idx] =true;
        Dfs(arr[idx]);
        done[idx] = true;
        visited[idx] = false;
    }

    public static void main(String[] args) throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            int len = Integer.parseInt(br.readLine());
            res = 0;
            arr = new int[len+1]; visited = new boolean[len+1]; done = new boolean[len+1];
            tk= new StringTokenizer(br.readLine());
            for(int j=1;j<=len;j++){
                arr[j] = Integer.parseInt(tk.nextToken());
            }
            for(int k=1; k<=len;k++){
                if(!done[k]){
                    Dfs(k);
                }
            }
            System.out.println(len - res);
        }
    }

}
