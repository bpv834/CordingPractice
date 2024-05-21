package ProgramersPractice.sort;

import java.util.Arrays;

public class KthNumber {
    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] result= new int[commands.length];

            for(int i=0;i<commands.length;i++){
                int st = commands[i][0]-1;
                int fi = commands[i][1];
                int k = commands[i][2];

                int[] ca = Arrays.copyOfRange(array,st,fi);
                Arrays.sort(ca);
                result[i]=ca[k-1];
                System.out.println(Arrays.toString(ca));
            }

            return result;
        }
    }
}
