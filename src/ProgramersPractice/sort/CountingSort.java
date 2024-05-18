package ProgramersPractice.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountingSort {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
       br = new BufferedReader(new InputStreamReader(System.in));
       String str = br.readLine();
       int[] counts = new int[26];

       for(char ch : str.toCharArray()){
           System.out.println(ch);
           System.out.println(ch-'a');
           counts[ch - 'a']++;
       }
        System.out.println(Arrays.toString(counts));

       StringBuilder sortedStr = new StringBuilder();
       for(int i=0;i<26;i++){
           for(int j=0;j<counts[i];j++){
               sortedStr.append((char)(i+'a'));
           }
       }
        System.out.println(sortedStr);
    }
}
