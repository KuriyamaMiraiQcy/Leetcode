import java.util.HashMap;

public class BullsandCows {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> count = new HashMap<>();
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                int num = count.getOrDefault(secret.charAt(i), 0);
                count.put(secret.charAt(i), num + 1);
            }
        }

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                if (count.containsKey(guess.charAt(i))) {
                    cows++;
                    int num = count.get(guess.charAt(i));
                    if (num == 1) {
                        count.remove(guess.charAt(i));
                    } else {
                        count.put(guess.charAt(i), num - 1);
                    }
                }
            }
        }

        return bulls + "A" +cows + "B";
    }

    //Use a little trick
    public String GetHint(String secret, String guess) {
        int[] freq= new int[10];
        int A=0, B=0;
        char[] a= secret.toCharArray(), b= guess.toCharArray();
        for (char c: a) freq[c-'0']++;
        for (int i=0; i<a.length; i++){
            if (--freq[b[i]-'0']>=0) B++;
            if (a[i]==b[i]) {
                A++;
                B--;
            }
        }
        return A+"A"+B+"B";
    }
}
