package Uber;

import java.util.*;

public class GroupShiftedStrings {

    public List<List<String>> GroupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings.length == 0) {
            return res;
        }

        HashMap<String, List<String>> patterns = new HashMap<>();
        List<String> singleOne = new ArrayList<>();

        for (String s:strings) {
            if (s.length() == 1) {
                singleOne.add(s);
            } else {
                String str = "";
                for (int i = 1; i < s.length(); i++) {
                    str += (s.charAt(i) - s.charAt(i - 1) + 26) % 26 + ",";
                }
                if (!patterns.containsKey(str)) {
                    patterns.put(str, new ArrayList<>());
                }
                patterns.get(str).add(s);
            }
        }
        res.addAll(patterns.values());
        if (!singleOne.isEmpty()) {
            res.add(singleOne);
        }
        return res;
    }

    public List<List<String>> groupStrings(String[] strs) {
        //Create a hashmap. key is a number (the offset compared to its first char),
        //value is a list of strings which have the same offset.
        //For each string, convert it to char array
        //Then subtract its first character for every character
        //eg. "abc" -> "0,1,2,"        "am"->"0,12,"

        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs) {
            String key = "";
            char first = str.charAt(0);
            for(char c:str.toCharArray())
                key+=(c-first+26)%26+",";
            if(!map.containsKey(key))
                map.put(key,new ArrayList<String>());
            map.get(key).add(str);
        }
        for(String key:map.keySet())
            Collections.sort(map.get(key));
        return new ArrayList<List<String>>(map.values());
    }
}
