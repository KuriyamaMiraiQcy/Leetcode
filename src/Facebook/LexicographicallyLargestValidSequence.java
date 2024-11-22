package Facebook;

public class LexicographicallyLargestValidSequence {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[n * 2 - 1];
        boolean[] visited = new boolean[n];
        dfs(res, visited, 0);
        return res;
    }

    private boolean dfs(int[] res, boolean[] visited, int index) {
        if (index == res.length) {
            return true;
        }
        if (res[index] != 0) {
            return dfs(res, visited, index + 1);
        }
        for (int i = visited.length; i > 0; i--) {
            if (!visited[i - 1]) {
                if (i > 1 && (index + i >= res.length || res[index + i] != 0)) {
                    continue;
                }
                res[index] = i;
                if (i != 1) {
                    res[index + i] = i;
                }
                visited[i - 1] = true;
                if (dfs(res, visited, index + 1)) {
                    return true;
                }
                visited[i - 1] = false;
                res[index] = 0;
                if (i != 1) {
                    res[index + i] = 0;
                }
            }
        }
        return false;
    }
}
