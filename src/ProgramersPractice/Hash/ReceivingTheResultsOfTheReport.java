package ProgramersPractice.Hash;

import java.util.HashMap;
import java.util.HashSet;

public class ReceivingTheResultsOfTheReport {

}
class Solution1 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //(신고 당한 사람, 신고한 사람<중복x>)
        HashMap<String, HashSet<String>> reported = new HashMap<>();
        //(신고한 사람, 받을 메일 횟수)
        HashMap<String, Integer> count = new HashMap<>();

        for (String s : report) {
            HashSet<String> hs = new HashSet<>();
            String str[] = s.split(" ");
            String reportUser = str[0];
            String reportedUser = str[1];

            if (!reported.containsKey(reportedUser)) {
                reported.put(reportedUser, new HashSet<>());
            }
            reported.get(reportedUser).add(reportUser);

        }

        for (String s : reported.keySet()) {
            System.out.println(s + " " + reported.get(s));
        }

        return answer;
    }
}

class Solution2 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int returnArr[] = new int[id_list.length];
        HashMap<String, HashSet<String>> reportedMap = new HashMap<>();
        HashMap<String, Integer> answerMap = new HashMap<>();

        // 신고 내역 처리
        for(String s : report){
            String[] tokens = s.split(" ");
            String reporter = tokens[0];
            String reportedUser = tokens[1];

            // reportedMap에 해당 유저가 없는 경우 추가
            reportedMap.putIfAbsent(reportedUser, new HashSet<>());
            reportedMap.get(reportedUser).add(reporter);
        }

        // 신고당한 횟수가 k 이상인 경우 처리
        for(String s : id_list){
            // 해당 유저가 신고를 당한 경우에만 처리
            if(reportedMap.containsKey(s)){
                if(reportedMap.get(s).size() >= k){
                    for(String reporter : reportedMap.get(s)){
                        answerMap.put(reporter, answerMap.getOrDefault(reporter, 0) + 1);
                    }
                }
            }
        }

        // 결과 배열에 값 넣기
        int index = 0;
        for(String id : id_list){
            if(answerMap.containsKey(id)){
                returnArr[index++] = answerMap.get(id);
            } else {
                returnArr[index++] = 0;
            }
        }

        // 결과 반환
        return returnArr;
    }
}
