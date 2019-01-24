import java.util.List;

public class NestedListWeightSumII {

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = 1;

        for (NestedInteger n:nestedList) {
            maxDepth = Math.max(maxDepth, findDepth(0, n));
        }

        int sum = 0;
        for (NestedInteger n:nestedList) {
            sum +=getSum(0, 0, maxDepth, n);
        }

        return sum;
    }

    private int getSum(int sum, int current, int maxDepth, NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            return (maxDepth - current) * nestedInteger.getInteger();

        } else {
            sum = 0;
            for (NestedInteger n : nestedInteger.getList()) {
                sum += getSum(sum, current + 1, maxDepth, n);
            }
        }
        return sum;
    }

    private int findDepth(int prev, NestedInteger nestedList) {
        if (nestedList.isInteger()) {
            return prev + 1;
        }

        int max = 0;
        for (NestedInteger n: nestedList.getList()) {
            max = Math.max(max, findDepth(prev + 1, n));
        }
        return max;
    }
}
