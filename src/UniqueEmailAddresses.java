import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> mail = new HashSet<>();

        for (String s:emails) {
            String[] pair = s.split("@");
            pair[0] = pair[0].substring(0, pair[0].indexOf('+'));
            pair[0] = pair[0].replace(".", "");

            String email = pair[0] + pair[1];
            mail.add(email);
        }

        return mail.size();
    }

    //version without string in-function
    public int NumUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            boolean isBeforePlus = true;
            int idxOfAt = 0;
            for (int i = 0; i < email.length(); i++) {
                if (isBeforePlus && email.charAt(i) != '@') {
                    if (email.charAt(i) == '.') {
                        continue;
                    } else if (email.charAt(i) == '+') {
                        isBeforePlus = false;
                    } else {
                        sb.append(email.charAt(i));
                    }
                } else if (email.charAt(i) == '@') {
                    idxOfAt = i;
                    break;
                }
            }
            sb.append(email.substring(idxOfAt));
            set.add(sb.toString());
        }

        return set.size();
    }
}
