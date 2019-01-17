public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        S = handleString(S);
        T = handleString(T);
        return S.equals(T);
    }

    private String handleString(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                sb.append(s.charAt(i));
            } else {
                if (sb.length() != 0) {
                    sb.setLength(sb.length() - 1);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        BackspaceStringCompare a = new BackspaceStringCompare();
        System.out.println(a.backspaceCompare("ab#c", "ad#c"));
    }
}
