package Facebook;

import java.util.*;

public class FlattenNestedListIterator {
    public class NestedIterator implements Iterator<Integer> {
        int[] nums;
        int index = 0;
        List<NestedInteger> list;
        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            for (NestedInteger i : nestedList) {
                flatten(i);
            }
            nums = new int[nestedList.size()];
            for (int i = 0; i < list.size(); i++) {
                nums[i] = list.get(i).getInteger();
            }
        }

        @Override
        public Integer next() {
            return nums[index++];
        }

        @Override
        public boolean hasNext() {
            return index < nums.length;
        }

        private void flatten(NestedInteger root) {
            if (root.isInteger()) {
                list.add(root);
                return;
            }
            for (NestedInteger n : root.getList()) {
                flatten(n);
            }
        }
    }
}
