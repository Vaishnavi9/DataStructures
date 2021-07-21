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
        //insertEnd(45,head);
        //printRecursive(head);
        //head = deleteHead(head);
        //deleteTail(head);
       // head=insertAtPosition(head,3,34);
        //printRecursive(head);
        //int x=searchLinkedList(head,30);
        //System.out.println(x);
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

    public static Node deleteHead(Node head){
        if(head==null){
            return null;
        }
        else
            return head.next;
    }

    public static Node deleteTail(Node head){
        if(head==null){return null;}
        if(head.next==null){return null;}
        Node curr = head;
        while(curr.next.next!=null){
            curr = curr.next;
        }

        curr.next=null;
        return curr;
    }

    public static Node insertAtPosition(Node head, int position, int data){
        Node temp = new Node(data);
        if(position==1){
            temp.next=head;
            return temp;
        }
        Node current = head;
        for(int i=1;i<=position-2 && current!=null;i++){
            current=current.next;
        }
        if(current==null){return null;}
        temp.next=current.next;
        current.next=temp;
        return head;
    }


    public static int searchLinkedList(Node head, int x){
        int pos=1;
        while(head!=null){
            if(head.data==x) {
                return pos;
            }
            head=head.next;
            pos+=1;
        }
        return -1;
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
