import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SortList {
    //IN PLACE WITH TWO POINTER
    public ListNode SortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }
    public ListNode sortList(ListNode head) {
        ArrayDeque<ArrayDeque<ListNode>> res = new ArrayDeque<>();
        if (head == null) {
            return head;
        }

        while (head != null) {
            ArrayDeque<ListNode> lst = new ArrayDeque<>();
            lst.add(head);
            res.add(lst);
            head = head.next;
        }

        while (res.size() != 1) {
            ArrayDeque<ArrayDeque<ListNode>> temp = new ArrayDeque<>();
            while (res.size() > 1) {
                ArrayDeque<ListNode> first = res.remove();
                ArrayDeque<ListNode> next = res.remove();

                ArrayDeque<ListNode> list = new ArrayDeque<>();
                while (first.size() != 0 && next.size() != 0) {
                    int firstNum = first.peek().val;
                    int nextNum = next.peek().val;

                    if (firstNum <= nextNum) {
                        list.add(first.poll());
                    } else {
                        list.add(next.poll());
                    }
                }
                if (first.size() == 0) {
                    list.addAll(next);
                } else {
                    list.addAll(first);
                }
                temp.add(list);
            }
            if (res.size() % 2 == 1) {
                temp.add(res.remove());
            }
            res = temp;
        }
        ArrayDeque<ListNode> lst = res.remove();
        ListNode newHead = lst.remove();
        ListNode cur = newHead;
        while (lst.size() != 0) {
            cur.next = lst.remove();
            cur = cur.next;
        }
        cur.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        SortList a = new SortList();
        a.sortList(head);
    }
}
