public class Walmart {
    public static int MoveElement(int[] elements) {
        int start = 0;
        int count = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] % 2 == 0) {
                count+= 1;
                swap(i, start, elements);
                start++;
            }
        }
        return count;
    }

    public static int numOfMoves(int[] elements) {
        int evenCount = 0;
        int oddCount = 0;
        int evenMoves = 0;
        int oddMoves = 0;

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] % 2 ==0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] % 2 == 0 && i >= evenCount) {
                evenMoves++;
            }
            if (elements[i] % 2 == 1 && i < elements.length - oddCount) {
                oddMoves++;
            }
        }
        return Math.min(evenMoves, oddMoves);
    }

    private static void swap(int i, int j, int[] elements) {
        int temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{2,2,8,4,36};
        System.out.println(numOfMoves(testArray));
//        System.out.println(Walmart.MoveElement(testArray));
//        for (int i = 0; i < testArray.length; i++) {
//            System.out.println(testArray[i]);
//        }


    }
}
