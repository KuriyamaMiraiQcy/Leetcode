import java.util.*;

public class CSVformat {
    public String format(List<String> input) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<String[]> queue = new ArrayDeque<>();

        for (String str : input) {
            String[] array = str.split(",");
            queue.add(array);
            int length = array.length;
            for (int i = 0; i < length; i++) {
                if (map.keySet().contains(i)) {
                    int num = map.get(i);
                    if (array[length - 1 - i].length() > num) {
                        map.put(i, array[length - 1 - i].length());
                    }
                } else {
                    map.put(i, array[length - 1 - i].length());
                }
            }

        }

        int wordLength = map.keySet().size();
        String result = new String();

        while (queue.size() != 0) {
            String[] array = queue.pop();
            for (int i = 0; i < wordLength; i++) {
                int loc = wordLength - 1 - i;
                int maxLength = map.get(loc);
                if (array.length - loc - 1 < 0) {
                    for (int j = 0; j < maxLength; j++) {
                        result += " ";
                    }

                } else {
                    String str = array[array.length - loc - 1];
                    if (str.length() < maxLength) {
                        for (int j = 0; j < maxLength - str.length(); j++) {
                            result += " ";
                        }
                    }
                    result += str;
                }
                if (i != wordLength - 1) {
                    result += ", ";
                } else {
                    result += "\n";
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CSVformat a = new CSVformat();
        LinkedList<String> test = new LinkedList<>();
        test.add("name,id,city,job title,date of birth");
        test.add("accc,name,id,city,job title,date of birth");
        test.add("aaname,ssid,cddity,jowb title,datwe of birth,mkk,lllllsa");
        System.out.print(a.format(test));
    }
}
