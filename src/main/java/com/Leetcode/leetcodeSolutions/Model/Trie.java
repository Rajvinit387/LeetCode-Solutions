package com.Leetcode.leetcodeSolutions.Model;

public class Trie {

    static TrieNode root;
    public Trie() {

           root=new TrieNode();
    }


        public void insert(String word) {
        int index;
        TrieNode temp= root;


            for(int i =0;i < word.length(); i++ )
            {
                index= word.charAt(i)-'a';
                if(temp.alphabetsArray[index]==null)
                {
                    temp.alphabetsArray[index]= new TrieNode();
                    temp= temp.alphabetsArray[index];
                }
                else
                {
                    temp= temp.alphabetsArray[index];
                }
            }

            temp.isEnd=true;
            System.out.println(root);


        }

        public boolean search(String word) {
        TrieNode temp = root;
        int index=0;
        for(int i =0; i< word.length(); i++)
        {
            index=word.charAt(i)-'a';
            if(temp.alphabetsArray[index]!=null)
            {
                temp= temp.alphabetsArray[index];
            }
            else
                return false;
        }
        if(temp.isEnd==true)
            return true;
        else
            return false;

        }

        public boolean startsWith(String prefix) {
            TrieNode temp = root;
            int index=0;
            for(int i =0; i< prefix.length(); i++)
            {
                index=prefix.charAt(i)-'a';
                if(temp.alphabetsArray[index]!=null)
                {
                    temp= temp.alphabetsArray[index];
                }
                else
                    return false;
            }
            if(temp!=null)
                return true;
            else
                return false;


        }
    }



