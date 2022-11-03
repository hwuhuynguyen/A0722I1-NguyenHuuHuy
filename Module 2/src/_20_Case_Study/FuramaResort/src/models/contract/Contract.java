package models.contract;

public class Contract {
    private String contractID;
    private String bookingID;
    private double depositAmount;
    private double paymentAmount;
    private String customerID;

    public Contract(String contractID, String bookingID, double depositAmount, double paymentAmount, String customerID) {
        this.contractID = contractID;
        this.bookingID = bookingID;
        this.depositAmount = depositAmount;
        this.paymentAmount = paymentAmount;
        this.customerID = customerID;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractID='" + contractID + '\'' +
                ", bookingID='" + bookingID + '\'' +
                ", depositAmount=" + depositAmount +
                ", paymentAmount=" + paymentAmount +
                ", customerID='" + customerID + '\'' +
                '}';
    }
}
