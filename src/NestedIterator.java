import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer>{
    ArrayList<Integer> list = new ArrayList<>();
    Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        flatten(nestedList, list);
        it = list.iterator();
    }

    private void flatten(List<NestedInteger> nestedList, ArrayList<Integer> list) {
        for (NestedInteger iter:nestedList) {
            if (iter.isInteger()) {
                list.add(iter.getInteger());
            } else {
                flatten(iter.getList(), list);
            }
        }
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}
