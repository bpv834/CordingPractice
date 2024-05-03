package ProgramersPractice.backtracking;

public class Tiredness {
    class Solution {
        int ans=0;
        boolean[] ch;
        void Dfs(int k,int[][] dungeons, int depth){

            for(int i=0;i<dungeons.length;i++){
                if(!ch[i] && k>=dungeons[i][0]) {
                    ch[i]=true;
                    Dfs(k-dungeons[i][1],dungeons,depth+1);
                    ch[i]=false;
                }
            }
            ans=Math.max(depth,ans);

        }
        public int solution(int k, int[][] dungeons) {
            ch=new boolean[dungeons.length];
            Dfs(k,dungeons,0);
            return ans;
        }
    }
}
