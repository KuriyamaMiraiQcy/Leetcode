package Uber;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class RandomizedSet {
    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = map.containsKey(val);
        if (!res) {
            map.put(val, map.size());
            list.add(val);
        }
        return !res;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean res = map.containsKey(val);
        if (res) {
            int index = map.get(val);
            map.remove(val);
            if (index == list.size() - 1) {
                list.remove(list.size() - 1);
                return res;
            }
            int last = list.get(list.size() - 1);
            list.set(index, last);
            list.remove(list.size() - 1);
            map.put(last, index);
        }
        return res;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet a= new RandomizedSet();
        a.insert(1);
        a.remove(2);
        a.insert(2);
        a.getRandom();
        a.remove(1);
        a.insert(2);
        a.getRandom();
    }
}
