package Facebook;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] in_degrees = new int[n];
        for (int i = 0; i < leftChild.length; i++) {
            if (leftChild[i] != -1) {
                in_degrees[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                in_degrees[rightChild[i]]++;
            }
        }

        int root = -1;
        for (int i = 0; i < n; i++) {
            if (in_degrees[i] == 0) {
                root = i;
                break;
            }
        }
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            root = queue.poll();
            if (leftChild[root] != -1) {
                if (visited.contains(leftChild[root])) {
                    return false;
                }
                queue.add(leftChild[root]);
                visited.add(leftChild[root]);
            }
            if (rightChild[root] != -1) {
                if (visited.contains(rightChild[root])) {
                    return false;
                }
                queue.add(rightChild[root]);
                visited.add(rightChild[root]);
            }
        }
        return visited.size() == n;
    }
}
