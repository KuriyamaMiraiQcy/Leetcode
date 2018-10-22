package Uber;
public class TrapRainWater {
    //A little redundant
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int[] array = height.clone();
        int max = height[0];
        int prev = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] >= max) {
                set(array, i, prev, max);
                prev = i;
                max = height[i];
            }
        }

        max = height[height.length - 1];
        int last = height.length - 1;
        for (int i = height.length - 1; i >= prev; i--) {
            if (height[i] >= max) {
                setDes(array, i, last, max);
                last = i;
                max = height[i];
            }
        }

        int count = 0;
        for (int i = 0; i < height.length; i++) {
            count += array[i] - height[i];
        }

        return count;
    }

    private void set(int[] a, int i, int j, int max) {
        for (int k = j; k < i; k++) {
            a[k] = max;
        }
    }

    private void setDes(int[] a, int i, int j, int max) {
        for (int k = i + 1; k <= j ; k++) {
            a[k] = max;
        }
    }

    public int Trap(int[] A){
        int a=0;
        int b=A.length-1;
        int max=0;
        int leftmax=0;
        int rightmax=0;
        while(a<=b){
            leftmax=Math.max(leftmax,A[a]);
            rightmax=Math.max(rightmax,A[b]);
            if(leftmax<rightmax){
                max+=(leftmax-A[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                a++;
            }
            else{
                max+=(rightmax-A[b]);
                b--;
            }
        }
        return max;
    }
}
