package ProgramersPractice.Simulation;

import java.util.Arrays;

public class MatrixMultiply {
    static int[][] transArr(int[][] multiArr){
        int[][] result = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                result[i][j] = multiArr[j][i];
            }
        }
        return result;
    }
    static int[][] multiArr =new int[3][3];
    public static void main(String[] args) {

        int[][] matrix1 =
                {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                };
        int[][] matrix2 = {
                {9,8,7},
                {6,5,4},
                {3,2,1}
        };

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    multiArr[i][j] += matrix1[i][k] * matrix2[k][j];
                    System.out.println(multiArr[i][j]);
                }
            }
        }
        multiArr = transArr(multiArr);

        for(int[] x : multiArr){
            System.out.print(Arrays.toString(x)+" ");
            System.out.println();
        }

    }
}
