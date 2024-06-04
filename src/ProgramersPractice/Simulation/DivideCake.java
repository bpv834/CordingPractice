package ProgramersPractice.Simulation;

import java.util.HashMap;
import java.util.HashSet;

public class DivideCake {
   static public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int x : topping){
            map.put(x, map.getOrDefault(x,0)+1);
        }

       for(int z : map.keySet()){
           System.out.println(z + "@@@@ " + map.get(z));
       }

        for(int x : topping){
            if(map.get(x) == 1) map.remove(x);
            else map.put(x,map.get(x)-1);
            set.add(x);
            for(int z : map.keySet()){
                System.out.println(z + " " + map.get(z));
            }
            System.out.println(set);
            if(set.size() == map.size()){
                System.out.println(set);
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int ans = solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2});
        System.out.println("ans= "+ans);
    }
}
