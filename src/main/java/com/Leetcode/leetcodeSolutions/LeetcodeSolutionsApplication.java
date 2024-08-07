package com.Leetcode.leetcodeSolutions;

import com.Leetcode.leetcodeSolutions.Implementation.Solutions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeetcodeSolutionsApplication {

	public static void main(String[] args) {

		SpringApplication.run(LeetcodeSolutionsApplication.class, args);
		System.out.println("lEETCODE START.....");
		System.out.println(Solutions.countBeautifulArrangementOpt(2));
	}

}
