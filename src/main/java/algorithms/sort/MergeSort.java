package algorithms.sort;

public class MergeSort {
    public static void merge(int [] array, int left, int mid, int right) {
        int leftArrayIndex = left; // i: 정렬된 왼쪽 리스트에 대한 인덱스
        int rightArrayIndex = mid + 1; // j: 정렬된 오른쪽 리스트에 대한 인덱스
        int sortedArrayIndex = left; // k: 정렬될 리스트에 대한 인덱스
        int [] sorted = new int[array.length];

        while (leftArrayIndex <= mid && rightArrayIndex <= right) {
            if (array[leftArrayIndex] <= array[rightArrayIndex]) {
                sorted[sortedArrayIndex] = array[leftArrayIndex++];
            } else {
                sorted[sortedArrayIndex] = array[rightArrayIndex++];
            }
            sortedArrayIndex++;
        }
        if (leftArrayIndex > mid) {
            for (int i = rightArrayIndex; i <= right; i++) {
                sorted[sortedArrayIndex++] = array[i];
            }
        } else {
            for (int i = leftArrayIndex; i <= mid; i++) {
                sorted[sortedArrayIndex++] = array[i];
            }
        }
        for (int i = left; i <= right; i++) {
            array[i] = sorted[i];
        }
    }

    public static int [] mergeSort(int [] array) {
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    public static void mergeSort(int [] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }


    public static void main(String[] args) {
        int [] array = SortTestUtil.generateSampleData(100, 1000);

        mergeSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
