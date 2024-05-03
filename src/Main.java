import bank.Bank;
import bank.Transaction;
import bankException.NotEnoughMoneyException;
import bankException.NotExistsUserException;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();

        try {
            bank.addClient("Mikl", 100.3);
            bank.addClient("Alex", 10.0);
            bank.addClient("Svetlana", 15.0);
            bank.addClient("Anastasia", 75.0);
            bank.addClient("Sofia", -9.0);
            bank.addClient("Sofia2", 19.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        System.out.println(bank.getClients());
        Transaction transaction;
        try {
            transaction = new Transaction(bank, 2, 0);
            transaction.doTransactionBetweenClients(20);
            transaction.doTransactionPutMoneyToCredit(200.0);
            transaction.doTransactionWithdrawFromCredit(250.0);
        } catch (IllegalArgumentException  e) {
            System.out.println(e.getMessage());
        } catch (NotExistsUserException e2) {
            System.out.println(e2.getMessage());
        } catch (NotEnoughMoneyException e3) {
            System.out.println(e3.getMessage());
            System.out.println("Клиент " + e3.getClient());
        }










    }
}