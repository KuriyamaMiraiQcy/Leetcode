public class ReverseNodesinKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        boolean isEnd = false;
        ListNode reverseHead = new ListNode(0);

        while (head != null && !isEnd) {
            int count = k;
            reverseHead = new ListNode(0);

            while (count != 0) {
                if (head == null) {
                    isEnd = true;
                    break;
                }
                ListNode next = head.next;
                head.next = reverseHead.next;
                reverseHead.next = head;
                head = next;
                count--;
            }

            if (!isEnd) {
                tail.next = reverseHead.next;
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }

        if (isEnd) {
            reverseHead = reverseHead.next;
            ListNode dummy = new ListNode(0);

            while (reverseHead != null) {
                ListNode next = reverseHead.next;
                reverseHead.next = dummy.next;
                dummy.next = reverseHead;
                reverseHead = next;
            }

            tail.next = dummy.next;
        }

        return dummyHead.next;
    }

    static public void main(String[] args) {
        ReverseNodesinKGroup a = new ReverseNodesinKGroup();
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);
        test.next.next.next.next = new ListNode(5);
        ListNode r = a.reverseKGroup(test, 2);
        System.out.println(r.val);
    }
}
