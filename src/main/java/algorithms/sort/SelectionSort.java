package algorithms.sort;

public class SelectionSort {
    public static int [] selectionSort(int [] array) {
        int temp, least;
        for (int i = 0; i < array.length; i++) {
            least = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[least]) {
                    least = j;
                }
            }
            temp = array[i];
            array[i] = array[least];
            array[least] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int [] array = SortTestUtil.generateSampleData(100, 100);
        selectionSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
