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
    public ListNode middleNode(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            //fast!=null beacuse we are using fast.next.next!=null
            //at some point fast should be null so we have to check before
            //otherwise it will give you null pointer exception. 
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
