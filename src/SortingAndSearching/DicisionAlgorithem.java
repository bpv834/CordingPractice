package SortingAndSearching;

    import java.util.Scanner;

    public class DicisionAlgorithem {
        static Scanner sc = new Scanner(System.in);
        static boolean check=true;

        private static int capacity(int arr[],int hpt){
            int cp=1;
            int sum=0;
            int value=0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                if (sum > hpt) {
                    ++cp;
                    sum-=value;
                }
                value = sum;
            }
            return cp;
        }

        public static void main(String[] args) {
            int answer=0;
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int lt = arr[arr.length - 1];
            int rt=0;
            for (int x:arr
                 ) {
                rt+=x;
            }
            int hpt=0;
            while (true) {
                hpt=(rt+lt)/2;
                if (capacity(arr, hpt) <= k) {
                    rt=hpt;
                }
                else {
                    break;
                }
            }
            while (true) {
                if (capacity(arr, rt) <= k) {
                    --rt;
                }
                else {
                    break;
                }
            }
            System.out.println(++rt);
        }
    }
