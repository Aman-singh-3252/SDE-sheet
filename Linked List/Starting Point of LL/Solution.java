/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        boolean f=false;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                f=true;
                break;

            }
        }

        if(!f){
            return null;
        }
        //the point where the fast and slow pointer meets , the distance of the point and the distance of the head from the starting point of the cycle is equal.

        while(head!=fast){
            head=head.next;
            fast=fast.next;
        }
        return fast;
    }
}
