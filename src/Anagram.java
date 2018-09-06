import java.util.HashMap;

public class Anagram {
    class Solution {
        public int[] anagramMappings(int[] A, int[] B) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < B.length; i += 1) {
                map.put(B[i], i);
            }


            int[] mappingResults = new int[A.length];

            for (int i = 0; i < A.length; i++) {
                mappingResults[i] = map.get(A[i]);
            }

            return mappingResults;
        }
    }
}
