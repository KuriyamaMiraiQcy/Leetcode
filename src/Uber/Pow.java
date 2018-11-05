package Uber;

public class Pow {
    public double myPow(double x, int n) {
        int exp = 0;
        if (n < 0) {
            exp = -n;
        } else {
            exp = n;
        }

        double mul = 1;
        for (int i = 0; i < exp; i++) {
            mul *= x;
        }

        if (n < 0) {
            return 1 / mul;
        }
        return mul;
    }

    //fast power solution
    public double MyPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }

    public double mypow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (n < 0) {
            return 1 / x * mypow(1 / x, -(n + 1));
        } else {
            if (n % 2 != 0) {
                return x * mypow(x * x, n / 2);
            } else {
                return mypow(x * x, n / 2);
            }
        }
    }
}
