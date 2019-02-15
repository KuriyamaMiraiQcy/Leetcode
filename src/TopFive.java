import java.util.*;

public class TopFive {
    public Map<Integer, Double> calculateHighestFive(int renderCount, ArrayList<ProductReviewScore> pages) {
        HashMap<Integer, List<Double>> map = new HashMap<>();

        for (ProductReviewScore time:pages) {
            if (map.containsKey(time.productId)) {
                map.get(time.productId).add(time.reviewScore);
            } else {
                LinkedList<Double> list = new LinkedList<>();
                list.add(time.reviewScore);
                map.put(time.productId, list);
            }
        }


        Map<Integer, Double> result = new HashMap<>();
        for (int key:map.keySet()) {
            List<Double> timeList = map.get(key);
            Collections.sort(timeList);
            double sum = 0;
            int count = 0;

            for (int i = timeList.size() - 1; i >= 0 && count < 5 ; i--, count++) {
                sum += timeList.get(i);
            }

            result.put(key, sum / count);
        }

        return result;
    }

    public static void main(String[] args) {
        List<ProductReviewScore> list = new LinkedList<>();
        list.add(new ProductReviewScore(1, 40));
        list.add(new ProductReviewScore(2, 90));
        list.add(new ProductReviewScore(1, 50));
        list.add(new ProductReviewScore(2, 80));
        list.add(new ProductReviewScore(2, 85));
        list.add(new ProductReviewScore(1, 60));
        list.add(new ProductReviewScore(1, 70));
        list.add(new ProductReviewScore(1, 80));
        list.add(new ProductReviewScore(1, 90));
        list.add(new ProductReviewScore(1, 100));
        //list.add(new PageRenderTime(2, 95));
        //list.add(new PageRenderTime(2, 100));
        list.add(new ProductReviewScore(2, 50));

        TopFive a = new TopFive();

    }
}
