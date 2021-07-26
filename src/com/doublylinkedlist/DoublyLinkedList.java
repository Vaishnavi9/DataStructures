package com.doublylinkedlist;

public class DoublyLinkedList {

    public static void main(String[] args) {
        Node head= new Node(10);
        Node node1= new Node(20);
        Node node2= new Node(90);
        head.next=node1;
        node1.next=node2;
        node2.prev=node1;
        node1.prev=head;
        head.prev=null;

        head = insertBegin(head,23);
        printList(head);
        System.out.println();
        head= insertEnd(head,100);
        printList(head);

    }

    public static Node insertBegin(Node head, int data){
        Node temp = new Node(data);
        if(head!=null)
        {
            temp.next=head;
            head.prev=temp;
        }

        return temp;
    }

    public static Node insertEnd(Node head, int data){
        Node temp = new Node(data);
        if(head==null){
            return temp;
        }
        Node current = head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=temp;
        temp.prev=current;
        return head;
    }

    public static void printList(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
}

class Node{
    int data;
    Node prev;
    Node next;
    Node(int d){
        data=d;
    }
}
