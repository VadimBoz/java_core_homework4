package bank;

public abstract class Account {

    private static Long accountNumber = 100L;
    private Double balance;


    public Account(Double balance) {
        this.balance = balance;
        accountNumber++;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }


    public  Double getBalance(){
        return balance;
    }
    public  void setBalance(Double balance) {
        this.balance = balance;
    }


}
