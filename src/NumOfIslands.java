import java.util.HashSet;

public class NumOfIslands {
    int width;
    HashSet<Integer> island = new HashSet<>();

    public int numIslands(char[][] grid) {
        int len = grid.length;
        if (len == 0) {
            return 0;
        }
        width = grid[0].length;
        int[] union = new int[len * width + 1];

        if (grid[0][0] == '1') {
            union[1] = 1;
            island.add(1);
        }

        for (int i = 1; i < width; i++) {
            if (grid[0][i] == '1') {
                if (grid[0][i - 1] == '1') {
                    union[index(0, i)] = union[index(0, i -1)];
                } else {
                    union[index(0, i)] = index(0, i);
                    island.add(index(0, i));
                }
            }
        }

        for (int i = 1; i < len; i++) {
            if (grid[i][0] == '1') {
                if (grid[i - 1][0] == '1') {
                    union[index(i, 0)] = union[index(i - 1, 0)];
                } else {
                    union[index(i, 0)] = index(i, 0);
                    island.add(index(i, 0));
                }
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < width; j++) {
                if (grid[i][j] == '1') {
                    if (grid[i - 1][j] == '1' && grid[i][j-1] == '1') {
                        int top = index(i - 1, j);
                        int left = index(i, j -1);
                        if (union[top] < union[left]) {
                            set(union, top, left);
                        } else if (union[top] > union[left]){
                            set(union, left, top);
                        }
                        union[index(i, j)] = Math.min(union[top], union[left]);
                    } else if (grid[i - 1][j] == '1') {
                        union[index(i, j)] = union[index(i - 1, j)];
                    } else if (grid[i][j-1] == '1') {
                        union[index(i, j)] = union[index(i, j -1)];
                    } else {
                        union[index(i, j)] = index(i, j);
                        island.add(index(i, j));
                    }
                }
            }
        }

        return island.size();
    }

    private void set(int[] union, int a, int b) {
        island.remove(union[b]);
        union[union[b]] = union[a];
        union[b] = union[a];
    }

    private int index(int i, int j) {
        return i * width + j + 1;
    }

    public static void main(String[] args) {
        NumOfIslands a =new NumOfIslands();
        char[][] test = new char[][]{{'1','1','1','1','1','1','1','1','1'},
        {'1','0','0','0','0','0','0','0','1'},
            {'1','0','1','0','1','0','1','0','1'},
                {'1','0','1','1','1','1','1','0','1'},
                {'1','0','1','0','1','0','1','0','1'},
                {'1','0','0','0','0','0','0','0','1'},
                {'1','1','1','1','1','1','1','1','1'}};
        System.out.println(a.numIslands(test));
        System.out.println(a.numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
    }
}
