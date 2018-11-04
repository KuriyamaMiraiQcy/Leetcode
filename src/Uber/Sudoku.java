package Uber;

import java.util.HashMap;
import java.util.HashSet;

public class Sudoku {
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++) {
            char[] arr = board[i];
            if(!isValidHelper(arr)) {
                return false;
            }

            char[] arr2 = new char[9];
            for(int j = 0; j < 9; j++) {
                arr2[j] = board[j][i];
            }
            if(!isValidHelper(arr2)) {
                return false;
            }

            int x = i/3 * 3;
            int y = i%3 * 3;
            char[] arr3 = new char[9];
            int j = 0;
            for(int m = x; m < x + 3; m++) {
                for(int n = y; n < y + 3; n++) {
                    arr3[j++] = board[m][n];
                }
            }
            if(!isValidHelper(arr3)) {
                return false;
            }
        }

        return true;
    }

    public boolean isValidHelper(char[] arr) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i]) && arr[i] != '.') {
                return false;
            }
            set.add(arr[i]);
        }
        return true;
    }
}
