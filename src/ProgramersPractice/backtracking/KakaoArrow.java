package ProgramersPractice.backtracking;

import java.util.Arrays;

public class KakaoArrow {
    class Solution {
        int max = 0;
        int[] result = new int[11];
        int[] apeach;

        int getScore(int[] ryan){
            int score = 0;
            for(int i=0;i<11;i++){
                if(apeach[i] + ryan[i] >0){
                    score += ryan[i] > apeach[i] ? (10-i) : -(10-i);
                }
            }
            return score;
        }
        void calc(int[] ryan){
            int score = getScore(ryan);
            if(max < score){
                max = score;
                result = ryan.clone();
            } else if(max >0 && max == score){
                for(int i=10;i>=0;i--){
                    if(ryan[i] != result[i]){
                        if(ryan[i]>result[i]){
                            result = ryan.clone();
                        }
                        break;
                    }
                }
            }
        }
        void backTrack(int n, int idx, int[] ryan){
            System.out.println(Arrays.toString(ryan));
            if(n==0){
                calc(ryan);
                return;
            }
            for(int i=idx; i<=10; i++){
                int cnt = Math.min(n,apeach[i]+1);
                ryan[i] = cnt;
                backTrack(n-cnt, i+1, ryan);
                ryan[i] = 0;
            }

        }
        public int[] solution(int n, int[] info) {
            apeach = info;
            backTrack(n,0,new int[11]);

            return max == 0 ? new int[]{-1} : result;
        }
    }
}
