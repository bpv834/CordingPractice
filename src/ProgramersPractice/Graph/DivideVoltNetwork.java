package ProgramersPractice.Graph;

import java.util.ArrayList;

public class DivideVoltNetwork {
    class Solution {
        ArrayList<ArrayList<Integer>> graph;

        void Dfs(int st, boolean[] ch){
            ch[st] = true;
            for(int v:graph.get(st)){
                if(!ch[v]) Dfs(v,ch);
            }

        }
        public int solution(int n, int[][] wires) {
            graph = new ArrayList<>();

            for(int i=0;i<n+1; i++){
                graph.add(new ArrayList<>());
            }

            for(int[] arr : wires){
                int v1 =arr[0];
                int v2 = arr[1];
                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }
            int answer = 101;
            for(int i=0; i<wires.length;i++){
                int  to = wires[i][0];
                int from = wires[i][1];

                graph.get(to).remove(Integer.valueOf(from));
                graph.get(from).remove(Integer.valueOf(to));

                boolean[] ch = new boolean[n+1];
                Dfs(1,ch);
                int cnt =0;
                for(int j=0;j<=n;j++){
                    if(ch[j]) cnt++;
                }
                int ans = Math.abs(cnt - (n-cnt));
                answer=Math.min(answer,ans);
                graph.get(to).add(from);
                graph.get(from).add(to);
            }



            return answer;
        }
    }
}
