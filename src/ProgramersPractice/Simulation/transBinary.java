package ProgramersPractice.Simulation;

import java.io.BufferedReader;
import java.util.Arrays;

public class transBinary {
    static int[] result=new int[2];
    static int zeroCnt = 0;

    public static void main(String[] args) {
        String s = "110010101001";
        while (!s.equals("1")) {
            System.out.println(s);
            //0의 개수
            int zeroCount = s.replace("1", "").length();
            //1의 개수
            int len =s.length()- s.replace("1", "").length();
            zeroCnt +=zeroCount;
            ++result[0];
            s= Integer.toBinaryString(len);
        }
        result[1] = zeroCnt;
        System.out.println(Arrays.toString(result));
    }

}
