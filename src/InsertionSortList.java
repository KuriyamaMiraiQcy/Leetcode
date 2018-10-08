public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pseHead = new ListNode(0);
        ListNode prev;
        ListNode next = head;

        while (next != null) {
            prev = pseHead;
            while (prev.next != null && prev.next.val < next.val) {
                prev = prev.next;
            }
            ListNode cur = next.next;
            next.next = prev.next;
            prev.next = next;
            next = cur;
        }

        return pseHead.next;
    }

    public static void main(String[] args) {
        InsertionSortList a =new InsertionSortList();
        ListNode test = new ListNode(3);
        test.next = new ListNode(2);
        test.next.next = new ListNode(4);
        test.next.next.next = new ListNode(1);
        a.insertionSortList(test);
    }
}
