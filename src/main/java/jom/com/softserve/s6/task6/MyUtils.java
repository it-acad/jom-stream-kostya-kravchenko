package jom.com.softserve.s6.task6;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class MyUtils {

    public static Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
        if (list == null) {
            throw new NullPointerException("Input stream cannot be null");
        }
        return list.stream()
                .flatMap(Function.identity())
                .filter(Objects::nonNull)
                .map(phone -> phone.replaceAll("\\D+", ""))
                .filter(phone -> !phone.isEmpty())
                .collect(groupingBy(
                        phone -> {
                            if (phone.length() < 7) {
                                return "err";
                            }
                            return phone.matches("\\d{10,}") ? phone.substring(0, 3) : "loc";
                        },
                        HashMap::new,
                        mapping(phone -> phone.matches("\\d{10,}") ? phone.substring(3) : phone, toSet())
                )).entrySet()
                .stream()
                .collect(toMap(Map.Entry::getKey, entry -> entry.getValue().stream().sorted()));
    }

    public static void main(String[] args) {
        List<Stream<String>> list = Arrays.asList(
                Stream.of("093 987 65 43", "(050)1234567", "12-345"),
                Stream.of("067-21-436-57", "050-2345678", "0939182736", "224-19-28"),
                Stream.of("(093)-11-22-334", "044 435-62-18", "721-73-45")
        );

        Map<String, Stream<String>> result = phoneNumbers(list);
        result.forEach((key, value) -> {
            System.out.println(key + "=" + value.collect(Collectors.toList()));
        });
    }
}
