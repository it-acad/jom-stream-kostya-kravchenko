package jom.com.softserve.s6.task5;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public class MyUtils {

    public Stream<String> nameList(Map<String, Stream<String>> map) {
        if (Objects.isNull(map)) {
            throw new NullPointerException();
        }
        return map.values().stream()   // Stream<Stream<String>>
                .flatMap(Function.identity())  // Flatten to Stream<String>
                .filter(Objects::nonNull)   // Filter out nulls
                .map(name -> name.replaceAll("\\s+", ""))          // Trim leading/trailing spaces
                .filter(name -> !name.isEmpty())  // Filter out empty strings
                .map(String::toLowerCase)   // Normalize case for uniqueness
                .distinct()                 // Remove duplicates
                .sorted()                   // Sort alphabetically
                .map(name -> Character.toUpperCase(name.charAt(0)) + name.substring(1));
    }
}
