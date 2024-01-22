import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] pathFile = {"src/main/resources/in2.txt", "src/main/resources/in1.txt"};
        Filter filter = new Filter();

        System.out.println("Хотите ли указывать путь до файлов? 1 - да / 2 - нет");
        int answerPath = sc.nextInt();
        while (answerPath != 1 && answerPath != 2) {
            System.out.println("Такой команды нет. Повторите ввод: ");
            answerPath = sc.nextInt();
        }

        System.out.println("Хотите ли указывать префикс для названия файла? 1 - да / 2 - нет");
        int answerPrefix = sc.nextInt();
        while (answerPrefix!= 1 && answerPrefix != 2) {
            System.out.println("Такой команды нет. Повторите ввод: ");
            answerPrefix = sc.nextInt();
        }

        filter.distribution(pathFile, answerPath, answerPrefix);

        System.out.println("Вывести статистику? 1 - да / 2 - нет");
        int answerStat = sc.nextInt();
        while (answerStat!= 1 && answerStat != 2) {
            System.out.println("Такой команды нет. Повторите ввод: ");
            answerStat = sc.nextInt();
        }
        if (answerStat == 1) {
            Stats stats = new Stats();
            stats.shortStats(filter.getIntList(), filter.getFloList(), filter.getStrList());
            System.out.println('\r');
            stats.fullStatsForNumbers(filter.getIntList(), filter.getFloList());
            System.out.println('\r');
            stats.fullStatsForString(filter.getStrList());
        } else if (answerStat == 2) {
            System.out.println("Выход");
        }
    }
}