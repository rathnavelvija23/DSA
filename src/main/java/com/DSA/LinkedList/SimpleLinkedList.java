package com.DSA.LinkedList;

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data=data;
    }
}

class LinkedList{

    Node head;
    public void printList(){
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current=current.next;
            if(current==head){
                break;
            }

        }
        System.out.println();
    }


    public Node middleList(){
        if (head == null)  return null;
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }
        return slow;

    }

    public boolean circularList(){
        if (head == null)  return true;
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;

    }



}

public class SimpleLinkedList {

    public static Node mergeSortedLists(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                System.out.println(l1.data);
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                System.out.println(l2.data);
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append the remaining elements (if any)
        if (l1 != null) {
            current.next = l1;
            while(current.next!=null) {
                System.out.println(current.next.data);
                current.next = current.next.next;
            }
        } else if (l2 != null) {
            current.next = l2;
            while(current.next!=null) {
                System.out.println(current.next.data);
            current.next = current.next.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("1->2->3->4->1->null");
        LinkedList list = new LinkedList();
        list.head= new Node(1);
        list.head.next= new Node(2);
        list.head.next.next= new Node(3);
        list.head.next.next.next= new Node(5);

        LinkedList list1 = new LinkedList();
        list1.head= new Node(4);
        list1.head.next= new Node(6);
        list1.head.next.next= new Node(7);
        list1.head.next.next.next= new Node(9);

        //add as list
       // list.head.next.next.next.next = list.head;

        list.printList();
        System.out.println(list.middleList().data);
        System.out.println("Circular:"+list.circularList());
        mergeSortedLists(list.head,list1.head);

    }
}
