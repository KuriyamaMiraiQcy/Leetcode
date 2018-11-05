package Uber;

public class BeautifulArrangement {
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N];
        return DFS(N, N, visited);
    }
    // faster if go from back
    private int DFS(int cur, int N, boolean[] visited) {
        if (cur == 0) {
            return 1;
        }
        int count = 0;
        for (int i = N; i > 0; i--) {
            if (!visited[i - 1]) {
                if (i % cur == 0 || cur % i == 0) {
                    visited[i - 1] = true;
                    count += DFS(cur + 1, N, visited);
                    visited[i - 1] = false;
                }
            }
        }
        return count;
    }
}
