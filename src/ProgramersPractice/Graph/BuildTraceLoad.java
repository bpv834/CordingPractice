package ProgramersPractice.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTraceLoad {
    public static void main(String[] args) {
        int board[][] = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 1, 0, 0},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0}
        };
        Solution solution = new Solution();
        solution.solution(board);
    }
    static class Solution {
        class Node{
            int y;
            int x;
            int dir;

            Node(int y, int x, int dir){
                this.y=y;
                this.x=x;
                this.dir=dir;
            }
        }
        int dist[][][];
        int[] dy =new int[]{-1,1,0,0};
        int[] dx = new int[]{0,0,-1,1};
        Queue<Node> q;

        public int solution(int[][] board) {
            q=new LinkedList<>();
            dist=new int [board.length][board[0].length][4];
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length; j++){
                    //4방향에 max_value로 초기화
                    dist[i][j][0]=Integer.MAX_VALUE;
                    dist[i][j][1]=Integer.MAX_VALUE;
                    dist[i][j][2]=Integer.MAX_VALUE;
                    dist[i][j][3]=Integer.MAX_VALUE;
                }
            }
            dist[0][0][0]=0;
            dist[0][0][1]=0;
            dist[0][0][2]=0;
            dist[0][0][3]=0;

            if(board[0][1] == 0) {
                //0,1 이 뚫려있다면, 우측방향을 Q에 추가
                dist[0][1][3] = 100;
                q.add(new Node(0,1,3));
            }
            if(board[1][0] == 0) {
                //1,0 이 뚫려있다면, 아래방향을 Q에 추가
                dist[1][0][1] = 100;
                q.add(new Node(1,0,1));
            }

            while(!q.isEmpty()){
                Node tmp = q.poll();

                for(int i=0;i<4;i++){
                    int ny = tmp.y+dy[i];
                    int nx = tmp.x+dx[i];
                    int ndir = tmp.dir+i;
                    if(ny>=0 && ny <board.length && nx >=0&& nx<board[0].length && board[ny][nx]==0){
                        if(ndir == 5 || ndir==1) continue; // 역방향은 가지 않는다
                        if(i== tmp.dir){
                            //직진인 경우
                            if(dist[ny][nx][i]> dist[tmp.y][tmp.x][tmp.dir] + 100){
                                dist[ny][nx][i] = dist[tmp.y][tmp.x][i] + 100;
                                q.add(new Node(ny,nx,i));
                            }
                        }else{
                            //커브가 생긴 경우
                            //가려는 방향 값이 큰 경우 값을 변경해준다.
                            if(dist[ny][nx][i]> dist[tmp.y][tmp.x][tmp.dir] + 600){
                                dist[ny][nx][i] = dist[tmp.y][tmp.x][tmp.dir] + 600;
                                q.add(new Node(ny,nx,i));
                            }

                        }
                    }
                }
            }
            int answer = dist[board.length-1][board[0].length-1][0];
            for(int i=0;i<4;i++){
                //종착지에서 4방향 다 검사해 최소값을 answer에 닮는다
                answer = Math.min(answer, dist[board.length-1][board[0].length-1][i]);
            }
            return answer;
        }
    }
}
