import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class RussianDollEnvelopes {
    //dp with n2
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0
                || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            }
        });

        int[] memory = new int[envelopes.length];

        int max = 0;
        for (int i = memory.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < memory.length; j++) {
                int[] cur = envelopes[i];
                int[] next = envelopes[j];

                if (cur[0] < next[0] && cur[1] < next[1]) {
                    memory[i] = Math.max(memory[j] + 1, memory[i]);
                }
            }
            max = Math.max(max, memory[i]);
        }

        return max + 1;
    }

    //tricky solution wwith NlogN
    public int MaxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0
                || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            }
        });
        int dp[] = new int[envelopes.length];
        int len = 0;
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(index < 0)
                index = -(index + 1);
            dp[index] = envelope[1];
            if(index == len)
                len++;
        }
        return len;
    }

    public static void main(String[] args) {
        RussianDollEnvelopes a = new RussianDollEnvelopes();
        System.out.print(a.maxEnvelopes(new int[][]{{30,50},{12,2},{3,4},{12,15}}));
    }
}
