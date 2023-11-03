package InflearnForBeginner.GreedyAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class UnionAndFind {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int m = sc.nextInt();
    static int p1, p2;
    static String answer = "NO";
    static int parent[] = new int[n + 1];

    //서로소인지 확인하는 메서드 서로소가 아니라면 부모를 찾아주고 결국 재귀로 본인까지 리턴돼야 함 return parent[v]=find(parent[v]); 중요
    static int find(int v) {
        if (v == parent[v]) return v;
        else {
            System.out.println("find(parent[v])= "+find(parent[v])+" parent[v]= "+parent[v]);
            return parent[v] = find(parent[v]);
        }
    }

    //관계를 맺어주는 메서드
    static void union(int a, int b) {
        System.out.println("a= " + a + " b= " + b);
        int fa = find(a);
        int fb = find(b);
        //fa와 fb가 같다면 둘 사이에 부모가 존재한다. 보통 낮은 숫자가 부모
        if (fa != fb) {
            parent[fb] = fa;
            System.out.println(Arrays.toString(parent));
            System.out.println("fa= " + fa + " fb= " + fb);
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= n; i++)
            parent[i] = i;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }
        System.out.println(Arrays.toString(parent));
        p1 = sc.nextInt();
        p2 = sc.nextInt();
        if (find(p1) == find(p2))
            answer = "YES";
        System.out.println(answer);

    }
}
