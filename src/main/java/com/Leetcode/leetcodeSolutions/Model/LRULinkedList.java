package com.Leetcode.leetcodeSolutions.Model;

public class LRULinkedList {


    int key;
    int value;
    LRULinkedList prev;
    LRULinkedList next;

    public LRULinkedList(int value, int key) {
        this.value = value;
        this.key = key;
        this.prev = null;
        this.next = null;
    }
}



