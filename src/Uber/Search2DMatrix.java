package Uber;

import java.util.Arrays;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int start = 0;
        int end = m;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target > matrix[mid][n]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        int num = Arrays.binarySearch(matrix[start], target);
        return num >= 0;
    }
}
