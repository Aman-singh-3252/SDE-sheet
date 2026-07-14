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

// most optimal

class Solution {
    ListNode findMiddle(ListNode head){
        if(head==null || head.next==null){
            return head;
        }

        ListNode fast= head.next;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        return slow;
    }
    ListNode mergeTwoList(ListNode list1, ListNode list2){
        ListNode first=list1;
        ListNode second=list2;
        ListNode dummy = new ListNode(-1);
        ListNode temp=dummy;
        while(first!=null && second!=null){
            if(first.val>second.val){
                temp.next=second;
                second=second.next;
                temp=temp.next;
            }else{
                temp.next=first;
                first=first.next;
                temp=temp.next;
            }
        }

        while(first!=null){
            temp.next=first;
            first=first.next;
            temp=temp.next;
        }

        while(second!=null){
            temp.next=second;
            second=second.next;
            temp=temp.next;
        }

        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        return ms(head);
    }

    ListNode ms(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode middle = findMiddle(head); // find middle using tuttle and hare method

        ListNode leftHead = head; // head of left part of LL.
        ListNode rightHead = middle.next; // head of right part of LL.
        middle.next=null; // breaking the list into two halves

        leftHead = ms(leftHead); // returns a sorted list of first half.
        rightHead = ms(rightHead); // return a sorted list of second half.

        return mergeTwoList(leftHead,rightHead); // we will merge two sorted list using this fn.
    }
}
