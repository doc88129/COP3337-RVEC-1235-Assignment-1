import java.text.SimpleDateFormat;
import java.util.Date;

class Transaction {
    private Product product;
    private Date transactionDate;

    public Transaction() {
        this.product = new Product();
        this.transactionDate = new Date();
    }
    public Transaction(Product product, Date transactionDate) {
        this.product = product;
        this.transactionDate = transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
    public String getTransactionDate() {
        return new SimpleDateFormat("MM-dd-yyyy").format(transactionDate);
    }

    public void setProduct (Product product) {
        this.product = product;
    }
    public Product getProduct() {
        return this.product;
    }
}