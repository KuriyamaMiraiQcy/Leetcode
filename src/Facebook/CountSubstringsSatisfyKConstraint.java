package Facebook;

public class CountSubstringsSatisfyKConstraint {
    public int countKConstraintSubstrings(String s, int k) {
        int start = 0, end = 0, sum = 0;
        int[] counts = new int[2];

        while (end < s.length()) {
            counts[s.charAt(end++) - '0']++;
            while (counts[0] > k && counts[1] > k) {
                counts[s.charAt(start++) - '0']--;
            }
            sum += end - start;
        }
        return sum;
    }
}
