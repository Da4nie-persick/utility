import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Stats {
    public void shortStats(List<Integer> integerList, List<Float> floatList, List<String> stringList) {
        System.out.println("Краткий отчет:");
        System.out.println("Количество integer элементов: " + integerList.size());
        System.out.println("Количество float элементов: " + floatList.size());
        System.out.println("Количество String элементов: " + stringList.size());
    }

    public void fullStatsForNumbers(List<Integer> integerList, List<Float> floatList) {
        System.out.println("Полный отчет для integer значений:");
        System.out.println("Маскимальное значение: " + Collections.max(integerList));
        System.out.println("Минимальное значение: " + Collections.min(integerList));
        System.out.println("Сумма значение: " + sumListInt(integerList));
        System.out.println("Среднее значение: " + sumListInt(integerList) / integerList.size());
        System.out.println('\r');
        System.out.println("Полный отчет для float значений:");
        System.out.println("Маскимальное значение: " + Collections.max(floatList));
        System.out.println("Минимальное значение: " + Collections.min(floatList));
        System.out.println("Сумма значение: " + sumListFlo(floatList));
        System.out.println("Среднее значение: " + sumListFlo(floatList) / floatList.size());
    }

    public void fullStatsForString(List<String> stringList) {
        System.out.println("Полный отчет для String значений:");
        System.out.println("Количество строк: " + stringList.size());
        System.out.println("Размер самой длинной строки: " +
                Collections.max(stringList, Comparator.comparing(s -> s.length())).length());
        System.out.println("Размер самой длинной строки: " +
                Collections.min(stringList, Comparator.comparing(s -> s.length())).length());
    }

    private int sumListInt(List<Integer> list) {
        int sum = 0;
        for (var num : list) {
            sum += num;
        }
        return sum;
    }

    private float sumListFlo(List<Float> list) {
        float sum = 0;
        for (var num : list) {
            sum += num;
        }
        return sum;
    }
}
