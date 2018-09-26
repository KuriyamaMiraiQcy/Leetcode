import java.util.*;

//  ["02 Feb 2018", "03 Oct 2018"]
public class date {
    public  List<String> sortDates(List<String> dates) {
        // Write your code here
        HashMap<String, Integer>  map = new HashMap<String, Integer>();
        // enter month here
        map.put("Jan",1);
        map.put("Feb",2);
        map.put("Mar",3);
        map.put("Apr",4);
        map.put("Oct",10);
        map.put("Jun",6);
        map.put("May",5);
        map.put("July",7);
        map.put("Aug",8);
        map.put("Sep",9);
        map.put("Nov",11);
        map.put("Dec",12);
        Collections.sort(dates, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] a = o1.split(" ");
                String[] b = o2.split(" ");
                if (a[2].equals(b[2])){
                    if (a[1].equals(b[1])){
                        return Integer.valueOf(a[0]) - Integer.valueOf(b[0]);
                    }
                    else
                        return map.get(a[1]) - map.get(b[1]);

                }
                else
                    return Integer.valueOf(a[2]) - Integer.valueOf(b[2]);
            }
        });

        return dates;
    }
}
