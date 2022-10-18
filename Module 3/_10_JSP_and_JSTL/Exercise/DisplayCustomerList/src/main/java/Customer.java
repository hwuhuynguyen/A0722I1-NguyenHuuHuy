public class Customer {
    private String nameCustomer;
    private String dateOfBirth;
    private String address;
    private String avatar;

    public Customer(String nameCustomer, String dateOfBirth, String address, String avatar) {
        this.nameCustomer = nameCustomer;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.avatar = avatar;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
