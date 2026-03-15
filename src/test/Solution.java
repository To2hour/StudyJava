package test;

import java.util.PriorityQueue;

class Solution {
    public record pair(int sum, int index) {
    }

    public int minimumPairRemoval(int[] nums) {
        PriorityQueue<pair> pairs = new PriorityQueue<>((a, b) -> {
            return Long.compare(a.sum, b.sum);
        });
        return 1;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 180;
        String a1 = "10";
        System.out.println(a1.equals(String.valueOf(a)));
    }
}