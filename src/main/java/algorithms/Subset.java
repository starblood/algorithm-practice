package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static algorithms.ListUtil.toStringList;

public class Subset {
    private static void dfs(List<Integer> numbers, List<List<Integer>> result, List<Integer> temp, int index) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < numbers.size(); i++) {
            temp.add(numbers.get(i));
            // backtrack
            dfs(numbers, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static List<List<Integer>> subsets(List<Integer> numbers) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(numbers, result, new ArrayList<>(), 0);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = subsets(Arrays.asList(1, 2, 3));
        System.out.println(result.stream()
                .map(r -> toStringList(r))
                .collect(Collectors.joining(", ", "[", "]"))
        );
    }
}
