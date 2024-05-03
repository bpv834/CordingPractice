package ProgramersPractice.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sudoku {
    static BufferedReader br;
    static int board[][];

    static class Block {
        int y;
        int x;

        Block(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static boolean inRow(int num, int row){
        for(int i=0;i<9;i++){
            if(board[row][i] == num) return true;
        }
        return false;
    }

    static boolean inCol(int num, int col){
        for(int i=0;i<9;i++){
            if(board[i][col] == num) return true;
        }
        return false;
    }

    static boolean inBox(int num, int row, int col){
        int boxRow = (row/3) * 3;
        int boxCol = (col/3) * 3;

        for(int i=boxRow; i<boxRow+3; i++){
            for(int j=boxCol; j<boxCol+3;j++){
                if(board[i][j] == num) return true;
            }
        }
        return false;
    }
    static boolean isValid(int num, int row, int col){
        return !(inRow(num,row)|| inCol(num,col)||inBox(num,row,col));
    }

    static Block findEmptyBlock(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == 0) return new Block(i,j);
            }
        }

        return null;
    }
    static boolean Dfs(){
        Block tmp = findEmptyBlock();

        //빈블록이 없는경우 true
        if(tmp == null) return true;

        int row = tmp.y;
        int col = tmp.x;


        for(int i=1; i<10; i++){
            if(isValid(i,row, col)){
                board[row][col] = i;
                //빈블록이 없는 경우 트루를 반환하고, 반환값이 true 면 return true를 함 따라서 빈블록인경우 true 리턴 후 마침
                if(Dfs()) return true;
            }
        }
        board[row][col] = 0;
        return false;
    }

    public static void main(String[] args) throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        board=new int[9][9];
        for (int i = 0; i < 9; i++) {
            String str=br.readLine();
            StringTokenizer tk=new StringTokenizer(str);
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        Dfs();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
