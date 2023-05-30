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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        List<Integer> list = new LinkedList<>();
        int listSize = head == null ? 0 : 1;

        list.add(cur.val);
        while (cur.next != null) {
            cur = cur.next;
            list.add(cur.val);
            listSize++;
        }

        list.remove(list.size() - n);

        if (list.size() == 0) {
            return null;
        }

        head = new ListNode();
        ListNode answer = head;
        for (int i = 0; i < list.size(); i++) {
            answer.next = new ListNode(list.get(i));
            System.out.println(answer.next.val);
            answer = answer.next;
        }
        return head.next;
    }
}