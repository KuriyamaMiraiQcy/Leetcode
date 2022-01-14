public class Maze {
    int[][] maze;
    boolean[][] visited;
    int[] dest;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.maze = maze;
        this.dest = destination;
        visited = new boolean[maze.length][maze[0].length];
        return dfs(start[0], start[1]);
    }

    private boolean dfs(int x, int y) {
        if (x == dest[0] && y == dest[1]) {
            return true;
        }
        visited[x][y] = true;
        for (int i = x; i >=0 ; i--) {
            if (i == 0 || (maze[i][y] ==0 && maze[i-1][y] ==1)){
                if (visited[i][y]) {
                    break;
                }
                if (dfs(i, y)) {
                    return true;
                }
                break;
            }
        }
        for (int i = x; i < maze.length ; i++) {
            if (i == maze.length - 1 || (maze[i][y]==0 && maze[i + 1][y] ==1)){
                if (visited[i][y]) {
                    break;
                }
                if (dfs(i, y)) {
                    return true;
                }
                break;
            }
        }
        for (int i = y; i >=0 ; i--) {
            if (i == 0 || (maze[x][i] ==0 && maze[x][i-1] ==1)){
                if (visited[x][i]) {
                    break;
                }
                if (dfs(x, i)) {
                    return true;
                }
                break;
            }
        }
        for (int i = y; i < maze[x].length ; i++) {
            if (i == maze[x].length - 1 || (maze[x][i]==0 && maze[x][i+1] ==1)){
                if (visited[x][i]) {
                    break;
                }
                if (dfs(x, i)) {
                    return true;
                }
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Maze a = new Maze();
        System.out.println(a.hasPath(new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}}, new int[]{0,4}, new int[]{4,1}));
    }
}
