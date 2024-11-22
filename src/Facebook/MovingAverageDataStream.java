package Facebook;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageDataStream {
    class MovingAverage {
        Queue<Integer> q;
        int size, sum;
        public MovingAverage(int size) {
            q = new LinkedList<Integer>();
            this.size = size;
            sum = 0;
        }

        public double next(int val) {
            if (q.size() == size) {
                sum -= q.peek();
                q.poll();
            }
            sum += val;
            q.add(val);
            return sum / (double)q.size();
        }
    }
}
