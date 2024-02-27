package com.Test3;

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data= data;

    }
}

class LinkedList1{
    Node head;


    public void addFirst(Node current){
        while(current!=null){
            head.data= current.data;
            current = current.next;
        }
    }
    void printList(){
        Node current = head;
        while(current != null){
            if(current.data %2 ==0){
                    addFirst(current);
            }
            current = current.next;
        }
//        while(current != null){
//            if(current.data %2 !=0){
//                addFirst(current);
//            }
//            current = current.next;
//        }

    }


}
public class Test2 {
    public static void main(String[] args) {
        LinkedList1 linkedList1 = new LinkedList1();
        linkedList1.head = new Node(2);
        linkedList1.head.next = new Node(1);
        linkedList1.head.next.next = new Node(3);
        linkedList1.head.next.next.next = new Node(4);
        linkedList1.printList();
    }

}
