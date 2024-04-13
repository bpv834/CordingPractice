package ProgramersPractice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class dd {

    public static void main(String[] args) {
        String[] strings = new String[3];
        int n = strings.length;
    }





    class Solution {
        Point sPoint;
        Point ePoint;
        Point LPoint;
        char[][] board;
        int[][] dist;
        int ans;
        class Point{
            int x;
            int y;
            Point(int x, int y){
                this.x=x;
                this.y=y;
            }
        }

        Queue<Point> q= new LinkedList<>();
        boolean flag=false;
        int col[]=new int[]{0,0,-1,1};
        int row[]=new int[]{1,-1,0,0};


        public int solution(String[] maps) {
            int width=maps[0].length();
            int height=maps.length;
            board=new char[width][height];
            dist=new int[width][height];
            for (int i = 0; i < height; i++) {
                Arrays.fill(dist[i], -1); // 각 행을 -1로 채움
            }

            for(int i=0;i<height;i++){
                for(int j=0;j<width;j++){
                    if(maps[i].charAt(j)=='S') {
                        sPoint=new Point(i,j);
                    }
                    if(maps[i].charAt(j)=='E'){
                        ePoint=new Point(i,j);
                    }
                    if(maps[i].charAt(j)=='L'){
                        LPoint=new Point(i,j);
                    }
                    board[i][j]=maps[i].charAt(j);
                }
            }
            dist[sPoint.x][sPoint.y]=0;
            Bfs(sPoint.x,sPoint.y, width, height);
            int answer = 0;
            return answer;
        }
        void Bfs(int x, int y,int width, int height){
            q.add(new Point(x,y));
            while(!q.isEmpty()){
                Point tmp=q.poll();
                if(flag && board[tmp.x][tmp.y]=='E'){
                    System.out.println("E도착!");
                    System.out.println(dist[tmp.x][tmp.y]);
                    ans += dist[tmp.x][tmp.y];

                }
                if(board[tmp.x][tmp.y]=='L'){
                    flag=true;
                    System.out.println(dist[tmp.x][tmp.y]);
                    ans = dist[tmp.x][tmp.y];
                    dist[tmp.x][tmp.y]=0;

                }
                for(int i=0;i<4;i++){
                    int nx=tmp.x+col[i];
                    int ny=tmp.y+row[i];
                    if(nx>=0&& nx<width&&ny>=0&&ny<height&&(board[nx][ny] != 'X') &&dist[nx][ny]==-1){
                        System.out.println("nx="+nx+" ny= "+ny);
                        dist[nx][ny]=dist[tmp.x][tmp.y]+1;
                        q.add(new Point(nx,ny));
                    }
                }
            }
        }
    }
}
