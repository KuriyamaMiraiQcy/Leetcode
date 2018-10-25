public class ReverseWordsinaStringII {
    //in place
    public void reverseWords(char[] str) {
        int start = 0;
        int end = str.length - 1;

        swap(start, end, str);

        start = 0;
        end = 0;
        while (end < str.length) {
            while (end < str.length && str[end] != ' ') {
                end++;
            }
            swap(start, end - 1, str);
            end++;
            start = end;

        }
    }

    private void swap(int start, int end, char[] str) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
