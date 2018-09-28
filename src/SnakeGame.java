import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;

public class SnakeGame {
    int[] cur;
    HashMap<String, int[]> directions;
    int width;
    int height;
    int count = 0;
    int[] currentFood = null;
    ArrayDeque<int[]> foods;
    ArrayDeque<int[]> snake;
    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public SnakeGame(int width, int height, int[][] food) {
        snake = new ArrayDeque<>();
        snake.add(new int[]{0,0});

        cur = new int[]{0,0};
        this.width = width;
        this.height = height;
        if (food.length != 0) {
            currentFood = food[0];
            foods = new ArrayDeque<>();

            for (int i = 1; i < food.length; i++) {
                foods.add(food[i]);
            }
        }

        directions = new HashMap<>();
        directions.put("L", new int[]{0,-1});
        directions.put("R", new int[]{0,1});
        directions.put("D", new int[]{1,0});
        directions.put("U", new int[]{-1,0});
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        int[] direct = directions.get(direction);

        cur[0] += direct[0];
        cur[1] += direct[1];

        int[] top = snake.peek();

        if (cur[0] < 0 || cur[1] < 0 || cur[0] >= height || cur[1] >= width) {
            return -1;
        }

        for (int[] pos:snake) {
            if (cur[0] == pos[0] && cur[1] == pos[1] && !pos.equals(top)) {
                return -1;
            }
        }

        if (currentFood != null) {
            if (cur[0] == currentFood[0] && cur[1] == currentFood[1]) {
                count++;
                snake.add(cur.clone());
                if (foods.size() > 0) {
                    currentFood = foods.poll();
                } else {
                    currentFood = null;
                }
                return count;
            }
        }
        snake.add(cur.clone());
        return count;
    }

    public static void main(String[] args) {
        SnakeGame a = new SnakeGame(3, 3, new int[][]{{2,0},{0,0},{0,2},{0,1},{2,2},{0,1}});
        System.out.println(a.move("D"));
        System.out.println(a.move("D"));
        System.out.println(a.move("R"));
        System.out.println(a.move("U"));
        System.out.println(a.move("U"));
        System.out.println(a.move("L"));
        System.out.println(a.move("D"));
        System.out.println(a.move("R"));
        System.out.println(a.move("R"));
        System.out.println(a.move("U"));
        System.out.println(a.move("L"));
        System.out.println(a.move("L"));
        System.out.println(a.move("D"));
        System.out.println(a.move("R"));
        System.out.println(a.move("U"));
    }
}

