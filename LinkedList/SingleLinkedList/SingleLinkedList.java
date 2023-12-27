package LinkedList.SingleLinkedList;

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

public class SingleLinkedList{
    private static Node Convert(int[] arr){
      Node head=new Node(arr[0]);
      Node move=head;
        for (int i = 0; i < arr.length; i++) {
             Node temp=new Node(arr[i]);
             move.next=temp;
             move=temp;
        }
        return head;
    }
    //Time Complexity: O(N)

    private static int LengthOfList(Node head){
        int count=0;
        Node temp=head;
        while (temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }
    //Time Complexity:O(N)

    private static boolean SearchAnElement(Node head,int DesiredElement){
        Node temp=head;
        while(temp!=null){
            if(temp.data==DesiredElement){
                return true;
            }else {
                temp=temp.next;
            }
        }
        return false;
    }
    //Time Complexity:O(N)

    private static Node DeleteNode(Node head){
        if(head==null || head.next==null){
            return null;
        }

        Node temp=head;

        if(temp.next.next!=null){
            temp=temp.next;
        }

        temp.next=null;
        return head;
    }
    //Time Complexity:O(N)


    public static void main(String[] args) {
        int[] arr={12, 6, 7, 14};
        Node head=Convert(arr);
        System.out.println(head.data);

        //Traversing Array
        Node temp=head.next;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        //Time Complexity:O(N)

        System.out.println(LengthOfList(head));

        System.out.println(SearchAnElement(head,7));

        Node tail=DeleteNode(head);
        Node temp2=tail.next;
        while(temp2!=null){
            System.out.print(temp2.data+" ");
            temp2=temp2.next;
        }
    }
}
