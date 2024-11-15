package Facebook;

public class FriendsAppropriateAges {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age : ages) {
            count[age]++;
        }

        int sum = 0;
        int[] prefix = new int[121];
        for (int i = 1; i < 121; i++) {
            prefix[i] += count[i] + prefix[i - 1];
        }

        for (int i = 15; i < 121; i++) {
            if (count[i] > 0) {
                int bound = i / 2 + 8;
                sum += count[i] * (prefix[i] - prefix[bound - 1] - 1);
            }
        }
        return sum;
    }
}
