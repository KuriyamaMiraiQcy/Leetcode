public class CountPairsFormCompleteDay {
    public int countCompleteDayPairs(int[] hours) {
        int[] counts = new int[24];
        for (int hour : hours) {
            counts[hour % 24]++;
        }
        int res = 0;

        for (int hour : hours) {
            counts[hour % 24]--;
            res += counts[(24 - (hour % 24)) % 24];
        }
        return res;
    }
}
