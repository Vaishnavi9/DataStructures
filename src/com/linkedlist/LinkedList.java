package com.linkedlist;

public class LinkedList {

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        print(head);
    }

    public static void print(Node head) {
        Node current = head;
        while(current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
    }
}

class Node{
    int data;
    Node next;

    Node(int x){
        data=x;
        next=null;
    }
}
