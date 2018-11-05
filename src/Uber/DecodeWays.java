package Uber;

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

    //bottom up dp
    public int NumDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

        return memo[0];
    }

    public static void main(String[] args) {
        DecodeWays a = new DecodeWays();
        a.numDecodings("1029");
    }
}
