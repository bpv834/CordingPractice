package ProgramersPractice.backtracking;

public class NQueen {


    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.solution(8);
        System.out.println(solution.ans);
    }
   static class Solution {
        int board[][];
        int ans;

       void printArr(){
           for(int i=0;i<board.length;i++){
               for(int j=0;j<board.length;j++){
                   System.out.print(board[i][j]+" ");
               }
               System.out.println();
           }
       }

        void Dfs(int depth){
           printArr();
            System.out.println();

            if(depth == board.length){
                ans++;
                return;
            }
            for(int i=0;i<board.length;i++){
                if(isVallid(depth,i)){
                    board[depth][i] = 1;
                    Dfs(depth+1);
                    board[depth][i] = 0;
                }
            }
        }

        boolean isVallid(int row, int col){
            //같은 열에 queen이 존재 하는지
            for(int i=row; i>=0;i--){
                if(board[i][col] == 1) return false;
            }

            int d = row-col;
            int s = row+col;

            for(int i=row; i>=0; i--){
                for(int j=0; j<board.length; j++){
                    if(i-j == d && board[i][j] == 1 ){
                        return false;
                    }
                }
            }

            for(int i=row; i>=0; i--){
                for(int j=0; j<board.length; j++){
                    if(i+j == s && board[i][j] == 1 ){
                        return false;
                    }
                }
            }
            return true;
        }


        public int solution(int n) {
           board=new int[n][n];
            Dfs(0);
            return ans;
        }
    }
}
