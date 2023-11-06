    package InflearnForBeginner.DynamicProgramming;

    import java.util.Scanner;

    public class GoingUpTheStairs {
        static Scanner sc = new Scanner(System.in);
        static int n = sc.nextInt()+1;
        static int dy[] = new int[n + 1];
        static int answer=0;
        public static void main(String[] args) {
        dy[1]=1;
        dy[2]=2;
            for (int i = 3; i <= n; i++) {
                dy[i]=dy[i-2]+dy[i-1];
            }
            System.out.println(dy[n]);
        }

    }
