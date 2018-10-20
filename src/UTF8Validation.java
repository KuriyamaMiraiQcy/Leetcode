public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int checkNext = 0;
            if (data[i] >= 128 && data[i] < 192 || data[i] > 192 + 32 + 16 + 7 ) {
                return false;
            }
            if (data[i] >= 192 && data[i] < 192 + 32) {
                checkNext = 1;
            }
            if (data[i] >= 192 + 32 && data[i] < 192 + 32 + 16) {
                checkNext = 2;
            }
            if (data[i] >= 192 + 32 + 16 && data[i] < 192 + 32 + 16 + 8) {
                checkNext = 3;
            }
            for (int j = 0; j < checkNext; j++) {
                if (i + j + 1 >= data.length || data[i + j + 1] < 128 || data[i + j + 1] > 128 + 63) {
                    return false;
                }
            }
            i = i + checkNext;
        }
        return true;
    }
}
