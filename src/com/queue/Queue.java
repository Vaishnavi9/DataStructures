package com.queue;

public class Queue {
    private static int front, rear, capacity;
    private static int queue[];

    Queue( int c )
    {
        front = rear = 0;
        capacity = c;
        queue = new int [capacity];
    }

    void enqueue( int data )
    {
        if (capacity == rear ){
            System.out.println(" Queue is full ");
            return;
        }
        else {
            queue [rear] = data;
            rear++;
        }
    }

    int dequeue ()

    {
        int data = 0;
        if (front == rear){
            System.out.println(" Queue is empty ");
        }
        else {
            data = queue [0];
            //shift elements
            for ( int i=0; i< rear - 1; i++){
                queue[rear] = queue[ i + 1 ];
            }
            if (rear < capacity) {
                queue[rear] = 0;
            }
            rear--;
        }
        return data;
    }
}
