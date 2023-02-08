import java.util.Objects;

public class Year {
    private String name;
    private Month[] month;


    public Year(String name, Month[] month) {

        this.name = name;
        this.month = month;

    }

    public double getAverageIncome() {
        double result = 0;
        for (int i = 0; i < month.length; i++) {

            result += month[i].getIncomeOfAll();
        }
        return result / month.length;
    }

    public double getAverageExpences() {
        double result = 0;
        for (int i = 0; i < month.length; i++) {

            result += month[i].getExpencesOfAll();
        }
        return result / month.length;
    }

    public String getProfitForEachMonth() {

        String result = "";
        for (int i = 0; i < month.length; i++) {
            result += month[i].getName() + "-" + month[i].getProfit() + "\n";
        }

        return result;
    }


    public String getAllInfo() {
        String ear = name + "\n" + getProfitForEachMonth() + " средний расход " + getAverageExpences() + " cредний доход " + getAverageIncome();

        return ear;
    }


    public boolean compareWithReport(String path) {

        String yearReport = Main.readFileContentsOrNull(path);
        String[] lines = yearReport.split("\\n");


        if ((lines.length - 1) / 2 != month.length) {
            return false;
        }
        for (int i = 1, j = 0; i < lines.length; i += 2, j++) {
            int income = Integer.parseInt(lines[i].split(",")[1]);
            int expense = Integer.parseInt(lines[i + 1].split(",")[1]);
            if(Objects.equals(lines[i].split(",")[2], "true")){
                income = Main.swap(expense, expense = income);
            }
            if (income != month[j].getIncomeOfAll() || expense != month[j].getExpencesOfAll()) {
                return false;
            }

        }
        return true;
    }


}

