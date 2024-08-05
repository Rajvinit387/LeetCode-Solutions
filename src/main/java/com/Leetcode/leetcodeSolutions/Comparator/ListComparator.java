package com.Leetcode.leetcodeSolutions.Comparator;

import java.util.Comparator;
import java.util.List;






    public class ListComparator implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {

            return o1.get(0) -o2.get(0);
        }
    }


