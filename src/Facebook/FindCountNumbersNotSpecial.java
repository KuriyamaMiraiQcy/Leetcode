package Facebook;

public class FindCountNumbersNotSpecial {
    public int nonSpecialCount(int l, int r) {
        int start = (int) Math.ceil(Math.sqrt(l));
        int end = (int) Math.floor(Math.sqrt(r));

        int count = 0;
        for (int i = Math.max(2, start); i <= end; i++) {
            if (isPrime(i)) {
                ++count;
            }
        }
        return r - l - count + 1;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
