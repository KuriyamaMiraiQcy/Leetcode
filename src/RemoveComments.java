import java.nio.Buffer;
import java.util.LinkedList;
import java.util.List;

public class RemoveComments {
    public String removeComments(List<String> source) {
        String result = new String();
        StringBuffer buf = new StringBuffer();
        boolean flag = false;
        
        for (String line:source) {
            int i = 0;
            int stop = line.length();
            int start = 0;

            for (i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '/') {
                    if (line.charAt(i + 1) == '/') {
                        stop = i;
                        break;
                    }
                    if (line.charAt(i + 1) == '*') {
                        stop = i;
                        i += 1;
                        flag = true;
                        String temp = line.substring(start, stop);
                        if (!temp.isEmpty()) {
                            result += temp;
                        }

                    }
                } else if (line.charAt(i) == '*') {
                    if (line.charAt(i + 1) == '/') {
                        i += 1;
                        start = i + 1;
                        buf.setLength(0);
                        flag = false;

                    }
                } else {
                    if (flag) {
                        buf.append(line.charAt(i));
                    }
                }
            }
            if (flag) {
                buf.append("\n");
            }
            if (!flag) {
                if (start < stop) {
                    String temp = line.substring(start, stop);
                    if (!temp.isEmpty()) {
                        result += temp;
                    }
                }
                result += "\n";
            }
        }

        if (flag) {
            result += "/*" + buf.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveComments a = new RemoveComments();
        LinkedList<String> testSequence = new LinkedList<>();
        testSequence.add("a/*comment*/");
        testSequence.add("/*line");
        testSequence.add("more_commentb");
        System.out.print(a.removeComments(testSequence));
    }
}
