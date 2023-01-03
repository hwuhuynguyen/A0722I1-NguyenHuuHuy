package model;

public class DepositAccount extends Account {
    private String cardNumber;
    private double amount;

    public DepositAccount() {}

    public DepositAccount(String cardNumber, double amount) {
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    public DepositAccount(int id, String accountCode, String accountUser, String dateCreate, String cardNumber, double amount) {
        super(id, accountCode, accountUser, dateCreate);
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public void getInformation() {
        System.out.println("DepositAccount{" +
                "id=" + super.getId() +
                ", accountCode='" + super.getAccountCode() + '\'' +
                ", accountUser='" + super.getAccountUser() + '\'' +
                ", dateCreate='" + super.getDateCreate() + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", amount=" + amount +
                '}');

    }
}
