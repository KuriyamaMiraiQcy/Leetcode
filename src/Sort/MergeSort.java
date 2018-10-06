package Sort;
public class MergeSort {
    int[] arr;
    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int[] left = new int[end - start + 1];

        int leftIndex = start;
        int rightIndex = mid + 1;

        for (int i = 0; i <= end - start; i++) {
            if (leftIndex > mid) {
                left[i] = arr[rightIndex];
                rightIndex++;
            } else if (rightIndex > end) {
                left[i] = arr[leftIndex];
                leftIndex++;
            } else if (arr[leftIndex] <= arr[rightIndex]) {
                left[i] = arr[leftIndex];
                leftIndex++;
            } else {
                left[i] = arr[rightIndex];
                rightIndex++;
            }
        }

        for (int i = start; i <= end; i++) {
            arr[i] = left[i - start];
        }
    }

    private void sort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,6,8,1,3,4,9,7};
        MergeSort a = new MergeSort(test);
        a.sort(test, 0, 6);
        for (int n:test
             ) {
            System.out.println(n);
        }
    }
}