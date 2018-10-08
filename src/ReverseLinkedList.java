public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        /* Recursive
        ListNode reverseHead = new ListNode(0);
        while (head != null) {
            ListNode next = head.next;
            head.next = reverseHead.next;
            reverseHead.next = head;
            head = next;
        }
        return reverseHead.next;
        */


        return reverseListInt(head, null);
    }


    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}

