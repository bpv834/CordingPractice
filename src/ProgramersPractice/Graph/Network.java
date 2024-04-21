package ProgramersPractice.Graph;

public class Network {

    class Solution {
        void Dfs(int y, int computers[][]){
            System.out.println("y= "+y);
            ch[y]=1;

            for(int i=0; i< computers[0].length; i++){
                if(ch[i] == 0 && computers[y][i] == 1){
                    Dfs(i,computers);
                }
            }

        }
        int[] ch;
        int cnt=0;
        public int solution(int n, int[][] computers) {
            ch=new int[computers.length];
            for(int i=0;i<computers.length;i++){
                if(ch[i] == 0){
                    System.out.println("i= "+i);
                    cnt++;
                    Dfs(i,computers);
                }
            }
            int answer = cnt;
            return answer;
        }
    }
}
