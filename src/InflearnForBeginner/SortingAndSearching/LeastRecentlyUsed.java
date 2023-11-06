package InflearnForBeginner.SortingAndSearching;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LeastRecentlyUsed {
        static Scanner sc = new Scanner(System.in);

        static void lru(int n, int k) {
            Queue<Integer> Q = new LinkedList<>();
            String answer = "";
            int cm[]=new int[n];
            int overlap=0;
            int on=0;
            boolean checked = false;
            for (int i = 0; i < k; i++) {
                Q.offer(sc.nextInt());
            }
            for(int x=0;x<k;x++) {
                int tmp = Q.poll();
                for (int j = 0; j < n; j++) {
                    if (cm[j] == tmp) {
                        //캐시에 이미 존재하면 true
                        checked = true;
                        overlap=j;
                        on = cm[j];
                        break;
                    }
                    else {
                        checked = false;}
                }
                if(checked==false) {
                    //캐시에 존재하지 않은 데이터 입력 시
                    for (int i = n - 1; i > 0; i--) {
                        cm[i] = cm[i - 1];
                    }
                    cm[0] = tmp;
                }
                else {
                    //캐시에 존재하는 데이터 입력 시
                    for (int t = overlap; t > 0; t--) {
                        cm[t] = cm[t - 1];
                    }
                    cm[0]=on;
                }
            }
            for (int x:cm
                 ) {
                answer += x + " ";
            }
            System.out.println(answer);
        }


        public static void main(String[] args) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            lru(n, k);
        }
    }
