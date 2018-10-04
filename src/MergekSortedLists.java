import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {
    //Divide and conquer
    public ListNode MergeKLists(ListNode[] lists) {

        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists, int start, int end) {

        if (start > end) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        if (start + 1 == end) {
            return mergeSort(lists[start], lists[end]);
        }

        int mid = start + ((end - start) >> 1);
        ListNode upper = divide(lists, start, mid - 1);
        ListNode lower = divide(lists, mid, end);

        return mergeSort(upper, lower);
    }

    private ListNode mergeSort(ListNode first, ListNode second) {

        ListNode dummyHead = new ListNode(0), ptrFirst = first, ptrSecond = second, ptrDummy = dummyHead;

        while (ptrFirst != null && ptrSecond != null) {
            if (ptrFirst.val < ptrSecond.val) {
                ptrDummy.next = ptrFirst;
                ptrFirst = ptrFirst.next;
                ptrDummy = ptrDummy.next;
            }
            else {
                ptrDummy.next = ptrSecond;
                ptrSecond = ptrSecond.next;
                ptrDummy = ptrDummy.next;
            }
        }

        if (ptrFirst != null) {
            ptrDummy.next = ptrFirst;
        }
        else if (ptrSecond != null) {
            ptrDummy.next = ptrSecond;
        }

        return dummyHead.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode end = head;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode n: lists) {
            if (n != null) {
                pq.add(n);
            }
        }

        while (pq.size() != 0) {
            ListNode node = pq.poll();
            end.next = node;
            end = node;
            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return head.next;
    }
}
