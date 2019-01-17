import java.util.LinkedList;

public class NumMatrix {
    SegmentTreeNode root;
    int rowLength;

    class SegmentTreeNode {
        int val;
        int start;
        int end;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int val, int start, int end) {
            this.val = val;
            this.start = start;
            this.end = end;
        }

    }

    public NumMatrix(int[][] matrix) {
        if (matrix.length != 0) {
            LinkedList<SegmentTreeNode> list = new LinkedList<>();
            rowLength = matrix[0].length;

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < rowLength; j++) {
                    SegmentTreeNode node = new SegmentTreeNode(matrix[i][j], i * rowLength + j, i * rowLength + j);
                    list.add(node);
                }
            }

            root = buildSegmentTree(list);
        }
    }

    private SegmentTreeNode buildSegmentTree(LinkedList<SegmentTreeNode> list) {
        while (list.size() > 1) {
            SegmentTreeNode first = list.removeFirst();
            SegmentTreeNode next = list.removeFirst();
            SegmentTreeNode root = new SegmentTreeNode(first.val + next.val, Math.min(first.start, next.start), Math.max(first.end, next.end));
            root.left = first;
            root.right = next;
            list.add(root);
        }
        return list.remove();
    }

    public void update(int row, int col, int val) {
        int start = row * rowLength + col;
        updateSegmentTree(root, start, val);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            int start = i * rowLength + col1;
            int end = i * rowLength + col2;
            sum += getRangeQuery(start, end, root);
        }

        return sum;
    }

    private int getRangeQuery(int start, int end, SegmentTreeNode root) {
        if (root == null || start > root.end || end < root.start) {
            return 0;
        }

        if (start <= root.start && end >= root.end) {
            return root.val;
        }

        int left = getRangeQuery(start, end, root.left);
        int right = getRangeQuery(start, end, root.right);
        return left + right;
    }

    private int updateSegmentTree(SegmentTreeNode root, int start, int val) {
        if (root == null || root.end < start || root.start > start) {
            return 0;
        }
        if (root.start == start && root.end == start) {
            int change = val - root.val;
            root.val = val;
            return change;
        }


        int left = updateSegmentTree(root.left, start, val);
        int right = updateSegmentTree(root.right, start, val);
        root.val += left + right;
        return left + right;
    }

    //Binary Indexed Tree
    int[][] tree;
    int[][] nums;
    int m;
    int n;

    //boolean flag is to avoid compiler error
    public NumMatrix(int[][] matrix, boolean flag) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        m = matrix.length;
        n = matrix[0].length;
        tree = new int[m+1][n+1];
        nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Update(i, j, matrix[i][j]);
            }
        }
    }

    public void Update(int row, int col, int val) {
        if (m == 0 || n == 0) return;
        int delta = val - nums[row][col];
        nums[row][col] = val;
        for (int i = row + 1; i <= m; i += i & (-i)) {
            for (int j = col + 1; j <= n; j += j & (-j)) {
                tree[i][j] += delta;
            }
        }
    }

    public int SumRegion(int row1, int col1, int row2, int col2) {
        if (m == 0 || n == 0) return 0;
        return sum(row2+1, col2+1) + sum(row1, col1) - sum(row1, col2+1) - sum(row2+1, col1);
    }

    public int sum(int row, int col) {
        int sum = 0;
        for (int i = row; i > 0; i -= i & (-i)) {
            for (int j = col; j > 0; j -= j & (-j)) {
                sum += tree[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        NumMatrix a = new NumMatrix(new int[][]{
                {3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}
        });
        a.update(3,2,2);
        a.update(3,2,0);
        a.update(3,2,10);
        System.out.println(a.sumRegion(2,1,4,3));
    }
}
