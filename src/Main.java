import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();
        int factory[] = new int[n + 2];
        for (int i = 0; i < n; i++) {
            factory[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (factory[i + 1] > factory[i + 2]) {
                int tmp = Math.min(factory[i + 1] - factory[i + 2], factory[i]);
                answer += 5 * tmp;
                factory[i] -= tmp;
                factory[i + 1] -= tmp;
            }

            int tmp = Math.min(factory[i], Math.min(factory[i + 1], factory[i + 2]));
            answer += tmp * 7;
            factory[i] -= tmp;
            factory[i + 1] -= tmp;
            factory[i + 2] -= tmp;


            answer += 3 * factory[i];
            factory[i] = 0;
        }
        System.out.println(answer);
    }
}