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
    public boolean isPalindrome(ListNode head) {
        // without using the extra space
        if(head.next==null){
            return true;
        }

        // first we will find the middle of the linkedlist
        // in case of even length linked list we will make sure it will stop at the first middle
        // but in case of odd length linkedlist it will stop at exactly at the middle
        ListNode fast=head;
        ListNode slow=head;

        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode newHead=reverse(null,slow.next);//found reverse head.

        // using two pointer for finding the palindrome.
        ListNode first=head;
        ListNode second=newHead;

        while(second!=null){
            if(first.val!=second.val){
                return false;
            }
            first=first.next;
            second=second.next;
        }

        return true;
    }
    static ListNode reverse(ListNode prev,ListNode curr){
        // function to reverse the linkedlist.
        if(curr==null){
            return prev;
        }
        ListNode temp=curr.next;
        curr.next=prev;
        return reverse(curr,temp);
    }
}
