package Facebook;

public class MaximumEnergyBoostTwoDrinks {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        long prevA = 0, prevB = 0;

        for (int i = 0; i < energyDrinkA.length; i++) {
            long tmp = prevA;
            prevA = Math.max(energyDrinkA[i] + prevA, prevB);
            prevB = Math.max(energyDrinkB[i] + prevB, tmp);
        }

        return Math.max(prevA, prevB);
    }
}
