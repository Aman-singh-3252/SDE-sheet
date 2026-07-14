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
    public ListNode deleteMiddle(ListNode head) {
        // checking some edge cases , slow could be at last node so check for it in the starting.
        if(head==null || head.next==null){
            return null;
        }else if(head.next.next==null){
            head.next=null;
            return head;
        }

        // using slow and fast pointer for finding the middle of the linkedlist
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        while(slow.next!=null && slow.next.next!=null){
            slow.val=slow.next.val;
            slow=slow.next;
        }
        // copy the last node val to current node val and then remove the last node by pointing it to null.
        slow.val=slow.next.val;
        slow.next=null;
        return head;

    }
}
