package Uber;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        int length = nums.length;
        boolean[] cur = new boolean[length + 1];
        for (int i = 0; i < length; i++) {
            if (nums[i] <= length && nums[i] > 0) {
                cur[nums[i]] = true;
            }
        }

        for (int i = 1; i < cur.length; i++) {
            if (!cur[i]) {
                return i;
            }
        }
        return length + 1;
    }

    //o(1) space
    public int FirstMissingPositive(int[] A) {
        int n=A.length;
        if(n==0)
            return 1;
        int k=partition(A)+1;
        int temp=0;
        int first_missing_Index=k;
        for(int i=0;i<k;i++){
            temp=Math.abs(A[i]);
            if(temp<=k)
                A[temp-1]=(A[temp-1]<0)?A[temp-1]:-A[temp-1];
        }
        for(int i=0;i<k;i++){
            if(A[i]>0){
                first_missing_Index=i;
                break;
            }
        }
        return first_missing_Index+1;
    }

    public int partition(int[] A){
        int n=A.length;
        int q=-1;
        for(int i=0;i<n;i++){
            if(A[i]>0){
                q++;
                swap(A,q,i);
            }
        }
        return q;
    }

    public void swap(int[] A, int i, int j){
        if(i!=j){
            A[i]^=A[j];
            A[j]^=A[i];
            A[i]^=A[j];
        }
    }
}
