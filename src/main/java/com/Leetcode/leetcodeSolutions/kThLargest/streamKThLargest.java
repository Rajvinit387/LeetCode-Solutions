package com.Leetcode.leetcodeSolutions.kThLargest;

import java.util.PriorityQueue;

public class streamKThLargest {
    static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    static int t = 0;


    public streamKThLargest(int k, int[] nums) {

        t = k;
        priorityQueue.clear();
        for (int i = 0; i < nums.length; i++) {

            priorityQueue.add(nums[i]);
            if (priorityQueue.size() > k)
                priorityQueue.poll();
        }


    }

    public static int add(int val) {
        priorityQueue.add(val);
        if (priorityQueue.size() > t)
            priorityQueue.poll();
        return priorityQueue.peek();


    }
}
