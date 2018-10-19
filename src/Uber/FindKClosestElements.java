package Uber;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements {
    //Binary Search
    public List<Integer> FindClosestElements(int[] arr, int k, int x) {
        int lo = 0, hi = arr.length - k;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (x - arr[mid] > arr[mid+k] - x)
                lo = mid + 1;
            else
                hi = mid;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = lo; i < lo + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int min = 0;
        int start = 0;
        int end = k - 1;
        for (int i = 0; i < k; i++) {
            min += Math.abs(arr[i] - x);
        }
        int sum = min;
        for (int i = 0; i < arr.length - k; i++) {
            sum -= Math.abs(arr[i] - x);
            sum += Math.abs(arr[i + k] - x);

            if (sum < min) {
                min = sum;
                start = i + 1;
                end = i + k;
            }

        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }

        return result;
    }



    public static void main(String[] args) {
        FindKClosestElements a = new FindKClosestElements();
        int[] test = new int[]{1,2,3,4,5};
        a.findClosestElements(test, 4,3);
        System.out.println(Arrays.binarySearch(test,10));
    }
}
