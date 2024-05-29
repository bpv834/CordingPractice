package ProgramersPractice.sort;

import java.util.Arrays;
import java.util.HashSet;

public class Tuple {
    public static void main(String[] args) {

    }
    class Solution {
        public int[] solution(String s) {
            //중복체크 위한 set
            HashSet set = new HashSet();
            //data parsing
            s=s.substring(0,s.length()-2).replace("{","");
            String[] strList = s.split("},");

            //크기 기준 오름차순 정렬
            Arrays.sort(strList,(o1, o2)-> o1.length()-o2.length());

            int result[] = new int[strList.length];
            int idx = 0;

            //String 배열 인덱스마다 접근
            for(String str : strList){
                String[] sp = str.split(",");

                //parsing 할 int 배열 생성
                int[] arr=new int[sp.length];

                for(int i=0;i<arr.length;i++){
                    //int 배열로 추출
                    arr[i] = Integer.parseInt(sp[i]);
                    //중복검사 해서 없으면 result배열에 넣기
                    if(!set.contains(arr[i])){
                        set.add(arr[i]);
                        result[idx++] = arr[i];
                    }
                }
            }
            return result;
        }
    }
}
