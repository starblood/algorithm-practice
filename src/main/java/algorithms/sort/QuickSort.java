package algorithms.sort;

public class QuickSort {

    public static int partition(int [] array, int start, int end) {
        int left = start + 1;
        int right = end;
        int pivot = start;

        while (left <= right) {
            while (left <= end && array[left] <= array[pivot]) {
                left++;
            }
            while (right > start && array[right] >= array[pivot]) {
                right--;
            }
            if (left > right) {
                int temp = array[pivot];
                array[pivot] = array[right];
                array[right] = temp;
            } else {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        return right;
    }

    public static void quickSort(int [] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }
    }

    public static int [] quickSort(int [] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public static void main(String[] args) {
        int [] samples = SortTestUtil.generateSampleData(100, 1000);

        quickSort(samples);
        for (int i = 0; i < samples.length; i++) {
            System.out.println(samples[i]);
        }
    }
}
