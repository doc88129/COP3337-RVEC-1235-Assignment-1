
class Manufacturer {
    private String name;
    private Address address;

    public Manufacturer() {
        this.name = "";
        this.address = new Address();
    }

    public Manufacturer(String name, String address) {
        this.name = name;
        this.address = new Address(address);
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setAddress(String address) {
        this.address.setState(address);;
    }
    public String getAddress() {
        return this.address.getState();
    }

    public Manufacturer Clone() {
        Manufacturer manufacturer = new Manufacturer(this.name, this.address.getState());
        return manufacturer;
    }
}