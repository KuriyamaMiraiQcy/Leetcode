public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode cur = head;
        RandomListNode next;
        while (cur != null) {
            next = cur.next;
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = next;
            cur.next = copy;
            cur = next;
        }

        cur = head;
        while (cur != null && cur.next != null) {
            if (cur.random == null) {
                cur.next.random = null;
            } else {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }


        RandomListNode newHead = new RandomListNode(0);
        RandomListNode res = newHead;
        RandomListNode curNext;
        cur = head;
        next = res;

        while (cur != null) {
            curNext = cur.next.next;
            next = cur.next;
            res.next = next;
            res = next;

            cur.next = curNext;
            cur = curNext;
        }

        return res;
    }
}
