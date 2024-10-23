package Facebook;

import Uber.ListNode;

public class RemoveNthNodeEndList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode quick = head;
        for (int i = 0; i < n && quick != null; i++) {
            quick = quick.next;
        }

        while (quick.next != null) {
            quick = quick.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
