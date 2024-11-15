package Facebook;

public class LeftmostColumnLeastOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int row = binaryMatrix.dimensions().get(0), col = binaryMatrix.dimensions().get(1) - 1;

        int start_r = 0, result = col + 1;
        while (start_r < row && col >= 0) {
            if (binaryMatrix.get(start_r, col) == 1) {
                result = Math.min(result, col);
                col--;
            } else {
                start_r++;
            }
        }
        return result == binaryMatrix.dimensions().get(1) ? -1 :result;
    }

}
