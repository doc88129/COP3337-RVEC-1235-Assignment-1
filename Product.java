
class Product {
    private Manufacturer manufacturer;
    private String productName;
    private Integer quantity;
    private Double unitPrice;

    public Product() {
        this.manufacturer = new Manufacturer();
        this.productName = "";
        this.quantity = 0;
        this.unitPrice = 0.0;
    }
    public Product(Manufacturer manufacturer, String productName, Integer quantity, Double unitPrice) {
        this.manufacturer = manufacturer;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return this.quantity;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public Double getUnitPrice() {
        return this.unitPrice;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductName() {
        return this.productName;
    }

    public void setManufacturerName(String name) {
        this.manufacturer.setName(name);
    }
    public String getManufacturerName() {
        return this.manufacturer.getName();
    }

    public void setManufacturerAddress(String address) {
        this.manufacturer.setAddress(address);
    }
    public String getManufacturerAddress() {
        return this.manufacturer.getAddress();
    }

    public Product Clone() {
        Product product = new Product(this.manufacturer.Clone(), this.productName, this.quantity, this.unitPrice);
        return product;
    }

}