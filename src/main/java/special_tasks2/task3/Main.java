package special_tasks2.task3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final List<String> stringsIO = new ArrayList<>();
    public static final List<String> stringsNIO = new ArrayList<>();

    public static void main(String[] args) {
        String sourceFilePath = "src/main/java/special_tasks2/task3/dates.txt";


    }

    public static void readIOToList(String inputFilePath) throws IOException {
        File file = new File(inputFilePath);

        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String currentLine;

            while ((currentLine = bufferedReader.readLine()) != null) {
                stringsIO.add(currentLine);
            }
        }

    }

    public static void readNIOToList(String inputFilePath) throws IOException {
        Path path = Paths.get(inputFilePath);

        if (!Files.exists(path)) {
            throw new FileNotFoundException(path.toString());
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                stringsNIO.add(currentLine);
            }
        }
    }

    public static void writeIOToFile(DateTimeFormatter formatter, String outputFilePath) throws IOException {
        




        File file = new File(outputFilePath);

        if (!file.exists()) {
            file.createNewFile();
        }

        try (PrintWriter printWriter = new PrintWriter(file)) {
            stringsIO.forEach(printWriter::print);
        }
    }
}
