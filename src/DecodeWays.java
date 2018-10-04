public class DecodeWays {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] memory = new int[s.length() + 1];
        memory[0] = 1;
        memory[1] = 1;

        for (int i = 2; i < memory.length; i++) {
            int prev = memory[i - 1];
            int prev2 = memory[i - 2];

            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) == '0' || Integer.parseInt(s.substring(i - 2, i)) > 26) {
                    return 0;
                } else {
                    memory[i] = memory[i - 2];
                }
            } else {
                if (Integer.parseInt(s.substring(i - 2, i)) > 26 || s.charAt(i - 2) == '0') {
                    memory[i] = memory[i - 1];
                } else {
                    memory[i] = memory[i - 1] + memory[i - 2];
                }
            }
        }

        return memory[s.length()];
    }

    public static void main(String[] args) {
        DecodeWays a = new DecodeWays();
        a.numDecodings("1029");
    }
}
