import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Bucket> map = new HashMap<>();
        for (String str:words) {
            if (map.containsKey(str)) {
                map.get(str).val++;
            } else {
                map.put(str, new Bucket(1, str));
            }
        }

        Bucket[] buckets = map.values().toArray(new Bucket[0]);
        Arrays.sort(buckets, new Comparator<Bucket>() {
            @Override
            public int compare(Bucket o1, Bucket o2) {
                if (o2.val == o1.val) {
                    return o1.str.compareTo(o2.str);
                }
                return o2.val - o1.val;
            }
        });

        LinkedList<String> res = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            res.add(buckets[i].str);
        }
        return res;
    }

    public class Bucket {
        int val;
        String str;

        public Bucket(int val, String str) {
            this.val = val;
            this.str = str;
        }
    }
}
