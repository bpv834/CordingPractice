package HashMapAndTreeSet;

    import java.util.HashMap;
    import java.util.Scanner;

    public class FindingAllOfAnagrams {
        static Scanner sc = new Scanner(System.in);

        private static void faoa(String str1, String str2) {
            HashMap<Character, Integer> am = new HashMap<>();
            HashMap<Character, Integer> bm = new HashMap<>();
            int cnt=0;
            for (char c:str2.toCharArray()
                 ) {
                bm.put(c, bm.getOrDefault(c, 0) + 1);
            }

            int L=str2.length()-1;
            for (int i = 0; i < L;i++ ) {
                am.put(str1.charAt(i), am.getOrDefault(str1.charAt(i), 0)+1);
            }

            int lt=0;
            for (int i = L; i < str1.length(); i++) {
                am.put(str1.charAt(i), am.getOrDefault(str1.charAt(i), 0)+1);

                if (am.equals(bm)) {
                    cnt++;
                }

                am.put(str1.charAt(lt), am.get(str1.charAt(lt))-1);

                if (am.get(str1.charAt(lt)) == 0) {
                    am.remove(str1.charAt(lt));
                }
                lt++;
            }
            System.out.println(cnt);

        }

        public static void main(String[] args) {
            String str1 = sc.next();
            String str2 = sc.next();
            faoa(str1,str2);
        }
    }