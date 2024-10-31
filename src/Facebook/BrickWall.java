package Facebook;

import java.util.HashMap;
import java.util.List;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> wallLocCount = new HashMap<>();
        for (List<Integer> row : wall) {
            int loc = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                loc += row.get(i);
                wallLocCount.put(loc, wallLocCount.getOrDefault(loc, 0) + 1);
            }
        }

        int max = 0;
        for (int key : wallLocCount.keySet()) {
            if (wallLocCount.get(key) > max) {
                max = wallLocCount.get(key);
            }
        }
        return wall.size() - max;
    }
}
