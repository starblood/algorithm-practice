package algorithms;

import algorithms.sort.QuickSort;
import algorithms.sort.SortTestUtil;

/** Binary Search 는 정렬된 배열을 기준으로 target 을 찾는 algorithm 이다. **/
public class BinarySearch {
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

    public static int binarySearch(int [] array, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return binarySearch(array, target, low, mid -1);
        } else {
            return binarySearch(array, target, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int [] samples = SortTestUtil.generateSampleData(100, 101);

        QuickSort.quickSort(samples);
        for (int i = 0; i < samples.length; i++) {
            System.out.println(samples[i]);
        }

        int found = binarySearch(samples, 100);
        int found2 = binarySearch(samples, 100, 0, samples.length - 1);
        System.out.println("found: " + found);
        System.out.println("found2: " + found2);
    }
}
