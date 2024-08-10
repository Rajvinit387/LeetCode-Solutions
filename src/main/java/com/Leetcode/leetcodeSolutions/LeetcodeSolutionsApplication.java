package com.Leetcode.leetcodeSolutions;

import com.Leetcode.leetcodeSolutions.Implementation.Solutions;
import com.Leetcode.leetcodeSolutions.Model.BSTIterator;
import com.Leetcode.leetcodeSolutions.Model.Node;
import com.Leetcode.leetcodeSolutions.Model.TreeNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeetcodeSolutionsApplication {

    public static void main(String[] args) {

        SpringApplication.run(LeetcodeSolutionsApplication.class, args);
        System.out.println("lEETCODE START.....");
        //System.out.println(Solutions.mySqrt(2147395599));
        System.out.println(Solutions.numberToWords(1000000));



    }

}
