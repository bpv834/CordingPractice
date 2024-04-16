package ProgramersPractice.Hash;

import java.util.Arrays;

public class NumberList {
    class Solution {

        public boolean solution(String[] phone_book) {
            Arrays.sort(phone_book);

            for(int i=0;i<phone_book.length-1;i++){
                String preStr=phone_book[i];
                String postStr=phone_book[i+1];

                if(postStr.startsWith(preStr)) return false;
            }
            return true;
        }
    }
}
