public class WorldCup {
    public double probability(int[] match) {
        int length = match.length;
        int max = 0;
        int count = 1;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (match[i] + match[j] > max) {
                    max = match[i] + match[j];
                    count = 1;
                } else if (match[i] + match[j] == max) {
                    count += 1;
                }
            }
        }

        double result = (double)count / (double) (length * (length -1));
        return (Math.floor((double)count * 100 / (double) (length * (length -1) / 2)) /100.0);
    }

    public static void main(String[] args) {
        WorldCup a = new WorldCup();

        System.out.print(a.probability(new int[]{1,2,4,5}));
    }
}
