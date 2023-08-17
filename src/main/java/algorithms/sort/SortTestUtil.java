package algorithms.sort;

import java.util.Random;

public class SortTestUtil {
    public static int [] generateSampleData(int count, int upperBound) {
        int [] array = new int[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            array[i] = random.nextInt(upperBound);
        }
        return array;
    }
}
