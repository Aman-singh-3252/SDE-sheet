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

// Recursive Method
class Solution {
    public ListNode reverseList(ListNode head) {
        return solve(null,head);
    }
    ListNode solve(ListNode prev, ListNode curr){
        if(curr==null){
            return prev;
        }
        ListNode temp = curr.next;
        curr.next=prev;
       return solve(curr,temp);
    }
}


// Iterative Method

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
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode temp=head;
        ListNode front=head;

        while(temp!=null){
            front=front.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }

        return prev;
       
    }
}
