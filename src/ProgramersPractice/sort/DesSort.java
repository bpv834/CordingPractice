package ProgramersPractice.sort;

import java.util.Arrays;

public class DesSort {
    class Solution {
        public long solution(long n) {
            long answer = 0;
            String str = String.valueOf(n);
            char[]ch = str.toCharArray();
            Arrays.sort(ch);
            System.out.println(Arrays.toString(ch));
            String newStr = String.valueOf(ch);
            System.out.println(newStr);
            StringBuilder sb = new StringBuilder(newStr);
            sb.reverse();
            answer = Long.parseLong(sb.toString());
            return answer;
        }
    }
}
