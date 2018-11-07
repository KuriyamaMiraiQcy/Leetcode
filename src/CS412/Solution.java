package CS412;
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int minSupport = 0;
        if (input.hasNextLine()) {
            minSupport = Integer.parseInt(input.nextLine());
        }
        String readLine;
        ArrayList<HashSet<String>> transactionList = new ArrayList<>();

        while (input.hasNextLine() && !( readLine = input.nextLine() ).equals( "" )){
            String[] values = readLine.split(" +");
            HashSet<String> set = new HashSet<>();
            for (String s:values) {
                set.add(s);
            }
            transactionList.add(set);
        }

        HashMap<HashSet<String>, Integer> supportCountMap = new HashMap<>();
        ArrayList<HashSet<String>> frequentList = findFrequentItemList(transactionList, supportCountMap, minSupport);

        HashMap<Integer, ArrayList<HashSet<String>>> map = new HashMap<>();
        map.put(1, frequentList);
        int k = 1;

        do {
            k++;
            ArrayList<HashSet<String>> candidateList = generateCandidates(map.get(k - 1));

            for (HashSet<String> transaction:transactionList) {
                ArrayList<HashSet<String>> candidate = subSet(transaction, candidateList);

                for (HashSet<String> set:candidate) {
                    supportCountMap.put(set, supportCountMap.getOrDefault(set, 0) + 1);
                }
            }

            ArrayList<HashSet<String>> next = getNextItemset(candidateList, supportCountMap, minSupport);
            map.put(k, next);
        } while (!map.get(k).isEmpty());


        TreeMap<Integer, ArrayList<HashSet<String>>> itemSets = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Integer, ArrayList<HashSet<String>>> entry:map.entrySet()) {
            ArrayList<HashSet<String>> itemsets = entry.getValue();
            String[] values = new String[itemsets.size()];

            for (int i = 0; i < itemsets.size(); i++) {
                HashSet<String> set = itemsets.get(i);
                int frequency = supportCountMap.get(set);
                if (!itemSets.containsKey(frequency)) {
                    ArrayList<HashSet<String>> lst = new ArrayList<>();
                    lst.add(set);
                    itemSets.put(frequency, lst);
                } else {
                    itemSets.get(frequency).add(set);
                }

            }
        }
        printFrequentPatterns(itemSets);
        printClosedPatterns(itemSets);
        printMaxPatterns(itemSets);
    }

    private static void printFrequentPatterns(TreeMap<Integer, ArrayList<HashSet<String>>> itemSets) {
        for (Integer n:itemSets.keySet()) {
            ArrayList<HashSet<String>> temp = itemSets.get(n);
            String[] values = new String[temp.size()];
            for (int i = 0; i < values.length; i++) {
                HashSet<String> set = temp.get(i);
                String[] array = new String[set.size()];
                int k = 0;
                for (String str:set) {
                    array[k] = str;
                    k++;
                }
                Arrays.sort(array);
                String s = array[0];
                for (k = 1; k < array.length; k++) {
                    s += " " + array[k];
                }
                values[i] = s;
            }
            Arrays.sort(values);

            for (int i = 0; i < values.length; i++) {
                System.out.println(n + " [" + values[i] + "]");
            }
        }
    }

    private static void printClosedPatterns(TreeMap<Integer, ArrayList<HashSet<String>>> itemSets) {
        TreeMap<Integer, ArrayList<HashSet<String>>> newSets = new TreeMap<>(Collections.reverseOrder());

        for (Integer n:itemSets.keySet()) {
            ArrayList<HashSet<String>> lst = itemSets.get(n);

            for (int i = 0; i < lst.size(); i++) {
                boolean closed = true;
                for (int j = 0; j < lst.size(); j++) {
                    if (i != j && lst.get(j).containsAll(lst.get(i))) {
                        closed = false;
                        break;
                    }
                }
                if (closed) {
                    if (!newSets.containsKey(n)) {
                        newSets.put(n, new ArrayList<>());
                    }
                    newSets.get(n).add(lst.get(i));
                }
            }
        }
        System.out.println();
        printFrequentPatterns(newSets);
    }

    private static void printMaxPatterns(TreeMap<Integer, ArrayList<HashSet<String>>> itemSets) {
        ArrayList<HashSet<String>> lst = new ArrayList<>();
        for (ArrayList<HashSet<String>> l:itemSets.values()) {
            lst.addAll(l);
        }

        TreeMap<Integer, ArrayList<HashSet<String>>> newSets = new TreeMap<>(Collections.reverseOrder());
        for (Integer n:itemSets.keySet()) {
            ArrayList<HashSet<String>> list = itemSets.get(n);

            for (int i = 0; i < list.size(); i++) {
                boolean max = true;
                for (HashSet<String> set:lst) {
                    if (!set.equals(list.get(i)) && set.containsAll(list.get(i))) {
                        max = false;
                        break;
                    }
                }

                if (max) {
                    if (!newSets.containsKey(n)) {
                        newSets.put(n, new ArrayList<>());
                    }
                    newSets.get(n).add(list.get(i));
                }
            }
        }
        System.out.println();
        printFrequentPatterns(newSets);
    }

    private static ArrayList<HashSet<String>> getNextItemset(ArrayList<HashSet<String>> candidateList, HashMap<HashSet<String>, Integer> supportCountMap, int minSupport) {
        ArrayList<HashSet<String>> res = new ArrayList<>();

        for (HashSet<String> candidate:candidateList) {
            if (supportCountMap.containsKey(candidate)) {
                if (supportCountMap.get(candidate) >= minSupport) {
                    res.add(candidate);
                }
            }
        }
        return res;
    }

    private static ArrayList<HashSet<String>> subSet(HashSet<String> transaction, ArrayList<HashSet<String>> candidateList) {
        ArrayList<HashSet<String>> candidate = new ArrayList<>();

        for (HashSet<String> set:candidateList) {
            if (transaction.containsAll(set)) {
                candidate.add(set);
            }
        }

        return candidate;
    }

    private static ArrayList<HashSet<String>> generateCandidates(ArrayList<HashSet<String>> prevList) {
        HashSet<HashSet<String>> result = new HashSet<>();
        for (int i = 0; i < prevList.size(); i++) {
            for (int j = i + 1; j < prevList.size(); j++) {
                HashSet<String> set = new HashSet<>(prevList.get(i));
                set.addAll(prevList.get(j));
                if (set.size() == prevList.get(i).size() + 1) {
                    result.add(set);
                }
            }
        }
        ArrayList<HashSet<String>> res = new ArrayList<>(result);
        return res;
    }

    private static ArrayList<HashSet<String>> findFrequentItemList(List<HashSet<String>> transactionList, HashMap<HashSet<String>, Integer> supportCountMap, int minSupport) {
        HashMap<String, Integer> map = new HashMap<>();

        for (HashSet<String> transaction:transactionList) {
            for (String s:transaction) {
                HashSet<String> temp = new HashSet<>();
                temp.add(s);
                supportCountMap.put(temp, supportCountMap.getOrDefault(temp, 0) + 1);

                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        ArrayList<HashSet<String>> frequentItemsetList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry:map.entrySet()) {
            if (entry.getValue() >= minSupport) {
                HashSet<String> itemSet = new HashSet<>();
                itemSet.add(entry.getKey());
                frequentItemsetList.add(itemSet);
            }
        }

        return frequentItemsetList;
    }
}
