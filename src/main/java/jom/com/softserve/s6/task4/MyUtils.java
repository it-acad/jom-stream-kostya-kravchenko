package jom.com.softserve.s6.task4;

import java.io.IOException;

public class MyUtils {
    public static String readFile(String filename) {
        try {
            String bData = java.nio.file.Files.readString(java.nio.file.Paths.get(filename)).replaceAll("[\\[\\], ]", "");
            return java.util.stream.IntStream.range(0, bData.length() / 7)
                    .mapToObj(i -> bData.substring(i * 7, (i + 1) * 7))
                    .map(binary -> String.valueOf((char) Integer.parseInt(binary, 2)))
                    .collect(java.util.stream.Collectors.joining());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
