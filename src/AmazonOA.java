import java.util.*;

public class AmazonOA {
    int maxMoney(int[][] bags, int k) {
        int[] data = new int[bags[bags.length - 1][1]];
        for (int[] b : bags) {
            for (int i = b[0]; i <= b[1]; i++) {
                data[i - 1] = b[2];
            }
        }

        int end = k, sum = 0, result = 0;
        for (int i = 0; i < k; i++) {
            sum += data[i];
        }
        while (end < data.length) {
            sum += data[end] - data[end - k];
            end++;
            result = Math.max(result, sum);
        }
        return result;
    }

    int caloriesBurn(int[] height) {
        Arrays.sort(height);
        int sum = height[height.length - 1] * height[height.length - 1];
        int start = 0, end = height.length - 1, prev = height[height.length - 1];
        while (start < end) {
            sum += (height[end] - height[start]) * (height[end] - height[start]);
            if (prev == height[end]) {
                end--;
                prev = height[start];
            } else {
                start++;
                prev = height[end];
            }
        }
        return sum;
    }

    List<List<Integer>> buyBooks(int[] books) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;

        for (int i = 0; i < books.length; i++) {
            books[Math.abs(books[i]) - 1] = -books[Math.abs(books[i]) - 1];
            List<Integer> list = new ArrayList<>();
            while (start < books.length && books[start] < 0) {
                list.add(++start);
            }
            result.add(list);
        }
        return result;
    }

    public int maximumQualitySum(int[] packets, int channels) {
        // write your code here
        Arrays.sort(packets);
        int sum = 0;
        for (int i = 0; i < channels - 1; i++) {
            sum += packets[packets.length - 1 - i];
        }
        int median = (packets.length - channels) / 2;
        if ((packets.length - channels + 1) % 2 == 1) {
            return sum + packets[median];
        }
        return sum + (packets[median] + packets[median + 1] + 1) / 2;
    }

    String nextCode(String code, int k) {
        List<String> nums = new ArrayList<>();
        for (int i = 0; i < code.length(); i +=k) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + k; j++) {
                if (j >= code.length()) {
                    sb.append(0);
                } else {
                    sb.append(code.charAt(j));
                }
            }
            if (!(!nums.isEmpty() && nums.getLast().equals(sb.toString()))) {
                nums.add(sb.toString());
            }
        }
        int num = 0;
        if (nums.size() == 1) {
            num = Integer.parseInt(nums.getFirst()) + 1;
        } else {
            boolean large = false;
            for (int i = 1; i < nums.size(); i++) {
                if (nums.get(i).compareTo(nums.getFirst()) > 0) {
                    large = true;
                }
            }
            if (large) {
                num = Integer.parseInt(nums.getLast()) + 1;
            } else {
                num = Integer.parseInt(nums.getFirst());
            }
        }
        return num == Math.pow(10, k) ? generateNext(Integer.toString(num / 10), code.length() + 1) :generateNext(Integer.toString(num), code.length());
    }

    private String generateNext(String i, int length) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < length; j++) {
            sb.append(i.charAt(j % i.length()));
        }
        return sb.toString();
    }

    public int parcelEfficiency(int[] parcels) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int start = 0, end = parcels.length - 1;

        while (start <= end) {
            pq.add(parcels[start]);
            if (start != end) {
                pq.add(parcels[end]);
                pq.poll();
            }
            start++;
            end--;
        }
        int result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }
        return result;
    }

    public int getMinimumCost(int[] a, int[] b, int m) {
        // write your code here
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a2 -> a2[0]));
        for (int i = 0; i < a.length; i++) {
            pq.add(new int[]{a[i], b[i]});
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            int[] temp = pq.poll();
            result += temp[0];
            pq.offer(new int[]{temp[0] + temp[1], temp[1]});
        }
        return result;
    }

    public int getMaxRacers(int[] speed, int k) {
        // write your code here

            int n=speed.length;
            int[] array = new int[n];
            int idx=0;
            for(int a:speed){
                array[idx++]=a;
            }

            int[] freq = new int[n+1];
            int i=0;
            int maxFreq=0;
            int max=0;
            for(int j=0;j<n;j++){
                freq[array[j]]++;
                maxFreq=Math.max(maxFreq, freq[array[j]]);
                while(j-i+1-maxFreq>k){
                    freq[array[i]]--;
                    i++;
                }
                //max=Math.max(max,maxFreq);
            }
            return maxFreq;

    }

    public int parcelNum(int[] parcels) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int parcel: parcels) {
            map.put(parcel, map.getOrDefault(parcel, 0) + 1);
        }
        HashMap<Integer,Integer> map2 = new HashMap<>();
        int start = map.firstKey();
        while (start != map.lastKey()) {
            int next = map.higherKey(start);
            while (next != map.lastKey()) {
                map2.put(next + start, map2.getOrDefault(next + start, 0) + map.get(start) * map.get(next));
                next = map.higherKey(next);
            }
            map2.put(next + start, map2.getOrDefault(next + start, 0) + map.get(start) * map.get(next));
            start = map.higherKey(start);
        }
        for (int key: map2.keySet()) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + map2.get(key));
            } else {
                map.put(key, map2.get(key));
            }
        }
        int result = 0;
        for (int key: map.keySet()) {
            result = Math.max(result, map.get(key));
        }
        return result;
    }

    public static void main(String[] args) {
        AmazonOA a = new AmazonOA();
        System.out.println(a.maxMoney(new int[][]{{1,4,2}, {6,6,5}, {7,7,7},{9,10,1}}, 5));
        System.out.println(a.caloriesBurn(new int[]{5,2,5}));
        for (List<Integer> l:a.buyBooks(new int[]{3,1,2,4})) {
            for (Integer i:l) {
                System.out.print(i);
            }
            System.out.println();
        }
        System.out.println(a.nextCode("10890", 2));
        System.out.println(a.parcelEfficiency(new int[]{2,1,8,5,6,2,4}));
    }
}
