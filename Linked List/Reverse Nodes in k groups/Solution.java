/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k<=1){
            return head;
            // edges cases necessary to handle;
        }
        ListNode dummy=new ListNode(0);
        // creating a new node
        
        dummy.next=head;
        // connecting to the existing linkedlist

        ListNode temp=head;
        //making a temp varibale pointing to head.

        ListNode prev=dummy;
        //making prev points to dummy
        int cnt=0;
        // making sure find group of exactly k nodes

        while(temp!=null){
            cnt++;

            if(cnt%k==0){
                // reverse k nodes starting from groupPrev.next to temp
                ListNode groupHead = prev.next;
                ListNode nextGroup = temp.next;

                // reverse k nodes
                ListNode newHead = reverse(null, groupHead, k);

                prev.next=newHead;
                // joining the new head of reversed group to the node who is pointing to previous head.
                groupHead.next=nextGroup;

                prev=groupHead;
                temp=nextGroup;

            }else{
                temp=temp.next;
            }
        }

        return dummy.next;
    }

    static ListNode reverse(ListNode prev,ListNode curr,int steps){
        if(steps==0 || curr==null){
            return prev;
        }

        ListNode temp=curr.next;
        curr.next=prev;
        return reverse(curr,temp,steps-1);
    }
}
