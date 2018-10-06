package Sort;

public class QuickSort {
    int[] arr;

    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    public int sort(int start, int end) {
        int pivot = arr[end];
        int index = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                index++;
            }
        }
        arr[end] = arr[index];
        arr[index] = pivot;

        return index;
    }

    public void partition(int start, int end) {
        if (start < end) {
            int pivotIndex = sort(start, end);
            partition(start, pivotIndex - 1);
            partition(pivotIndex + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,6,8,3,4,0,2};
        QuickSort a = new QuickSort(test);
        a.partition(0,6);
        for (int n:
             test) {
            System.out.println(n);
        }
    }
}
