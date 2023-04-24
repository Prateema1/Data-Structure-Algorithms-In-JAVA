package com.pratima;

import java.awt.desktop.SystemEventListener;

public class DLL {
    private Node head;
    public void insertFirst(int val) {
        Node node = new Node(val);   //CREATES A NEW NODE WITH THE PASSED VALUE
       node.next = head;
       node.prev = null;
       if(head != null) {
           head.prev = node;
       }

       head = node;

    }

    public void display() {
        Node temp = head;
        Node last = null;  //As we are not taking tail, we have to make our own tail/last node
        while(temp != null) {
            System.out.print(temp.val + " -> ");
            last = temp;
            temp = temp.next;
        }
        System.out.println("END");

        System.out.println("PRINT IN REVERSE");

        while(last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }

        System.out.println("START");
    }

     public void insertLast(int val) {
        Node node = new Node(val);
        Node last = head;

        //What if head is null or an empty linked list? Check edge cases:
         if(head == null) {
             node.prev = null;
             head = node;
             return;
         }

        while(last.next != null) {
            last = last.next;
        }

        last.next = node;
        node.prev = last;

     }
    public Node find(int value) {
        Node node = head;
        while(node != null) {
            if(node.val == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
     public void insert(int after, int val) {
        Node p = find(after);

        if(p == null) {
            System.out.println("Doesn't exist");
            return;
        }

        Node node = new Node(val);

        //Creating the link
        node.next = p.next;
        p.next = node;
        node.prev = p;

        //check for edge cases, null pointer (if node is last)
        if(node.next != null) {
            node.next.prev = node;
        }
     }
    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
