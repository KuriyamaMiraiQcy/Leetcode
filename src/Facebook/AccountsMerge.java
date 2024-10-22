package Facebook;

import java.util.*;

public class AccountsMerge {
    int[] parent;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parent = new int[accounts.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                if (map.containsKey(accounts.get(i).get(j))) {
                    union(i, map.get(accounts.get(i).get(j)));
                } else {
                    map.put(accounts.get(i).get(j), i);
                }
            }
        }
        HashMap<Integer, HashSet<String>> res = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            int p = find(i);
            HashSet<String> list = res.getOrDefault(p, new HashSet<>());

            for (int j = 1; j < accounts.get(i).size(); j++) {
                list.add(accounts.get(i).get(j));
            }

            res.put(p, list);
        }

        List<List<String>> resList = new ArrayList<>();
        for (Integer s: res.keySet()) {
            HashSet<String> tmp = res.get(s);
            ArrayList<String> list = new ArrayList<>();
            for (String string: tmp) {
                list.add(string);
            }
            Collections.sort(list);
            list.addFirst(accounts.get(s).get(0));
            resList.add(list);
        }
        return resList;
    }

    public void union(int index1, int index2) {
        parent[find(index2)] = find(index1);
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}
