package bank;

import bankException.NotEnoughMoneyException;
import bankException.NotExistsUserException;

import java.util.ArrayList;

public class Bank {
    private final ArrayList<BankClient> clients = new ArrayList<>();



    public void addClient(String name, Double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Сумма должна быть больше 0, клиент " + name + " не добавлен" + "\n");
        clients.add(new BankClient(name, amount));
    }


    public void setCreditAmount(int idClient, double amount) throws NotExistsUserException {
        if (amount <= 0) throw new IllegalArgumentException("Сумма должна быть больше 0, кредит не выдан" + "\n");
        int flag = 0;
        for (BankClient client : clients) {
            if (client.getId() == idClient) {
                client.setBalanceCredit(amount);
                flag = 1;
            }
        }
        if (flag == 0) {
            throw new NotExistsUserException("Клиент с таким id не найден" + "\n");
        }
    }

    public ArrayList<BankClient> getClients() {
        return clients;
    }

    public BankClient getClient(int idClient) throws NotExistsUserException {
        for (BankClient client : clients) {
            if (client.getId() == idClient) {
                return client;
            }
        }
        throw new NotExistsUserException("Клиент с таким id = " + idClient + " не найден" + "\n");
    }


}
