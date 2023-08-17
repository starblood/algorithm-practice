package algorithms.sort;

public class BubbleSort {
    public static int [] bubbleSort(int [] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                int temp = array[i];
                if (temp < array[j]) {
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int [] samples = SortTestUtil.generateSampleData(100, 1000);

        bubbleSort(samples);
        for (int i = 0; i < samples.length; i++) {
            System.out.println(samples[i]);
        }
    }
}
