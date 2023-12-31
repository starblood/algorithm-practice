package algorithms.sort;

public class InsertionSort {
    public static int [] insertionSort(int [] array) {
        for (int i = 1; i < array.length; i++) {
            int target = array[i];
            int j = i - 1;

            // 타겟이 이전 원소보다 크기 전 까지 반복
            while (j >= 0 && array[j] > target) {
                array[j + 1] = array[j]; // 이전 원소를 한 칸씩 뒤로 미룬다.
                j--;
            }
            /*
             * 위 반복문에서 탈출 하는 경우 앞의 원소가 타겟보다 작다는 의미이므로
             * 타겟 원소는 j번째 원소 뒤에 와야한다.
             * 그러므로 타겟은 j + 1 에 위치하게 된다.
             */
            array[j + 1] = target;
        }
        return array;
    }

    public static void main(String[] args) {
        int [] sample = SortTestUtil.generateSampleData(100, 100);
        insertionSort(sample);

        for (int i = 0; i < sample.length; i++) {
            System.out.println(sample[i]);
        }
    }
}
