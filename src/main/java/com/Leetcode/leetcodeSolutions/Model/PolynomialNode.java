package com.Leetcode.leetcodeSolutions.Model;

public class PolynomialNode {
   public int coeff;
   public int exp;
    public PolynomialNode next;
    public PolynomialNode(int coeff, int exp)
    {
        this.coeff= coeff;
        this.exp= exp;
        this.next=null;
    }
}
