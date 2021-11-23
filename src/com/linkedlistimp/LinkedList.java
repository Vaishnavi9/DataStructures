package com.linkedlistimp;

public class LinkedList {

    static Node head;
    static int len = 0;

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer

        if (position <= len + 1 && position > 0){
            Node newNode = new Node();
            newNode.data = value;
            newNode.next = null;
            if (position == 1) {
                newNode.next = head;
                head = newNode;
                len++;
                return;

            }
            Node temp = head;
            int i = 1;
            while ( i < position - 1 && temp.next != null) {
                temp = temp.next;
                i++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            len++;
        }

    }
    public static void delete_node(int position) {
        Node newNode = null;
        if (position == 1) {
            newNode = head;
            head = head.next;
            len--;
            return;
        }
        int i = 1;
        Node temp = head;
        if (position <= len + 1 && position > 0){
            while ( i < position - 1 && temp.next != null) {
                temp = temp.next;
                i++;
            }
            newNode = temp.next;
            if (temp.next != null){
                temp.next = temp.next.next;
            }

            len--;
        }

    }

    public static void print_ll() {
        // Output each element followed by a space
        Node temp;
        temp = head;
        while( temp.next != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        if (temp != null){
            System.out.print(temp.data);
        }
    }

    static class Node{
        int data;
        Node next;

    }

}
