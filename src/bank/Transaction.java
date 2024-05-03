package bank;

import bankException.NotEnoughMoneyException;
import bankException.NotExistsUserException;

public class Transaction {

    private BankClient recipient;
    private BankClient sender;

   private Bank bank;



    public Transaction(Bank bank, Integer idRecipient, Integer idSender) throws NotExistsUserException {
        this.recipient = bank.getClient(idRecipient);
        this.sender = bank.getClient(idSender);
        this.bank = bank;

    }

    public Transaction(Bank bank, Integer idRecipient) throws NotExistsUserException {
        this(bank, idRecipient, null);
    }


    public void doTransactionBetweenClients (double amount) throws NotExistsUserException, NotEnoughMoneyException {
            if (amount <= 0) throw new IllegalArgumentException("Сумма не может быть меньше нуля");
            if (sender == null) throw new NotExistsUserException("Получатель не задан");
            if (sender.getBalanceDebit() >= amount) {
                sender.setBalanceDebit(sender.getBalanceDebit() - amount);
                recipient.setBalanceDebit(recipient.getBalanceDebit() + amount);
                System.out.println("Выполнен перевод " + amount + " от "  + sender.getName() +
                        " к " + recipient.getName());
            } else throw new NotEnoughMoneyException(sender, amount);

    }


    public void doTransactionWithdrawFromDebit (double amount) throws NotEnoughMoneyException {
        if (amount <= 0) throw new IllegalArgumentException("Сумма не может быть меньше нуля");
        if (recipient.getBalanceDebit() >= amount) {
            recipient.setBalanceDebit(recipient.getBalanceDebit() - amount);
            System.out.println("Выполнено снятие денег с дебетового счета " +recipient.getName() + " " + amount);
        } else throw new NotEnoughMoneyException(recipient, amount);
    }

    public void doTransactionWithdrawFromCredit (double amount) throws NotEnoughMoneyException {
        if (amount <= 0) throw new IllegalArgumentException("Сумма не может быть меньше нуля");
        if (recipient.getBalanceCredit() >= amount) {
            recipient.setBalanceCredit(recipient.getBalanceCredit() - amount);
            System.out.println("Выполнено снятие денег с кредитного счета " + recipient.getName() + " " + amount);
        } else throw new NotEnoughMoneyException(recipient, amount);
    }



    public void doTransactionPutMoneyToCredit (double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Сумма не может быть меньше нуля");
        recipient.setBalanceCredit(recipient.getBalanceCredit() + amount);


    }


    public void doTransactionPutMoneyToDebit (double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Сумма не может быть меньше нуля");
        recipient.setBalanceDebit(recipient.getBalanceDebit() + amount);
    }

    public BankClient getRecipient() {
        return recipient;
    }

    public void setRecipient(BankClient recipient) {
        this.recipient = recipient;
    }

    public BankClient getSender() {
        return sender;
    }

    public void setSender(BankClient sender) {
        this.sender = sender;
    }



    public Bank getBank() {
        return bank;
    }
}
