package special_tasks2.task3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static final List<String> stringsIO = new ArrayList<>();
    public static final List<String> stringsNIO = new ArrayList<>();
    public static final List<LocalDate> resultIO = new ArrayList<>();
    public static final List<LocalDate> resultNIO = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String sourceFilePath = "src/main/java/special_tasks2/task3/dates.txt";
        String outputFilePathIO = "src/main/java/special_tasks2/task3/selected dates IO.txt";
        String outputFilePathNIO = "src/main/java/special_tasks2/task3/selected dates NIO.txt";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-uuuu");

        readIOToList(sourceFilePath);
        writeIOToFile(dateTimeFormatter, outputFilePathIO);

        readNIOToList(sourceFilePath);
        writeNIOToFile(dateTimeFormatter, outputFilePathNIO);
    }

    public static void readIOToList(String sourceFilePath) throws IOException {
        File file = new File(sourceFilePath);

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

    public static void readNIOToList(String sourceFilePath) throws IOException {
        Path path = Paths.get(sourceFilePath);

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
        for (String s : stringsIO) {
            try {
                resultIO.add(LocalDate.parse(s, formatter));
            } catch (Exception ignored) {
            }
        }

        resultIO.sort(Comparator.naturalOrder());

        File file = new File(outputFilePath);

        if (!file.exists()) {
            file.createNewFile();
        }

        try (PrintWriter printWriter = new PrintWriter(file)) {
            resultIO.forEach(localDate -> printWriter.println(localDate.format(formatter)));
        }
    }

    public static void writeNIOToFile(DateTimeFormatter formatter, String outputFilePath) throws IOException {
        for (String s : stringsNIO) {
            try {
                resultNIO.add(LocalDate.parse(s, formatter));
            } catch (Exception ignored) {
            }
        }

        resultNIO.sort(Comparator.naturalOrder());

        Path path = Paths.get(outputFilePath);

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            resultNIO.forEach(localDate-> {
                try {
                    writer.write(localDate.format(formatter) + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
