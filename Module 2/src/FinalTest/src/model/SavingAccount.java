package model;

public class SavingAccount extends Account {
    private double money;
    private String dateOfSaving;
    private double rate;
    private int month;

    public SavingAccount() {}

    public SavingAccount(double money, String dateOfSaving, double ratio, int month) {
        this.money = money;
        this.dateOfSaving = dateOfSaving;
        this.rate = ratio;
        this.month = month;
    }

    public SavingAccount(int id, String accountCode, String accountUser, String dateCreate, double money,
                         String dateOfSaving, double ratio, int month) {
        super(id, accountCode, accountUser, dateCreate);
        this.money = money;
        this.dateOfSaving = dateOfSaving;
        this.rate = ratio;
        this.month = month;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getDateOfSaving() {
        return dateOfSaving;
    }

    public void setDateOfSaving(String dateOfSaving) {
        this.dateOfSaving = dateOfSaving;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public void getInformation() {
        System.out.println("SavingAccount{" +
                "id=" + super.getId() +
                ", accountCode='" + super.getAccountCode() + '\'' +
                ", accountUser='" + super.getAccountUser() + '\'' +
                ", dateCreate='" + super.getDateCreate() + '\'' +
                ", money=" + money +
                ", dateOfSaving='" + dateOfSaving + '\'' +
                ", rate=" + rate +
                ", month=" + month +
                '}');
    }

}
