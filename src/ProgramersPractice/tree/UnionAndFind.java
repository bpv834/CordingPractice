package ProgramersPractice.tree;

import java.util.Arrays;
import java.util.Comparator;

public class UnionAndFind {
    class Solution {
        int parent[];
        int find(int v){
            if(parent[v]==v) return v;
            else return find(parent[v]);

        }
        void union(int v1,int v2){
            int fv1 = find(v1);   //1과3이 연결=> find(1) == 3
            int fv2 = find(v2); // 5

            if(fv1<fv2) parent[fv1] =fv2;
            else parent[fv2] =fv1;
        }
        public int solution(int n, int[][] costs) {
            parent=new int[n];
            int answer = 0;
            for(int i=0;i<n;i++) parent[i]=i;
            Arrays.sort(costs, new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2){
                    return o1[02]-o2[02];
                }
            });

            for(int arr[] : costs ){
                System.out.println(arr[0]+" "+arr[1]+ " "+ arr[2]);
                if(find(arr[0])!=find(arr[1])){
                    union(arr[0],arr[1]);
                    answer+=arr[2];
                }

            }
            return answer;

        }
    }
}
