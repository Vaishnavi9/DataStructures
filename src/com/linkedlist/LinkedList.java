package com.linkedlist;

public class LinkedList {

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
       // print(head);
       // head=insertBegin(89,head);
        //printRecursive(head);
        insertEnd(45,head);
        printRecursive(head);
    }

    public static void print(Node head) {
        Node current = head;
        while(current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
    }


    public static void printRecursive(Node head){
        //Node current = head;
        if(head==null){
           return;
        }
        System.out.println(head.data);
        head=head.next;
        printRecursive(head);
    }

    public static Node insertBegin(int x, Node head){
        Node temp = new Node(x);
        temp.next=head;
        return temp;
    }

    public static Node insertEnd(int x, Node head){
        Node temp=new Node(x);
        if(head==null){
            return temp;
        }
        while(head.next!=null){
            //System.out.println(head.data);
            head=head.next;
        }
        head.next=temp;
        return temp;
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
