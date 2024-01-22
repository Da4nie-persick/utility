import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class Filter {
    Scanner sc = new Scanner(System.in);
    private String intStr = "integers.txt";
    private String floStr = "floats.txt";
    private String striStr = "strings.txt";
    private String longStr = "longs.txt";

    private List<Integer> intList = new ArrayList<>();
    private List<Float> floList = new ArrayList<>();
    private List<String> strList = new ArrayList<>();
    private List<String> otherList = new ArrayList<>();

    private void readFileContents(String[] fileName) {
        try {
            for (String file : fileName) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();

                while (line != null) {
                    if (line.matches("[0-9]*")) {
                        intList.add(Integer.valueOf(line));
                    } else if (line.matches("-?\\d+(\\.\\d+)?")) {
                        floList.add(Float.valueOf(line));
                    } else {
                        strList.add(line);
                    }
                    line = reader.readLine();
                }
                reader.close();
            }
        } catch (IOException e) {
            System.err.println("Невозможно прочитать файл. Возможно, файл не находится в нужной директории.");
        }
    }

    public void distribution(String[] fileName, int answerPath, int answerPrefix) throws IOException {
        readFileContents(fileName);
        if (answerPath == 1) {
            System.out.println("Укажите путь: ");
            String path = sc.next();
            pathToFile(path, prefix(intStr, answerPrefix), intList, true);
            pathToFile(path, prefix(floStr, answerPrefix), floList, true);
            pathToFile(path, prefix(striStr, answerPrefix), strList, true);
        } else if (answerPath == 2) {
            writeToFile(prefix(intStr, answerPrefix), intList, true);
            writeToFile(prefix(floStr, answerPrefix), floList, true);
            writeToFile(prefix(striStr, answerPrefix), strList, true);
        }
    }

    private void writeToFile(String filename, List contents, boolean append) {
        try (FileWriter file = new FileWriter(filename, append)) {
            for (var content : contents) {
                file.write(content + "\n");
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + filename);
        }
    }

    private void pathToFile(String path, String filename, List contents, boolean append) {
        try {
            File file = new File(path, filename);
            if (file.exists()) {
                throw new FileNotFoundException("Файл существует. Проверьте путь: " + path + " или имя файла: " + filename);
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), append));
            for (var content : contents) {
                bw.write(content + "\n");
            }
            bw.close();
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + filename + "\n" +
                    "Проверьте путь: " + path);
        }
    }

    private String prefix(String filename, int answer) {
        if (answer == 1) {
            System.out.println("Укажите префикс для файла " + filename + ": ");
            String pre = sc.next();
            return pre + "_" + filename;
        } else {
            return filename;
        }
    }
}
