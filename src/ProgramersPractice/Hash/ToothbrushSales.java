package ProgramersPractice.Hash;

import java.util.HashMap;

public class ToothbrushSales {
    class Solution {
        HashMap<String, Integer> countMap = new HashMap<>();
        HashMap<String, String> relationMap=new HashMap<>();
        void Dfs(String manager, int payment){
            System.out.println("manager : "+manager+" payment: "+payment);
            if(payment <0 ) {
                System.out.println("!!");
                return;}
            if(manager.equals("-")){
                System.out.println("center");
                return;
            }else{
                System.out.println("@@");
                String desc=manager;
                String asc=relationMap.get(manager);
                System.out.println("desc= "+desc+" asc= "+asc);
                int pPayment =payment- (payment/10);
                int income= payment - pPayment;
                System.out.println("pPayment "+ pPayment+" income= "+income);
                countMap.put(desc, countMap.getOrDefault(desc,0)+pPayment);
                System.out.println(asc+"넣기전의 수입= "+countMap.get(asc));
                System.out.println(desc+"의 수입= "+countMap.get(manager));
                System.out.println(asc+"의 수입= "+countMap.get(asc));
                Dfs(relationMap.get(manager),income);
            }
        }

        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

            int[] answer = new int[enroll.length];

            for(int i=0;i<enroll.length;i++){
                relationMap.put(enroll[i],referral[i]);
            }
            int i=0;
            for(String str: seller){
                System.out.println("1. seller: "+str);
                int income = amount[i]*100;
                System.out.println("2. amount = "+amount[i] +" income: "+income);
                i++;
                int payment = income/10;
                System.out.println("3. payment: "+payment);
                int myIncome = income - payment;
                System.out.println("4. myIncome: "+myIncome);
                countMap.put(str, countMap.getOrDefault(str,0)+myIncome);
                System.out.println(str +"의 수입= "+countMap.get(str));
                Dfs(relationMap.get(str),payment);
            }
            int j=0;
            for(String str: enroll){
                System.out.println(countMap.getOrDefault(str,0));
                answer[j++]=countMap.getOrDefault(str,0);
            }
            return answer;
        }
    }
}
