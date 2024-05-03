package bank;

public class BankClient {

    private int id;
    private static int countClients = 0;

    private String name;

    private DebitAccount debitAccount;
    private CreditAccount creditAccount;


    protected BankClient(String name, Double amount) {
        this.id = countClients;
        this.name = name;
        this.debitAccount = new DebitAccount(amount);
        this.creditAccount = new CreditAccount(0.0);
        countClients++;
    }

    protected String getName() {
        return name;
    }


    protected DebitAccount getDebitAccount() {
        return debitAccount;
    }

    protected CreditAccount getCreditAccount() {
        return creditAccount;
    }

    protected void setDebitAccount(DebitAccount debitAccount) {
        this.debitAccount = debitAccount;
    }

    protected void setCreditAccount(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }


    protected void setBalanceDebit(Double amount) {
        debitAccount.setBalance(amount);
    }
    protected void setBalanceCredit(Double amount) {
        creditAccount.setBalance(amount);
    }

    protected Double getBalanceDebit() {
        return debitAccount.getBalance();
    }
    protected Double getBalanceCredit() {
        return creditAccount.getBalance();
    }

    protected int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id " + id + ", " + name +  ", debitAccount=" + debitAccount.getBalance() +
                ", creditAccount=" + creditAccount.getBalance() + "\n";
    }
}
