package ProgramersPractice.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LookForExit {
    class Solution {
        class Point{
            int x;
            int y;
            Point(int x, int y){
                this.x=x;
                this.y=y;
            }
        }
        Point sPoint;
        Point ePoint;
        Point lPoint;
        char[][] board;
        Queue<Point> qToLever=new LinkedList<>();
        Queue<Point> qToEnd=new LinkedList<>();
        int[][] distL;
        int[][] distE;
        int[] dy=new int[]{-1,1,0,0};
        int[] dx=new int[]{0,0,-1,1};
        int ans;
        boolean flag=false;
        boolean isArrived=false;

        void endBfs(int x, int y, int w, int h){
            qToEnd.add(new Point(x,y));
            while(!qToEnd.isEmpty()){
                Point tmp = qToEnd.poll();
                if(board[tmp.x][tmp.y]== 'E'){
                    ans+=distE[tmp.x][tmp.y];
                    isArrived=true;
                    return;
                }else{
                    for(int i=0;i<4;i++){
                        int nx=tmp.x+dy[i];
                        int ny=tmp.y+dx[i];
                        if(nx>=0 && nx<w && ny>=0 && ny<h && distE[nx][ny]==-1 && board[nx][ny]!='X'){
                            distE[nx][ny]=distE[tmp.x][tmp.y]+1;
                            qToEnd.add(new Point(nx,ny));
                        }

                    }
                }

            }
        }

        void Bfs(int x, int y, int w, int h){
            qToLever.add(new Point(x,y));
            while(!qToLever.isEmpty()){
                Point tmp = qToLever.poll();
                if(board[tmp.x][tmp.y]== 'L'){
                    ans=distL[tmp.x][tmp.y];
                    flag=true;
                    distE[tmp.x][tmp.y]=0;
                    endBfs(tmp.x,tmp.y,w,h);
                }else{
                    for(int i=0;i<4;i++){
                        int nx=tmp.x+dy[i];
                        int ny=tmp.y+dx[i];
                        if(nx>=0 && nx<w && ny>=0 && ny<h && distL[nx][ny]==-1 && board[nx][ny]!='X'){
                            distL[nx][ny]=distL[tmp.x][tmp.y]+1;
                            qToLever.add(new Point(nx,ny));
                        }

                    }
                }

            }
        }

        public int solution(String[] maps) {
            int w= maps.length;
            int h= maps[0].length();
            board=new char[w][h];
            distL=new int[w][h];
            distE=new int[w][h];
            for(int i=0;i<w;i++){
                Arrays.fill(distL[i],-1);
                Arrays.fill(distE[i],-1);
            }
            for(int i=0;i<w;i++){
                for(int j=0;j<h;j++){
                    board[i][j]=maps[i].charAt(j);
                    if(board[i][j]=='S'){
                        sPoint=new Point(i,j);
                    }
                    if(board[i][j]=='E'){
                        ePoint=new Point(i,j);
                    }
                    if(board[i][j]=='L'){
                        lPoint=new Point(i,j);
                    }
                }
            }
            int answer = 0;

            distL[sPoint.x][sPoint.y]=0;
            Bfs(sPoint.x,sPoint.y,w,h);
            if(isArrived){
                answer=ans;
            }else{
                answer=-1;
            }
            return answer;
        }
    }
}
