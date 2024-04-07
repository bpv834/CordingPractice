package ProgramersPractice.Hash;

import java.util.*;

public class MenuRenewal {

    class Solution {
        //조합메뉴 카운팅 맵
        HashMap<String, Integer> countMap = new HashMap<>();
        //카운팅맵에 넣기전 조합된 모든 메뉴 넣는 리스트 후에 정답 메뉴만 넣을 리스트로 재사용 됨
        ArrayList<String> combiArr = new ArrayList<>();
        //조합메뉴 렝스 오름차, 메뉴가 사용된 횟수 내림차 정렬위한 배열과 KeyValue 클래스
        ArrayList<KeyValue> arr = new ArrayList<>();

        public String[] solution(String[] orders, int[] course) {
            for(int x: course)
                for(String str: orders){
                    char[] ch= str.toCharArray();
                    //정렬을 해주어서 중복됐지만 순서가 다른 메뉴들이 나오지 않게끔 ex) xy 와 yx를 같게 볼수 있도록 함
                    Arrays.sort(ch);
                    //조합 찾기 시작
                    combiDfs(0,x,ch,"");
                }
            //조합된 메뉴를 통해 count맵에 넣음
            for(String str: combiArr){
                countMap.put(str,countMap.getOrDefault(str,0)+1);
            }
            //정렬을 위해 arr에 넣는 과정
            for(String str:countMap.keySet()){
                System.out.println(str +" " + countMap.get(str));
                //최소 조합메뉴가 2번은 사용돼야 한다는 조건 충족
                if(countMap.get(str)>1)
                    arr.add(new KeyValue(str,countMap.get(str)));
            }

            //(메뉴조합수)length기준 오름차순 length같다면 횟수기준 내림차순 정렬
            Collections.sort(arr, new Comparator<KeyValue>() {
                public int compare(KeyValue a, KeyValue b) {
                    if(a.key.length()==b.key.length()) return b.value-a.value;
                    else return a.key.length() - b.key.length();
                }
            });
            //아까 사용했던 리스트 재사용 위해 비우기
            combiArr.clear();
            //greedy사용 (O)n으로 해결하기 위함
            int strlen=arr.get(0).key.length();
            int val=arr.get(0).value;
            //정렬이 됐기에 가장 위에있는 메뉴는 정답에 들어감
            combiArr.add(arr.get(0).key);
            for(KeyValue kv: arr){
                if(!combiArr.contains(kv.key)){
                    //가장 위에있던 메뉴와 조합수가 같고, 팔린 횟수도 같다면 정답배열에 넣음
                    if(kv.key.length()==strlen && kv.value == val){
                        combiArr.add(kv.key);
                    }
                    //조합수가 다르다면 그것을 정답배열에 넣고 밸류도 다시 갈아줌
                    else if(kv.key.length()!=strlen){
                        combiArr.add(kv.key);
                        strlen=kv.key.length();
                        val=kv.value;
                    }
                }
            }
            //마지막 배열 정렬
            Collections.sort(combiArr);
            String[] answer = new String[combiArr.size()];
            int i=0;
            //리스트를 배열에 옮겨닮음
            for(String str : combiArr){
                answer[i++]=str;
                System.out.println(str);
            }
            return answer;
        }

        void combiDfs(int n, int limitN, char[] ch, String currentStr){
            if(currentStr.length()==limitN){
                System.out.println(currentStr);
                combiArr.add(currentStr);
            }else{
                for(int i=n;i<ch.length;i++){
                    String newStr= currentStr+ch[i];
                    combiDfs(i+1, limitN,ch,newStr);
                }
            }
        }
        class KeyValue {
            String key;
            int value;

            KeyValue(String key, int value) {
                this.key = key;
                this.value = value;
            }
        }

    }

}
