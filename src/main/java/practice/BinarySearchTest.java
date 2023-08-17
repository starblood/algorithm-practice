package practice;

import algorithms.sort.QuickSort;
import algorithms.sort.SortTestUtil;

public class BinarySearchTest {
    public static int binarySearch(int [] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] samples = SortTestUtil.generateSampleData(100, 100);
        QuickSort.quickSort(samples);

        System.out.println(binarySearch(samples, 98));
    }
}
