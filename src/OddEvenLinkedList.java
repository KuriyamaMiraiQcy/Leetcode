public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode oddtail = oddHead, evenTail = evenHead;

        while (head != null && head.next != null) {
            ListNode next = head.next;
            oddtail.next = head;
            head.next = null;
            head = next.next;
            evenTail.next = next;
            next.next = null;
            oddtail = oddtail.next;
            evenTail = evenTail.next;
        }
        if (head != null) {
            oddtail.next = head;
            oddtail = oddtail.next;
        }

        oddtail.next = evenHead.next;
        return oddHead.next;
    }
}
