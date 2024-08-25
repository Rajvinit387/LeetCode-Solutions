package com.Leetcode.leetcodeSolutions.Model;

import java.util.Set;

public class allOdSwithdoublyLinkedList {
    int count;
    Set<String> keys;
    allOdSwithdoublyLinkedList prev;
    allOdSwithdoublyLinkedList next;


    public  allOdSwithdoublyLinkedList(int count,Set keys )
    {
        this.count= count;
        this.keys= keys;
        this.prev= null;
        this.next= null;
    }

}
