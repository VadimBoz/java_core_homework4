package bankException;

import bank.BankClient;

public class NotEnoughMoneyException extends Exception {
   Double amount;
   BankClient client;
   public NotEnoughMoneyException(BankClient client, Double amount){
        super("Для совершения операции у клиента не хватает средств ");
        this.amount = amount;
        this.client = client;
   }

    public Double getAmount() {
        return amount;
    }

    public BankClient getClient() {
        return client;
    }
}
