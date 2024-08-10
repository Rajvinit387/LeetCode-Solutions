package com.Leetcode.leetcodeSolutions.Model;

import com.fasterxml.jackson.databind.util.LRUMap;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, LRULinkedList> LRUHashMap = new HashMap<>();
    int capacity;
    static LRULinkedList LRUhead;
    static LRULinkedList LRUtail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        LRULinkedList l1 = new LRULinkedList(-1, Integer.MIN_VALUE);
        LRULinkedList l2 = new LRULinkedList(-1, Integer.MIN_VALUE);
        LRUhead = l1;
        LRUtail = l2;
        LRUhead.next = LRUtail;
        LRUtail.prev = LRUhead;
    }

    public int get(int key) {

        if (LRUHashMap.containsKey(key)) {

            LRULinkedList lruLinkedList = LRUHashMap.get(key);
            lruLinkedList.next.prev = lruLinkedList.prev;
            lruLinkedList.prev.next = lruLinkedList.next;
            lruLinkedList.next = LRUhead.next;
            lruLinkedList.prev = LRUhead;
            LRUhead.next = lruLinkedList;
            lruLinkedList.next.prev = lruLinkedList;
            return LRUHashMap.get(key).value;

        }
        return -1;

    }

    public void put(int key, int value) {
        if (LRUHashMap.containsKey(key)) {
            LRUHashMap.get(key).value = value;
            //need to check
            LRULinkedList linkedlistupdated = LRUHashMap.get(key);

            linkedlistupdated.next.prev = linkedlistupdated.prev;
            linkedlistupdated.prev.next = linkedlistupdated.next;
            linkedlistupdated.next = LRUhead.next;
            linkedlistupdated.prev = LRUhead;
            LRUhead.next = linkedlistupdated;
            linkedlistupdated.next.prev = linkedlistupdated;


        } else {

            LRULinkedList lruLinkedList = new LRULinkedList(value, key);
            if ((LRUHashMap.size() < capacity)) {
                LRUHashMap.put(key, lruLinkedList);
                addvalue(lruLinkedList);

            } else {
                LRUHashMap.put(key, lruLinkedList);
                addvalue(lruLinkedList);
                int deletedKeyValue = delete2ndLastNode(LRUtail);
                LRUHashMap.remove(deletedKeyValue);

            }
        }

    }

    public static void addvalue(LRULinkedList lruLinkedList) {
        lruLinkedList.prev = LRUhead;
        lruLinkedList.next = LRUhead.next;
        lruLinkedList.next.prev = lruLinkedList;
        LRUhead.next = lruLinkedList;
        //  System.out.println(LRUhead);

    }


    public static int delete2ndLastNode(LRULinkedList LRUtail) {
        int deletedValue = LRUtail.prev.key;
        LRUtail.prev.prev.next = LRUtail;
        LRUtail.prev = LRUtail.prev.prev;
        // System.out.println(LRUhead.next.value);
        return deletedValue;

    }


}


