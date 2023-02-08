import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    private static final String monthJanuary = "resources/m.202101.csv";
    private static final String monthFebruary = "resources/m.202102.csv";
    private static final String monthMart = "resources/m.202103.csv";

    private static final String yearPath = "resources/y.2021.csv";


    public static void main(String[] args) {


        menu();

    }


    public static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }


    public static void menu() {


        Month month1 = null;
        Month month2 = null;
        Month month3 = null;
        Year year = null;

        while (true) {

            System.out.println("Что вы хотите сделать? ");
            System.out.println("1 - Считать все месячные отчёты");
            System.out.println("2 - Считать годовой отчёт");
            System.out.println("3 - Сверить отчёты");
            System.out.println("4 - Вывести информацию о всех месячных отчётах");
            System.out.println("5 - Вывести информацию о годовом отчёте");
            System.out.println("0 - Выход");

            Scanner index = new Scanner(System.in);
            int command = index.nextInt();

            switch (command) {

                case 1:

                    month1 = Month.getMonth(monthJanuary, "январь");
                    month2 = Month.getMonth(monthFebruary, "февраль");
                    month3 = Month.getMonth(monthMart, "март");
                    break;
                case 2:
                    if (month1 == null) {
                        break;
                    }
                    year = new Year("2021", new Month[]{month1, month2, month3});
                    break;
                case 3:
                    System.out.println(year.compareWithReport(yearPath));
                    break;
                case 4:
                    if (month1 == null) {
                        break;
                    }
                    System.out.println(month1.getAllInfo());
                    System.out.println(month2.getAllInfo());
                    System.out.println(month3.getAllInfo());
                    break;
                case 5:
                    if (year == null) {
                        break;
                    }
                    System.out.println(year.getAllInfo());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("такой команды нет");

            }
        }
    }

    public static int swap(int first, int second) {
        return first;
    }
}






