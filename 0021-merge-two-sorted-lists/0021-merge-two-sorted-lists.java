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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode answer = new ListNode();
        ListNode head = answer;

        while (cur1 != null || cur2 != null) {
            while (cur1 != null && cur2 != null && cur1.val <= cur2.val) {
                answer.next = new ListNode(cur1.val);
                cur1 = cur1.next;
                answer = answer.next;
            }

            while (cur1!= null && cur2 != null && cur2.val <= cur1.val) {
                answer.next = new ListNode(cur2.val);
                cur2 = cur2.next;
                answer = answer.next;
            }

            if (cur2 == null) {
                while (cur1 != null) {
                    answer.next = new ListNode(cur1.val);
                    cur1 = cur1.next;
                    answer = answer.next;
                }
            }

            if (cur1 == null) {
                while (cur2 != null) {
                    answer.next = new ListNode(cur2.val);
                    cur2 = cur2.next;
                    answer = answer.next;
                }
            }
        }

        return head.next;
    }
}