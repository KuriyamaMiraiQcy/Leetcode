package Uber;

public class Sqrt {
    public int mySqrt(int x) {
        if (x==0)
            return 0;
        if (x>0 && x<4)
            return 1;
        int left = 1, right = x/2;
        while (left < right) {
            int mid = (left + right)/2;
            if (mid <= x/mid) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left==2?left:left - 1;
    }
}
