import java.util.HashMap;

public class EvaluationDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] pair: equations) {
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], map.size() + 1);
            }
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], map.size() + 1);
            }
        }

        double[][] adjacencyMatrix = new double[map.size()][map.size()];
        for (int i = 0; i < values.length; i++) {
            int a = map.get(equations[i][0]);
            int b = map.get(equations[i][1]);
            adjacencyMatrix[a][b] = values[i];
            adjacencyMatrix[b][a] = 1.0/values[i];
        }

        double[] results = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (!map.containsKey(queries[i][0]) || !map.containsKey(queries[i][1])) {
                results[i] = -1.0;
            } else {
                int start = map.get(queries[i][0]);
                int end = map.get(queries[i][1]);
                results[i] = checkValue(adjacencyMatrix, start, end);
            }
        }

        return results;
    }

    private double checkValue(double[][] adjacencyMatrix, int start, int end) {
        if (start == end) {
            return 1.0;
        }
        int[] visited = new int[adjacencyMatrix[0].length];
        return DFS(adjacencyMatrix, start, end, 1, visited);
    }

    private double DFS(double[][] adjacencyMatrix, int start, int end, double product, int[] visited) {
        visited[start] = 1;
        if (adjacencyMatrix[start][end] != 0) {
            return product * adjacencyMatrix[start][end];
        }
        for (int i = 0; i < adjacencyMatrix[start].length; i++) {
            if (adjacencyMatrix[start][i] != 0 && visited[i] == 0) {
                double result = DFS(adjacencyMatrix, i, end, product * adjacencyMatrix[start][i], visited);
                if (result != 0 && result != -1) {
                    return result;
                }
            }
        }

        return -1;
    }
}
