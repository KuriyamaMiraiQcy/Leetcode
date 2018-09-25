import java.util.HashMap;

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
}
