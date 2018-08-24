package special_tasks.task3;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static String text = "This new text \nThis new text2\nThis new text3\nThis new text4\n";
    private static String fileNameIO = "src/main/java/special_tasks/task3/textIO.txt";
    private static String fileNameNIO = "src/main/java/special_tasks/task3/textNIO.txt";


    public static void main(String[] args) throws IOException {
        workIOWithFile(fileNameIO, text);
        workNIOWithFile(fileNameNIO, text);
    }

    public static void workIOWithFile(String fileName, String text) throws IOException {
        List<String> stringsList = new ArrayList<>();
        writeIOToFile(fileName, text);
        readToListIO(fileName, stringsList);

        System.out.println(stringsList);
    }

    public static void writeIOToFile(String fileName, String text) {
        File file = new File(fileName);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            try (PrintWriter printWriter = new PrintWriter(file.getAbsoluteFile())) {
                printWriter.print(text);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static void readToListIO(String fileName, List<String> stringsList) throws IOException {
        File file = new File(fileName);

        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
            String currentLine;
            StringBuilder sb = new StringBuilder();

            while ((currentLine = bufferedReader.readLine()) != null) {
                stringsList.add(sb.append(currentLine).reverse().toString());
                sb.setLength(0);
            }
        }
    }

    public static void workNIOWithFile(String fileName, String text) throws FileNotFoundException {
        List<String> stringsList = new ArrayList<>();
        writeNIOToFile(fileName, text);
        readNIOToList(fileName, stringsList);

        System.out.println(stringsList);
    }

    private static void writeNIOToFile(String fileName, String text) {
        Path path = Paths.get(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readNIOToList(String fileName, List<String> stringsList) throws FileNotFoundException {
        Path path = Paths.get(fileName);

        if (!Files.exists(path)) {
            throw new FileNotFoundException(path.toString());
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String currentLine;

            StringBuilder sb = new StringBuilder();

            while ((currentLine = reader.readLine()) != null) {
                stringsList.add(sb.append(currentLine).reverse().toString());
                sb.setLength(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}