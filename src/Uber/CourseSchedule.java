package Uber;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {
    int num;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        num = numCourses;
        HashMap<Integer, Graph> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new Graph(i));
        }

        for (int[] pair: prerequisites) {
            Graph start = map.get(pair[0]);
            start.neighbors.add(map.get(pair[1]));
        }

        return isCycle(map);
    }

    private boolean isCycle(HashMap<Integer, Graph> map) {

        int[] visited = new int[num];
        int[] recStack = new int[num];

        for (int i = 0; i < num; i++) {
            if (DFS(map.get(i), visited, recStack)) {
                return false;
            }
        }
        return true;
    }

    private boolean DFS(Graph node, int[] visited, int[] rec) {
        int label = node.label;
        if (rec[label] == 1) {
            return true;
        }
        if (visited[label] == 1) {
            return false;
        }

        visited[label] = 1;
        rec[label] = 1;
        for (Graph child: node.neighbors) {
            if (DFS(child, visited, rec)) {
                return true;
            }
        }
        rec[label] = 0;
        return false;
    }

    public class Graph{
        int label;
        List<Graph> neighbors;

        public Graph(int label) {
            this.label = label;
            neighbors = new LinkedList<>();
        }
    }
}
