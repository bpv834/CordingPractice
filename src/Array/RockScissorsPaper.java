package Array;

import java.util.Scanner;

public class RockScissorsPaper {
    static Scanner sc = new Scanner(System.in);

   static private void rsp(int num) {
        int A[] = new int[num];
        int B[] = new int[num];
        for (int i = 0; i < num; i++) {
            A[i] = sc.nextInt();
        }
       for (int i = 0; i < num; i++) {
           B[i] = sc.nextInt();
       }
        for (int i = 0; i < num; i++) {
            switch (A[i]) {
                case 1:
                    if (B[i]==1) {
                        System.out.println("D");
                    }else if (B[i]==2) {
                        System.out.println("B");
                    }else {
                        System.out.println("A");
                    }break;
                case 2:
                    if(B[i]==1) {
                        System.out.println("A");
                    }
                    else if(B[i]==2) {
                        System.out.println("D");
                    }
                    else if(B[i]==3) {
                        System.out.println("B");
                    }break;
                case 3:
                    if(B[i]==1) {
                        System.out.println("B");
                    }
                    else if(B[i]==2){
                        System.out.println("A");
                    }
                    else if(B[i]==3) {
                        System.out.println("D");
                    }break;

            }
        }

    }

    public static void main(String[] args) {
        rsp(sc.nextInt());
    }
}

