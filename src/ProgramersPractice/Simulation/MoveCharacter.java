package ProgramersPractice.Simulation;

public class MoveCharacter {
    class Solution {
        public int[] solution(String[] keyinput, int[] board) {
            int[] answer = new int[2];
            int eLt = -board[0]/2;
            int eRt = board[0]/2;
            int top = board[1]/2;
            int btm = -board[1]/2;
            System.out.println(eLt + " "+ eRt+ " " + top + " "+btm );
            for(String str : keyinput){
                switch(str){
                    case("left") : System.out.println("left");
                        answer[0] -=1;
                        if(answer[0] < eLt) answer[0] = eLt;
                        break;

                    case("right") : System.out.println("right");
                        answer[0] +=1;
                        if(answer[0] > eRt) answer[0] = eRt;
                        break;

                    case("up") : System.out.println("up");
                        answer[1]+=1;
                        if(answer[1] > top) answer[1] = top;
                        break;

                    case("down") : System.out.println("down");
                        answer[1]-=1;
                        if(answer[1] < btm) answer[1] = btm;
                        break;
                }
            }
            return answer;
        }
    }
}
