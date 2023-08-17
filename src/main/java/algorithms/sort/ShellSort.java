package algorithms.sort;

public class ShellSort {
    public static int [] insertionSort(int [] array, int first, int last, int gap) {
        for (int i = first + gap; i <= last; i = i + gap) {
            int target = array[i];
            int j = i - gap;
            while (j >= first && array[j] > target) {
                array[j + gap] = array[j];
                j = j - gap;
            }
            array[j + gap] = target;
        }
        return array;
    }

    public static int [] shellSort(int [] array) {
        for (int gap = array.length / 2; gap > 0; gap = gap / 2) {
            if (gap % 2 == 0) {
                gap++;
            }
            for (int i = 0; i < gap; i++) {
                insertionSort(array, i, array.length - 1, gap);
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int [] sample = SortTestUtil.generateSampleData(100, 100);
        shellSort(sample);
        for (int i = 0; i < sample.length; i++) {
            System.out.println(sample[i]);
        }
    }
}
