import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class NumberOfIslands2 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] directions = new int[][]{{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
        HashMap<String, String> island = new HashMap<>();
        int count = 0;
        LinkedList<Integer> list = new LinkedList<>();

        for (int[] pos : positions) {
            String p = getPosition(pos);
            island.put(p, p);
            count++;

            for (int[] direction : directions) {
                int[] direct = new int[2];
                direct[0] = pos[0] + direction[0];
                direct[1] = pos[1] + direction[1];
                if (direct[0] < 0 || direct[1] < 0 || direct[0] >= m || direct[1] >= n) {
                    continue;
                }
                String neighbor = getPosition(direct);

                if (island.keySet().contains(neighbor)) {
                    neighbor = getRoot(neighbor, island);
                    String r = getRoot(new String(p), island);
                    if (!neighbor.equals(r)) {
                        count--;
                        island.put(r, neighbor);
                    }
                }
            }
            list.add(count);
        }
        return list;
    }

    private String getRoot(String str, HashMap<String, String> is) {
        while (!is.get(str).equals(str)) {
            str = is.get(str);
        }
        return str;
    }

    private String getPosition(int[] pos) {
        return Integer.toString(pos[0]) + Integer.toString(pos[1]);
    }

    public static void main(String[] args) {
        NumberOfIslands2 a = new NumberOfIslands2();
        a.numIslands2(3, 3, new int[][]{{0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 2}, {0, 0}, {1, 1}});
    }
}
