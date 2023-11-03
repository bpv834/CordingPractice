package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Emergency {
   static public class Person{
        Person(int id, int priority) {
            this.id=id;
            this.priority=priority;
        }
       int id;
       int priority;
   }
    static Scanner sc = new Scanner(System.in);
    private static int e(int n, int m) {
        int answer=0;
        Queue<Person> Q=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Q.offer(new Person(i, sc.nextInt()));
        }

        while (!Q.isEmpty()) {
            Person tmp=Q.poll();
            for (Person p:Q
                 ) {
                if (tmp.priority < p.priority) {
                    Q.offer(tmp);
                    tmp = null;
                    break;
                }

            }
            if (tmp != null) {
                //빼고 뒤로 안넣었다
                answer++;
                if (tmp.id == m) {
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(e(sc.nextInt(),sc.nextInt()));
    }
}

