package Facebook;

import java.util.HashMap;

public class IntegerRoman {
    private static int[] vals = {1000,500,100,50,10,5,1};
    private static char[] symbol = {'M','D','C','L','X','V','I'};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vals.length; i += 2) {
            int res = num / vals[i];
            if (res == 0) {
                continue;
            }
            num -= res * vals[i];
            if (res / 5 == 1) {
                sb.append(symbol[i - 1]);
            }
            int left = res % 5;
            if (left == 4) {
                sb.append(symbol[i]);
                if (res == 9) {
                    sb.deleteCharAt(sb.length() - 2);
                    sb.append(symbol[i - 2]);
                } else {
                    sb.append(symbol[i - 1]);
                }
            } else {
                for (int j = 0; j < left; j++) {
                    sb.append(symbol[i]);
                }
            }

        }
        return sb.toString();
    }
}
