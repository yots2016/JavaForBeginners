package special_tasks.task3;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        List<String> stringsList = new ArrayList<>();
        stringsList.add("This new text \n");
        stringsList.add("This new text2 \n");
        stringsList.add("This new text3 \n");
        stringsList.add("This new text4 \n");

        String fileNameIO = "src/main/java/special_tasks/task3/textIO.txt";
        String fileNameNIO = "src/main/java/special_tasks/task3/textNIO.txt";

        workIOWithFile(fileNameIO, stringsList);
        workNIOWithFile(fileNameNIO, stringsList);
    }

    public static void workIOWithFile(String fileName, List<String> stringsList) throws IOException {
        writeIOToFile(fileName, stringsList);
        System.out.println(readIOToListIO(fileName));
    }

    public static void writeIOToFile(String fileName, List<String> stringsList) throws IOException {
        File file = new File(fileName);

            if (!file.exists()) {
                file.createNewFile();
            }

            try (PrintWriter printWriter = new PrintWriter(file.getAbsoluteFile())) {
                stringsList.forEach(printWriter::print);
            }
    }

    public static List<String> readIOToListIO(String fileName) throws IOException {
        File file = new File(fileName);
        List<String> stringsList = new ArrayList<>();


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

        return stringsList;
    }

    public static void workNIOWithFile(String fileName, List<String> stringsList) throws IOException {
        writeNIOToFile(fileName, stringsList);
        System.out.println(readNIOToList(fileName));
    }

    private static void writeNIOToFile(String fileName, List<String> stringsList) throws IOException {
        Path path = Paths.get(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            stringsList.forEach(str -> {
                try {
                    writer.write(str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static List<String> readNIOToList(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        List<String> stringsList = new ArrayList<>();

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
        }

        return stringsList;
    }
}