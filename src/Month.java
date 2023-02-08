import java.util.Objects;

public class Month {

    final private Product[] product;
    private String name;

    public Month(Product[] product, String name) {
        this.product = product;
        this.name = name;
    }

    public Product getBiggestIncome() {
        int indexOfBiggest = 0;
        for (int i = 0; i < product.length; i++) {
            if (product[indexOfBiggest].getSum() < product[i].getSum()) {
                indexOfBiggest = i;
            }
        }
        return product[indexOfBiggest];

    }

    public Product getBiggestExpences() {
        int indexOfBiggest = 0;
        for (int i = 0; i < product.length; i++) {
            if (product[indexOfBiggest].getSum() > product[i].getSum()) {
                indexOfBiggest = i;
            }
        }
        return product[indexOfBiggest];

    }


    public String getAllInfo() {
        String string = "имя месяца  " + name + "\n" +
                "Наибольший доход  " + getBiggestIncome().getSum() + "\n" + "Наибольший расход " + getBiggestExpences().getSum();
        return string;

    }

    public static Month getMonth(String path, String name) {
        String temple = Main.readFileContentsOrNull(path);

        if (temple == null){
            return null;
        }

        String[] lines = temple.split("\\n");


        Product[] ourProducts = new Product[lines.length - 1];
        for (int i = 0; i < ourProducts.length; i++) {
            String[] productString = lines[i + 1].split(",");
            boolean isExpanse = true;
            if ("FALSE".equals(productString[1])) {
                isExpanse = false;
            }

            ourProducts[i] =
                    new Product(productString[0], isExpanse, Integer.parseInt(productString[2]), Integer.parseInt(productString[3]));

        }

        return new Month(ourProducts, name);
    }

    public int getIncomeOfAll() {
        int result = 0;
        for (int i = 0; i < product.length; i++) {
            if (product[i].getSum() > 0) {

                result = result + product[i].getSum();
            }
        }
        return result;
    }

    public int getExpencesOfAll() {
        int result = 0;
        for (int i = 0; i < product.length; i++) {
            if (product[i].getSum() < 0) {

                result = result + product[i].getSum();
            }
        }
        return -result;
    }

    public int getProfit (){

        return getIncomeOfAll() - getExpencesOfAll();
    }

    public String getName() {
        return name;
    }
}
