package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static algorithms.ListUtil.toStringList;

public class Permutation {

    public static void permutation(List<Integer> numbers,
                                   int takeCount,
                                   int depth,
                                   List<Boolean> used,
                                   List<Integer> current,
                                   List<List<Integer>> answers) {
        if (depth == takeCount) {
            answers.add(new ArrayList<>(current)); // deep copy needed
            return;
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (!used.get(i)) {
                current.add(numbers.get(i));
                used.set(i, true);
                System.out.println(toStringList(current));

                permutation(numbers, takeCount, depth + 1, used, current, answers);
                current.remove(current.size() - 1);
                System.out.println("backtrack: " + toStringList(current));
                used.set(i, false);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3);

        List<List<Integer>> answers = new ArrayList<>();
        List<Boolean> used = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            used.add(false);
        }

        permutation(numbers, 3, 0, used, new ArrayList<>(), answers);
        System.out.println(
                answers.stream().map(a -> toStringList(a))
                .collect(Collectors.joining(", ", "[", "]"))
        );
    }
}
