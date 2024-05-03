package ProgramersPractice.backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Combi {
   static ArrayList<ArrayList<Integer>> result=new ArrayList<>();
   static Scanner sc;
    static int n;

    static void  backTrack(int sum, ArrayList<Integer> selectedNums, int st ){

        System.out.println(sum +" " + st);
        if(sum == 10){
            result.add(selectedNums);
            return;
        }
        for(int i=st;i<=n;i++){
            if(sum+i<=10){
                System.out.println("i="+" "+i);
                ArrayList <Integer> list =new ArrayList<>(selectedNums);
                list.add(i);
                backTrack(sum+i,list,i+1);
            }
        }
    }
    public static void main(String[] args) {
        sc=new Scanner(System.in);
        n=sc.nextInt();
        ArrayList<Integer> lt=new ArrayList<>();
        backTrack(0, lt,1);
        for(ArrayList<Integer> i : result ){
            for (int x: i){
                System.out.println(x);
            }
        }
        System.out.println();

    }
}
