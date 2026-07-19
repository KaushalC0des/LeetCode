
class Solution {
   public ListNode reverseList(ListNode head){
      if(head == null){
        return head;
      }
      if(head.next == null){
        return head;
      }
      ListNode prev = head;
      ListNode curr = head.next;
      while(curr != null){
        ListNode next = curr.next;
        curr.next = prev;

        prev = curr;
        curr = next;
      }
      head.next = null;
    return prev;
   }
}
