    import java.util.*;

    public class Main {

        static boolean ch[];

        static void Dfs(int vtx, ArrayList<ArrayList<Integer>> graph, int n, int L, int dfs[], boolean ch[]) {
            if (L == n) return;
            if (!ch[vtx]) {
                ch[vtx] = true;
                dfs[L++] = vtx;
            }
            for (int x : graph.get(vtx)
            ) {

                //vtx를 x로 선정하는데 온길은 선택하지 않겠다
                if (!ch[x]) {
                    Dfs(x, graph, n, L, dfs, ch);
                }
            }
        }

        static void Bfs(int L, int vtx, ArrayList<ArrayList<Integer>> graph, Queue<Integer> Q, int bfs[], boolean ch[]) {
            Q.add(vtx);
            while (!Q.isEmpty()) {
                int temp = Q.poll();
                bfs[L++] = temp;
                ch[temp] = true;
                for (int x : graph.get(temp)
                ) {
                    if (!ch[x]) {
                        Q.add(x);
                        ch[x] = true;
                    }
                }
            }

        }

        public static void main(String[] args) {
            String answer = "";
            Queue<Integer> Q = new LinkedList<>();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int v = sc.nextInt();
            int search[] = new int[n];
            ch = new boolean[n + 1];

            for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            for (int i = 0; i <= n; i++) {
                Collections.sort(graph.get(i));
            }

            Dfs(v, graph, n, 0, search, ch);
            for (int vtx : search
            ) {
                if (vtx != 0) {
                    answer = answer + vtx + " ";
                }
            }
            answer = answer.trim();
            System.out.println(answer);
            Arrays.fill(ch, false);
            answer = "";
            Bfs(0, v, graph, Q, search, ch);
            for (int vtx : search
            ) {
                if (vtx != 0) {
                    answer = answer + vtx + " ";
                }
            }
            answer = answer.trim();
            System.out.println(answer);
        }
    }
