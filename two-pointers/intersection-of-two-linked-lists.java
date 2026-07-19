/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */



public class Solution {
    // Helper to count nodes
    private int getCount(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    // Helper to get intersection by advancing the longer list
    private ListNode getIntersectionByDiff(int diff, ListNode head1, ListNode head2) {
        ListNode curr1 = head1;
        ListNode curr2 = head2;

        // Advance the longer list by 'diff' nodes
        for (int i = 0; i < diff; i++) {
            if (curr1 == null) return null;
            curr1 = curr1.next;
        }

        // Move both pointers and compare
        while (curr1 != null && curr2 != null) {
            if (curr1 == curr2) {
                return curr1; // intersection found
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return null; // no intersection
    }

    // Main function to return the intersection node
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getCount(headA);
        int lenB = getCount(headB);

        if (lenA > lenB) {
            return getIntersectionByDiff(lenA - lenB, headA, headB);
        } else {
            return getIntersectionByDiff(lenB - lenA, headB, headA);
        }
    }
}
