package jom.com.softserve.s6.task3;

import java.io.IOException;

public class MyUtils {

    public static void writeFile(String filename, String text) {
        try {
            String output = text.chars()
                    .mapToObj(c -> "%7s".formatted(Integer.toBinaryString(c)).replace(' ', '0'))
                    .collect(java.util.stream.Collectors.joining());
            java.nio.file.Files.write(java.nio.file.Paths.get(filename), output.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        writeFile("data1.txt", "Hello!");
    }

}
