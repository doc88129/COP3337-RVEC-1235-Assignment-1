
class Transaction {
    Product product;
    String purchaseDate;

    public Transaction() {
        this.product = new Product();
        this.purchaseDate = "";
    }
    public Transaction(Product product, String purchaseDate) {
        this.product = product;
        this.purchaseDate = purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    public String getPurchaseDate() {
        return this.purchaseDate;
    }

    public void setProduct (Product product) {
        this.product = product;
    }
    public Product getProduct() {
        return this.product;
    }
}