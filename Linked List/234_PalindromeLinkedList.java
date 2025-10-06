/**234. Palindrome Linked List
Solved
Easy
Topics - Linked List, Two Pointers, Stack, Recursion

Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

 
Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false

Constraints:
The number of nodes in the list is in the range [1, 10^5].
0 <= Node.val <= 9

Follow up: Could you do it in O(n) time and O(1) space? */




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
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    } 

    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }

        ListNode midNode = findMid(head); 

        ListNode prev = null;
        ListNode curr = midNode;
        ListNode next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode right = prev;
        ListNode left = head;

        while(right != null) {
            if(left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
}