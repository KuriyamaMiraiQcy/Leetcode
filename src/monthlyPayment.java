public class monthlyPayment {
    public String monthlyPayment(String input) {
        String[] values = input.split("~");
        if (values.length != 4) {
            return "";
        }
        double loanAmount = Double.parseDouble(values[0]) - Double.parseDouble(values[3]);
        double monthlyInterestRate = Double.parseDouble(values[2]) / 1200;
        double month = Double.parseDouble(values[1]) * 12;

        double monthlyPayment = loanAmount * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -month));
        String res = String.format("%.2f", monthlyPayment);
        monthlyPayment = Double.valueOf(res);
        double totalPayment = monthlyPayment * month - loanAmount;
        res += "~" + "$" +(int)totalPayment;
        return "$" + res;
    }

    public static void main(String[] args) {
        monthlyPayment a = new monthlyPayment();
        a.monthlyPayment("25000~10~6~0");
    }
}
