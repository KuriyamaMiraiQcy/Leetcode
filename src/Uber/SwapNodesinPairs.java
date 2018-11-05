package Uber;

public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pseHead = new ListNode(0);
        ListNode prevTail = pseHead;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            ListNode next = cur.next.next;
            prevTail.next = cur.next;
            cur.next = null;
            prevTail.next.next = cur;
            cur = next;
            prevTail = prevTail.next.next;
        }
        if (cur != null) {
            prevTail.next = cur;
        }
        return pseHead.next;
    }
}
