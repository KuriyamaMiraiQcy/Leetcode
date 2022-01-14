import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class minimumMovesBox {
    char[][] grid;
    int[] directionX = new int[]{1,0,-1,0};
    int[] directionY = new int[]{0,1,0,-1};
    public int minPushBox(char[][] grid) {
        int[] state = new int[5];
        this.grid = grid;
        HashSet<String> visited = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'B') {
                    state[0] = i;
                    state[1] = j;
                    this.grid[i][j] = '.';
                }
                if (grid[i][j] == 'S') {
                    state[2] = i;
                    state[3] = j;
                    this.grid[i][j] = '.';
                }
            }
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[4] - o2[4];
            }
        });
        heap.add(state);
        visited.add(state[0]+"," +state[1]+","+state[2]+","+state[3]);
        while (!heap.isEmpty()) {
            int[] current = heap.poll();
            if (this.grid[current[0]][current[1]] == 'T') {
                return current[4];
            }
            this.grid[current[0]][current[1]] = '#';
            for (int i = 0; i < 4; i++) {
                if (checkIndex(i, current[0], current[1]) &&
                        this.grid[current[0] + directionX[i]][current[1] + directionY[i]] != '#' &&
                        this.grid[current[0] + directionX[(i + 2)%4]][current[1] + directionY[(i + 2)%4]] != '#' &&
                        isConnected(current[0] + directionX[i], current[1] + directionY[i], current[2], current[3], new HashSet<String>())) {
                    int[] next = new int[5];
                    next[0] = current[0] + directionX[(i + 2)%4];
                    next[1] = current[1] + directionY[(i + 2)%4];
                    next[2] = current[0];
                    next[3] = current[1];
                    next[4] = current[4]+1;
                    if (!visited.contains(next[0]+"," +next[1]+","+next[2]+","+next[3])) {
                        visited.add(next[0]+"," +next[1]+","+next[2]+","+next[3]);
                        heap.offer(next);
                    }
                }
            }
            this.grid[current[0]][current[1]] = '.';
        }
        return -1;
    }

    private boolean checkIndex(int i, int x, int y) {
        return x + directionX[i] >= 0 && x + directionX[i] < this.grid.length &&
                y + directionY[i] >= 0 && y + directionY[i] < this.grid[0].length &&
                x + directionX[(i + 2)%4] >= 0 && x + directionX[(i + 2)%4] < this.grid.length &&
                y + directionY[(i + 2)%4] >= 0 && y + directionY[(i + 2)%4] < this.grid[0].length;
    }

    private boolean isConnected(int x, int y, int pX, int pY, Set<String> visited) {
        if (x == pX && y == pY) {
            return true;
        }
        if (x <0 || x >= grid.length || y < 0 || y>=grid[0].length || grid[x][y] == '#' || visited.contains(x + "," + y)) {
            return false;
        }
        visited.add(x + "," + y);
        return isConnected(x+1,y,pX,pY, visited) || isConnected(x-1,y,pX,pY, visited) || isConnected(x,y+1,pX,pY, visited) || isConnected(x,y-1,pX,pY, visited);
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'#','#','#','#','#','#'},
                {'#','T','#','#','#','#'},
                {'#','.','.','B','.','#'},
                {'#','.','#','#','.','#'},
                {'#','.','.','.','S','#'},
                {'#','#','#','#','#','#'}};
        minimumMovesBox a = new minimumMovesBox();
        System.out.println(a.minPushBox(grid));
    }
}
