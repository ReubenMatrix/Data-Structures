package LinkedList.MediumProblems;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
 */
class Node{
    int data;
    Node next;
    Node(int data1, Node next1){
        this.data=data1;
        this.next=next1;
    }
    Node(int data1){
        this.data=data1;
        this.next=null;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        Node head1 = new Node(2, new Node(4, new Node(3)));
        Node head2 = new Node(5, new Node(6, new Node(4)));

        System.out.print("  ");
        printList(head1);
        System.out.print("+ ");
        printList(head2);
        System.out.print("= ");
        printList(AddNodes(head1, head2));
        System.out.println();

    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node AddNodes(Node head1,Node head2){
        Node t1=head1;
        Node t2=head2;
        Node dummyNode=new Node(-1);
        Node curr=dummyNode;
        int carry=0;

        while(t1!=null || t2!=null){
            int sum=carry;
            if(t1!=null){
                sum= sum+ t1.data;
                t1=t1.next;
            }
            if(t2!=null){
                sum= sum+ t2.data;
                t2=t2.next;
            }
            Node newNode=new Node(sum%10);
            carry=sum/10;
            curr.next=newNode;
            curr=curr.next;
        }
        if(carry!=0){
            Node carryNode=new Node(carry);
            curr.next=carryNode;
        }
        return dummyNode.next;
    }
    //Time Complexity:O(max(N, M))    N->Length of head1     M->Length of head2

}
