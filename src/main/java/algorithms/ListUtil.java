package algorithms;

import java.util.List;
import java.util.stream.Collectors;

public class ListUtil {
    public static String toStringList(List<Integer> list) {
        return list.stream().map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
