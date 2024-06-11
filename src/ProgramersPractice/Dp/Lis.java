package ProgramersPractice.Dp;

import java.util.Arrays;

public class Lis {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,2,3,1,5,7,3};
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
