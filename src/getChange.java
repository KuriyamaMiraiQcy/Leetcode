import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class getChange {
    private String[] values = new String[]{"PENNY","NICKEL","DIME","QUARTER","HALF DOLLAR","ONE","TWO","FIVE","TEN","TWENTY","FIFTY","ONE HUNDRED"};
    private double[] cash = new double[]{0.01,0.05,0.10,0.25,0.50,1.00,2.00,5.00,10.00,20.00,50.00,100.00};

    public String getChange(String s) {

        String[] pair = s.split(";");
        if (pair.length != 2) {
            return "ERROR";
        }
        double[] nums = new double[]{Double.parseDouble(pair[0]), Double.parseDouble(pair[1])};
        if (nums[0] > nums[1]) {
            return "ERROR";
        }
        if (nums[0] == nums[1]) {
            return "ZERO";
        }

        LinkedList<String> res = new LinkedList<>();

        double change = nums[1] - nums[0];
        String decimalStr = String.format("%.2f", change);
        change = Double.valueOf(decimalStr);
        int largest = cash.length - 1;
        while (change != 0) {
            while (largest >0 && change - cash[largest] < 0) {
                largest--;
            }
            change -= cash[largest];
            decimalStr = String.format("%.2f", change);
            change = Double.valueOf(decimalStr);
            res.add(values[largest]);
        }
        Collections.sort(res);
        StringBuilder result = new StringBuilder();
        for (String str:res) {
            result.append(str);
            result.append(",");
        }
        result.setLength(result.length() - 1);
        return result.toString();
    }

    public static void main(String[] args) {
        getChange a = new getChange();
        System.out.println(a.getChange("15.94;16.00"));
    }
}
