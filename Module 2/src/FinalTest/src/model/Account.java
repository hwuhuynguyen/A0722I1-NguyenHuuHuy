package model;

public abstract class Account {
    private int id;
    private String accountCode;
    private String accountUser;
    private String dateCreate;

    public Account() {}

    public Account(int id, String accountCode, String accountUser, String dateCreate) {
        this.id = id;
        this.accountCode = accountCode;
        this.accountUser = accountUser;
        this.dateCreate = dateCreate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(String accountUser) {
        this.accountUser = accountUser;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }
    public abstract void getInformation();

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountCode='" + accountCode + '\'' +
                ", accountUser='" + accountUser + '\'' +
                ", dateCreate='" + dateCreate + '\'' +
                '}';
    }
}
