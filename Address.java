
class Address {
    private String state;

    public Address() {
        this.state = "";
    }
    public Address(String state) {
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return this.state;
    }
}