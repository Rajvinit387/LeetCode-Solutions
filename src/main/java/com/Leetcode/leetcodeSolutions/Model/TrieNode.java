package com.Leetcode.leetcodeSolutions.Model;

public class TrieNode {
    boolean isEnd;
    TrieNode alphabetsArray[] = new TrieNode[26];

   public   TrieNode ()
    {
        isEnd= false;
        for(TrieNode element: alphabetsArray)
            element=null;
    }
}
