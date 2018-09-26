public class PressAforCapslock {
    public String handle(String message) {
        String res = new String();
        int caps = 0;

        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == 'a' || message.charAt(i) == 'A') {
                caps = 1 - caps;
            } else {
                if (caps == 1) {
                    res = res.concat(Character.toString(message.charAt(i)).toUpperCase());
                } else {
                    res = res.concat(Character.toString(message.charAt(i)));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        PressAforCapslock a = new PressAforCapslock();
        System.out.println(a.handle("My keyboad is broken!"));
        System.out.println(a.handle("\"Baa, Baa!\" said the sheep"));
    }
}
