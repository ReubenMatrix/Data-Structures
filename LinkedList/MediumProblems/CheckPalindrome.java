package LinkedList.MediumProblems;

import java.util.Stack;
/*
Given the head of a singly linked list, return true if it is a
palindrome or false otherwise.

Input: head = [1,2,2,1]
Output: true
 */

public class CheckPalindrome {
    public static void main(String[] args) {
        Node head1 = new Node(2, new Node(4, new Node(3)));
        System.out.println(BruteSolution(head1));
        System.out.println(OptimalSolution(head1));

    }

    public static Boolean BruteSolution(Node head){
        Stack<Integer> st=new Stack<>();
        Node temp=head;

        while (temp!=null){
            st.push(temp.data);
            temp=temp.next;
        }

        temp=head;
        while (temp!=null){
            if(temp.data!=st.peek()){
                return false;
            }
            temp=temp.next;
            st.pop();
        }
        return true;
    }
    //Time Complexity:O(2N)
    //Space Complexity:O(N)

    static Node reverse(Node curr){
        Node prev=null;
        Node next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public static Boolean OptimalSolution(Node head){
        if(head==null || head.next==null){
            return true;
        }

        Node slow=head;
        Node fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=reverse(slow.next);
        slow=slow.next;
        Node dummyNode=head;

        while(slow!=null){
            if(dummyNode.data!= slow.data){
                return false;
            }
            dummyNode=dummyNode.next;
            slow=slow.next;
        }
        return true;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(1)
}
