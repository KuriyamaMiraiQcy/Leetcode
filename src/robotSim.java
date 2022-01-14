import java.lang.reflect.Array;
import java.util.*;

public class robotSim {
    int x = 0;
    int y = 0;
    int directions = 0;

    public int robotSim(int[] commands, int[][] obstacles) {
        Arrays.sort(obstacles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
            }
        });
        int maxDistance = 0;
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case -1:
                    directions = (directions + 1) % 4;
                    break;
                case -2:
                    directions = (directions - 1 + 4) % 4;
                    break;
                default:
                    move(commands[i], obstacles);
                    maxDistance = Math.max(maxDistance, x * x + y * y);
            }
        }
        return maxDistance;
    }

    public void move(int moves, int[][] obstacles) {
        switch (directions) {
            case 0:
                handleY(moves, obstacles);
                break;
            case 1:
                handleX(moves, obstacles);
                break;
            case 2:
                handleY(-moves, obstacles);
                break;
            default:
                handleX(-moves, obstacles);
        }
    }

    public void handleY(int moves, int[][] obstacles) {
        int minMoves = Math.abs(moves);
        for (int i = 0; i < obstacles.length; i++) {
            if (obstacles[i][0] == x) {
                if ((y < obstacles[i][1] && obstacles[i][1] <= y + moves) || (y > obstacles[i][1] && obstacles[i][1] >= y + moves)) {
                    minMoves = Math.min(minMoves, Math.abs(obstacles[i][1] - y) - 1);
                }
            }
        }
        y += minMoves * moves / Math.abs(moves);
    }

    public void handleX(int moves, int[][] obstacles) {
        int minMoves = Math.abs(moves);
        for (int i = 0; i < obstacles.length; i++) {
            if (obstacles[i][1] == y) {
                if ((x < obstacles[i][0] && obstacles[i][0] <= x + moves) || (x > obstacles[i][0] && obstacles[i][0] >= x + moves)) {
                    minMoves = Math.min(minMoves, Math.abs(obstacles[i][0] - x) - 1);
                }
            }
        }
        x += minMoves * moves / Math.abs(moves);
    }

    public int RobotSim(int[] commands, int[][] obstacles) {
        int[] xMobile = {0, 1, 0, -1};
        int[] yMobile = {1, 0, -1, 0};
        int direction = 0;
        Set<String> obstaclesSet = new HashSet<>();
        for (int[] print : obstacles) {
            String key = print[0] + "," + print[1];
            obstaclesSet.add(key);
        }
        int x = 0;
        int y = 0;
        int max = 0;
        for (int value : commands) {
            if (value == -1) {
                direction = (direction + 1) % 4;
            } else if (value == -2) {
                direction = (direction + 3) % 4;
            } else {
                //行走
                for (int i = 0; i < value; i++){
                    int tempX = x + xMobile[direction];
                    int tempY = y + yMobile[direction];
                    if (obstaclesSet.contains(tempX + "," + tempY)){
                        break;
                    }
                    x = tempX;
                    y = tempY;
                    max = max > x * x + y * y ? max : x * x + y * y;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        robotSim a = new robotSim();
        int[] commands = new int[]{7,-2,-2,7,5};
        System.out.println(a.robotSim(commands, new int[][]{{-3,2},{-2,1},{0,1},{-2,4},{-1,0},{-2,-3},{0,-3}}));
    }
}
