import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }
}
