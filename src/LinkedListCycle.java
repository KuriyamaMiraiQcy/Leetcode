import java.util.HashSet;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        HashSet<Integer> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head.val)) {
                return false;
            }
            set.add(head.val);
            head = head.next;
        }
        return set.size()!= 0;
    }
}
