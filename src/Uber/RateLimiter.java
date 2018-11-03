package Uber;
import java.util.*;

public class RateLimiter {
    Queue<Node> q = new ArrayDeque<>();
    HashMap<String,Integer> dict = new HashMap<>(); // ip, called Times.

    public boolean ipLimiter(double timestamp, String ip, int callTimes){
        while ( !q.isEmpty() && timestamp - q.peek().time >= 1){
            Node t = q.poll();
            dict.remove(t.ip);
        }
        if(!dict.containsKey(ip)){
            if(callTimes > 100){
                return false;
            }
            q.offer(new Node(timestamp, ip));
            dict.put(ip,callTimes);
            return true;
        }else{
            if(dict.get(ip) + callTimes <= 100){
                dict.put(ip, dict.get(ip) + callTimes);
                return true;
            }
        }
        return false;
    }

    private static class Node{
        double time;
        String ip;
        public Node(double t, String ip){
            this.time = t;
            this.ip = ip;
        }
    }
}
