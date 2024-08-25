package com.Leetcode.leetcodeSolutions.Model;

import java.util.*;

public class AllOne {
    static allOdSwithdoublyLinkedList root = new allOdSwithdoublyLinkedList(0,new HashSet<>());
    static Map<String , allOdSwithdoublyLinkedList> map=new HashMap<>();
    static int flag=0;

    public AllOne() {
         root.count=0;
         root.next= root;
         root.prev=root;

    }

    public void inc(String key) {


        if (!map.containsKey(key)) {

            if (flag == 0) {

                Set<String> sets = new HashSet<>();
                sets.add(key);
                allOdSwithdoublyLinkedList x = new allOdSwithdoublyLinkedList(1, sets);
                root.next = x;
                root.prev = x;
                x.next = root;
                x.prev = root;
                map.put(key, x);
                flag = 1;
            } else  if(root.next.count==1){

                root.next.keys.add(key);
                map.put(key, root.next);
            }
            else {
                Set<String> sets = new HashSet<>();
                sets.add(key);
                allOdSwithdoublyLinkedList x = new allOdSwithdoublyLinkedList(1, sets);
                x.next= root.next;
                root.next.prev=x;
                root.next=x;
                x.prev=root;
                 map.put(key,x);
            }
        } else if (map.containsKey(key)) {
            if (map.get(key).next.count== map.get(key).count+1) {
                allOdSwithdoublyLinkedList t = map.get(key);
                t.keys.remove(key);

                t.next.keys.add(key);
                if(t.keys.isEmpty())
                {
                    t.prev.next= t.next;
                    t.next.prev= t.prev;
                }
                map.remove(key);
                map.put(key, t.next);
            } else {
                Set<String> sets = new HashSet<>();
                sets.add(key);
                allOdSwithdoublyLinkedList t = new allOdSwithdoublyLinkedList(map.get(key).count + 1, sets);
                allOdSwithdoublyLinkedList x= map.get(key);
                x.keys.remove(key);


                    t.next = x.next;
                    x.next.prev = t;

                if(x.keys.isEmpty())
                {
                    x.prev.next= t;
                   t.prev= x.prev;
                    x.next=null;
                    x.prev=null;
                }
                else {
                    x.next = t;
                    t.prev = x;
                }
                map.put(key,t);

            }
        }

   System.out.println("ghdbhhbdhbdhbdsh");

    }

    public void dec(String key) {
     allOdSwithdoublyLinkedList t = map.get(key);
     if(map.get(key).count==1)
     {
         map.get(key).keys.remove(key);
         map.remove(key);
         if(t.keys.isEmpty())
         {
             t.prev.next= t.next;
             t.next.prev= t.prev;
             t.next=null;
             t.prev=null;
         }
     }
     else if(map.get(key).prev.count+1==t.count)
     {
         t.keys.remove(key);
         map.remove(key);

         t.prev.keys.add(key);
         map.put(key,t.prev);
         if(t.keys.isEmpty())
         {
             t.prev.next= t.next;
             t.next.prev= t.prev;
             t.next=null;
             t.prev=null;
         }
     }

     else {
         Set<String > sets= new HashSet<>();
         sets.add(key);
         allOdSwithdoublyLinkedList x = new allOdSwithdoublyLinkedList(t.count-1,sets);
         t.keys.remove(key);
         map.remove(key);

             t.prev.next= x;
            x.prev= t.prev;
            if(t.keys.isEmpty())
            {
                x.next= t.next;
                t.next.prev=x;
                t.next=null;
                t.prev=null;
            }
            else {
                x.next=t;
                t.prev=x;
            }
            map.put(key,x);


     }

    }

    public String getMaxKey() {
        if(root.prev==root)
            return "";
   return root.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if(root.next==root)
            return "";
        return root.next.keys.iterator().next();

    }


    public  void printAllOne() {
        if (root != null) {
            allOdSwithdoublyLinkedList currentnode = root.next;
            System.out.println("keys"+root.keys);
            System.out.println("Count"+root.count);
            System.out.println("Next Node: keys"+String.valueOf(root.next.keys)+"count"+root.next.count);
            System.out.println( String.valueOf("Prev Node: keys"+root.prev.keys)+"count"+root.prev.count);
            System.out.println("____________");
            while (currentnode != root) {
              System.out.println("keys"+currentnode.keys);
              System.out.println("Count"+currentnode.count);
                System.out.println("Next Node: keys"+String.valueOf(currentnode.next.keys)+"count"+currentnode.next.count);
                System.out.println( String.valueOf("Prev Node: keys"+currentnode.prev.keys)+"count"+currentnode.prev.count);
                System.out.println("____________");
                currentnode = currentnode.next;
            }

            System.out.println("--------");
        } else System.out.println("Linked list is empty");
    }
}
