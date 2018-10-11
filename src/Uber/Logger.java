import java.util.*;

public class Logger {
    HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.keySet().contains(message)) {
            map.put(message, timestamp);
            return true;
        } else {
            int prev = map.get(message);
            if (prev + 10 <= timestamp) {
                map.put(message, timestamp);
                return true;
            }
        }
        return false;
    }

    //memory free
    PriorityQueue<Log> recentLogs;
    Set<String> recentMessages;

    /** Initialize your data structure here. */
    public Logger(int a) {
        recentLogs = new PriorityQueue<Log>(10, new Comparator<Log>() {
            public int compare(Log l1, Log l2) {
                return l1.timestamp - l2.timestamp;
            }
        });

        recentMessages = new HashSet<String>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean ShouldPrintMessage(int timestamp, String message) {
        while (recentLogs.size() > 0)   {
            Log log = recentLogs.peek();
            // discard the logs older than 10 minutes
            if (timestamp - log.timestamp >= 10) {
                recentLogs.poll();
                recentMessages.remove(log.message);
            } else
                break;
        }
        boolean res = !recentMessages.contains(message);
        if (res) {
            recentLogs.add(new Log(timestamp, message));
            recentMessages.add(message);
        }
        return res;
    }
}
class Log {
    int timestamp;
    String message;
    public Log(int aTimestamp, String aMessage) {
        timestamp = aTimestamp;
        message = aMessage;
    }
}
