/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        // code here
        Node dummy1 = new Node (-1);
        Node dummy2 = new Node (-1);
        Node dummy3 = new Node (-1);
        
        
        Node zero = dummy1;
        Node one = dummy2;
        Node two = dummy3;
        
        Node node = head;
        
        while(node!=null){
            if(node.data==0){
                zero.next=node;
                zero=zero.next;
            }else if(node.data==1){
                one.next=node;
                one=one.next;
            }else{
                two.next=node;
                two=two.next;
            }
            node=node.next;
        }
        
        two.next=null;
        
        if(dummy2.next==null){
            zero.next=dummy3.next;
        }else if(dummy1.next==null){
            one.next=dummy3.next;
        }else{
            zero.next=dummy2.next;
            one.next=dummy3.next;
        }
        
        // return carefully
        
        if(dummy1.next!=null){
            return dummy1.next;
        }else if(dummy2.next!=null){
            return dummy2.next;
        }else{
            return dummy3.next;
        }
        
    }
}





