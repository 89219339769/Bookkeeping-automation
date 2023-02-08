public class Product {

    private String itemName;
    private boolean isExpense;
    private int quantity;
    private int sumOfOne;


    public Integer getSum() {
        if (isExpense) {
            return - quantity * sumOfOne;
        }
        else {
            return quantity * sumOfOne;
        }
    }

    public Product(String itemName, Boolean isExpense, Integer quantity, Integer sumOfOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;

    }


}
