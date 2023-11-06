package InflearnForBeginner.GreedyAlgorithm;

import java.util.*;

public class SsireumSelection {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Body> athlete = new ArrayList<>();
    static int n = sc.nextInt();
    static int answer;
    static int maxWeight=Integer.MIN_VALUE;
    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            athlete.add(new Body(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(athlete);
        for (Body b : athlete) {
            if (b.weight > maxWeight) {
                answer++;
                maxWeight=b.weight;
            }
        }
        System.out.println(answer);
    }
    public static class Body implements Comparable<Body> {
        public int height;
        public int weight;

        public Body(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Body o) {
            return o.height - this.height;
        }
    }

}

