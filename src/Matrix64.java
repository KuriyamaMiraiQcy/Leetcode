public class Matrix64 {
    public int route(int[][] matrix) {
        int[][] memory = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            memory[0][i] = matrix[0][i];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    memory[i][j] = Math.min(memory[i - 1][j], memory[i - 1][j + 1]) + matrix[i][j];
                } else if (j == matrix[0].length - 1) {
                    memory[i][j] = Math.min(memory[i - 1][j], memory[i - 1][j - 1]) + matrix[i][j];
                } else {
                    memory[i][j] = Math.min(memory[i - 1][j], Math.min(memory[i - 1][j - 1], memory[i - 1][j + 1])) + matrix[i][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            if (memory[matrix.length - 1][i] < min) {
                min = memory[matrix.length - 1][i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Matrix64 a = new Matrix64();
        System.out.print(a.route(new int[][]{{2,3,5},{5,6,7},{8,4,25}}));

    }
}
