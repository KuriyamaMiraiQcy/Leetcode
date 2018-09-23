import java.util.*;

public class BidID {
    // Complete the GetUnallottedBidIds function below.
    static List<Integer> GetUnallottedBidIds(List<List<Integer>> bids, int totalShares) {
        int[] shares = new int[bids.size() + 1];

        Collections.sort(bids, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(2) == o2.get(2))
                    return o1.get(3)- o2.get(3);
                return o2.get(2) - o1.get(2);
            }
        });
        
        
        int index = 0;
        int people_share = 0;
        while (totalShares > 0) {
            ArrayList<List<Integer>> list = new ArrayList<>();
            int price_ = bids.get(index).get(2);
            int max_ = 0;
            while (bids.get(index).get(2) == price_) {
                max_ += bids.get(index).get(1);
                list.add(bids.get(index++));
            }
            int min_ = list.size();
            if (totalShares > max_) {
                totalShares -= max_;
                people_share += list.size();
                continue;
            } else if (totalShares < min_) {
                people_share += totalShares;
                totalShares = 0;
            } else {
                people_share += list.size();
                totalShares = 0;
            }
        }


        ArrayList<Integer> res = new ArrayList<>();
        for (int i = people_share; i < bids.size(); i++) {
            res.add(bids.get(i).get(0));
        }

        Collections.sort(res);

        return res;
    }
}
