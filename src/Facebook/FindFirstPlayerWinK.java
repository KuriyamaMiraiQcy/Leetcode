package Facebook;

public class FindFirstPlayerWinK {
    public int findWinningPlayer(int[] skills, int k) {
        int count = 0;
        int index = 0;
        for (int i = 1; i < skills.length; i++) {
            if (skills[i] < skills[index]) {
                count++;
                if (count == k) {
                    return index;
                }
            } else {
                count = 1;
                index = i;
            }
        }
        return index;
    }
}
