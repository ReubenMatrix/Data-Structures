package LinkedList.MediumProblems;

import java.util.ArrayList;

/*
Given the head of a singly linked list, group all the nodes with odd indices together
followed by the nodes with even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.

Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
 */

public class OddAndEvenLL {
    public static void main(String[] args) {
        Node head1 = new Node(2, new Node(4, new Node(3,new Node(8,new Node(9,new Node(3))))));
        printList(head1);
        printList(BruteOddEven(head1));
        System.out.println();

        Node head2 = new Node(2, new Node(4, new Node(3,new Node(8,new Node(9,new Node(3))))));
        printList(head2);
        printList(OptimalOddEven(head2));
        System.out.println();


    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node BruteOddEven(Node head){
        ArrayList<Integer> arr=new ArrayList<>();

        if(head==null || head.next==null){
            return head;
        };

        Node temp=head;
        while(temp!=null && temp.next!=null){
            arr.add(temp.data);
            temp=temp.next.next;
        };

        if(temp!=null){
            arr.add(temp.data);
        };

        temp=head.next;
        while(temp!=null && temp.next!=null){
            arr.add(temp.data);
            temp=temp.next.next;
        };
        if(temp!=null){
            arr.add(temp.data);
        };

        int i=0;
        temp=head;
        while (temp!=null){
            temp.data=arr.get(i);
            i++;
            temp=temp.next;
        }
        return head;
    }
    //Time Complexity:O(2N)
    //Space Complexity:O(N)

    public static Node OptimalOddEven(Node head){
        Node odd=head;
        Node even=head.next;
        Node evenHead=even;

        if (head == null || head.next == null) {
            return head;
        }

        while(even!=null && even.next!=null){
            odd.next=odd.next.next;
            odd=odd.next;

            even.next=even.next.next;
            even=even.next;
        }

        odd.next=evenHead;
        return head;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(1)
}
