package Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductTwoLengthEncodedArrays {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> res = new ArrayList<>();
        int start1 = 0, start2 = 0;
        int product = 0, count = 0;

        while (start1 < encoded1.length && start2 < encoded2.length) {
            int tmpProduct = encoded1[start1][0] * encoded2[start2][0];
            int tmpCount = Math.min(encoded1[start1][1], encoded2[start2][1]);
            encoded1[start1][1] -= tmpCount;
            encoded2[start2][1] -= tmpCount;

            if (tmpProduct == product) {
                count += tmpCount;
            } else {
                if (count > 0) {
                    res.add(new ArrayList<>(Arrays.asList(product, count)));
                }
                product = tmpProduct;
                count = tmpCount;
            }

            if (encoded1[start1][1] == 0) {
                start1++;
            }
            if (encoded2[start2][1] == 0) {
                start2++;
            }
        }
        res.add(new ArrayList<>(Arrays.asList(product, count)));
        return res;
    }
}
