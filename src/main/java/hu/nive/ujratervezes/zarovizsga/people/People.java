package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {

    public static final String CRITERION = "Male";

    public int getNumberOfMales(String path) {
        int result = 0;
        Path file = Path.of(path);
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.split(",")[4].equals(CRITERION)) {
                    result++;
                }
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
        return result;
    }

}
