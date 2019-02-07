import java.util.*;

public class TopFive {
    public static List<PageRenderTime> solution(int renderCount, List<PageRenderTime> pages) {
        HashMap<Integer, List<Double>> map = new HashMap<>();

        for (PageRenderTime time:pages) {
            if (map.containsKey(time.pageId)) {
                map.get(time.pageId).add(time.renderTime);
            } else {
                LinkedList<Double> list = new LinkedList<>();
                list.add(time.renderTime);
                map.put(time.pageId, list);
            }
        }


        List<PageRenderTime> result = new LinkedList<>();
        for (int key:map.keySet()) {
            List<Double> timeList = map.get(key);
            Collections.sort(timeList);
            double sum = 0;
            int count = 0;

            for (int i = timeList.size() - 1; i >= 0 && count < 5 ; i--, count++) {
                sum += timeList.get(i);
            }

            result.add(new PageRenderTime(key, sum / count));
        }

        return result;
    }

    public static void main(String[] args) {
        List<PageRenderTime> list = new LinkedList<>();
        list.add(new PageRenderTime(1, 40));
        list.add(new PageRenderTime(2, 90));
        list.add(new PageRenderTime(1, 50));
        list.add(new PageRenderTime(2, 80));
        list.add(new PageRenderTime(2, 85));
        list.add(new PageRenderTime(1, 60));
        list.add(new PageRenderTime(1, 70));
        list.add(new PageRenderTime(1, 80));
        list.add(new PageRenderTime(1, 90));
        list.add(new PageRenderTime(1, 100));
        //list.add(new PageRenderTime(2, 95));
        //list.add(new PageRenderTime(2, 100));
        list.add(new PageRenderTime(2, 50));

        for (PageRenderTime time: TopFive.solution(13, list)) {
            System.out.println(time.pageId + ":" + time.renderTime);
        }
    }
}
