package ProgramersPractice.tree;

import java.util.ArrayList;

public class SheepAndWolf {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int info[]=new int[]{0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {
                {0, 1},
                {1, 2},
                {1, 4},
                {0, 8},
                {8, 7},
                {9, 10},
                {9, 11},
                {4, 3},
                {6, 5},
                {4, 6},
                {8, 9}
        };
        System.out.println(solution.solution(info,edges));
    }
  static class Solution {
        void Dfs(int pos, int s, int w){
            System.out.println("Dfs진입"+" "+pos+" "+s+" "+w);

            if(visited[pos][s][w]) {
                System.out.println("방문했던 상황"+" "+pos+" "+s+" "+w);
                return;}


            visited[pos][s][w]=true;
            int backupS=s;
            int backupW=w;
            int backupNode = node[pos];


            if(node[pos] == 0) s++;
            else if(node[pos] == 1 ) w++;
            node[pos]=-1;
            maxS=Math.max(maxS,s);

            System.out.println("양, 늑대 수 카운팅: "+  s +" "+ w + " 노드 상태 변경 = "+ pos+"번vtx의 상태변경 "+node[pos] + " maxS= " +maxS);


            if(s>w){
                for(int next : graph.get(pos)){
                    System.out.println("for문 진입"+" pos=  "+pos+" next=  "+next);
                    Dfs(next,s,w);
                }
            }
            System.out.println("for문 후 Dfs탈출"+" "+pos+" "+s+" "+w);
            System.out.println("for문 후 Dfs탈출 백업노드="+" "+backupNode+" backupS= "+backupS+" backupW"+backupW);



            visited[pos][backupS][backupW]=false;
            node[pos]=backupNode;



        }
        ArrayList<ArrayList<Integer>> graph;
        int node[];
        int maxS=0;
        boolean visited[][][];
        public int solution(int[] info, int[][] edges) {
            graph=new ArrayList<>();
            node=info;
            visited=new boolean[17][18][18];


            for(int i=0;i<node.length;i++){
                graph.add(new ArrayList<>());
            }
            for(int i=0;i<edges.length;i++){
                graph.get(edges[i][0]).add(edges[i][1]);
                graph.get(edges[i][1]).add(edges[i][0]);
            }

            Dfs(0,0,0);
            return maxS;
        }
    }
}
