package BaekJoonPractice.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.StringTokenizer;

public class TwoSixSixSeven {
    static BufferedReader br;
    static int n;
    static char board[][];
    static int ch[][];
    static int cnt = 0;
    static String answer = "";
    static int house = 0;
    static int dCol[] = new int[]{-1, 1, 0, 0};
    static int dRow[] = new int[]{0, 0, -1, 1};
    static ArrayList<Integer> houseArr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        ch = new int[n][n];

        for (int i = 0; i < n; i++) {
            String Col = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = Col.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '1' && ch[i][j] == 0) {
                    ++cnt;
                    ch[i][j] = cnt;
                    Dfs(i, j, cnt);
                    houseArr.add(house);
                    house = 0;
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(houseArr);
        for (int ha:houseArr
             ) {
            System.out.println(ha);
        }
    }

    static void Dfs(int col, int row, int number) {
        ++house;
        for (int i = 0; i < 4; i++) {
            int nCol = col + dCol[i];
            int nRow = row + dRow[i];

            if (nCol >= 0 && nCol < n && nRow >= 0 && nRow < n && board[nCol][nRow] == '1' && ch[nCol][nRow] == 0) {
                ch[nCol][nRow] = number;
                Dfs(nCol, nRow, number);
            }
        }
    }
}
