package jom.com.softserve.s6.task7;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class MyUtils {

    public static Stream<Integer> duplicateElements(Stream<Integer> stream) {
        if (stream == null) {
            throw new NullPointerException("Input stream cannot be null");
        }
        return stream.filter(Objects::nonNull)
                .collect(groupingBy(identity(), counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .sorted();
    }
}
