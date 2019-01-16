public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder(S);
        int count = 0;

        for (int i = S.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) != '-') {
                count++;
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
                if (count % K == 0) {
                    if (i > 0) {
                        sb.insert(i, '-');
                    }

                }
            } else {
                sb.setCharAt(i, ' ');
            }

        }

        int start = 0;
        while (start < sb.length()) {
            if (sb.charAt(start) == '-' || sb.charAt(start) == ' ') {
                sb.setCharAt(start, ' ');
                start++;
            } else {
                break;
            }
        }

        return sb.toString().replace(" ","");
    }

    //clear solution
    public String LicenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-')
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
        return sb.reverse().toString().toUpperCase();
    }

    public static void main(String[] args) {
        LicenseKeyFormatting a = new LicenseKeyFormatting();
        System.out.println(a.licenseKeyFormatting("--a-a-a-a--",2));
    }
}
