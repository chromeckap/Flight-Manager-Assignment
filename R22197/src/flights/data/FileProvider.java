package flights.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileProvider {
    private static File getFile(String path) {
        return new File(path);
    }

    public static List<String> fileToStringLines(String path) {
        try {
            return Files.readAllLines(getFile(path).toPath());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}