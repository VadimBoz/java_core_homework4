


package bankException;

import bank.BankClient;

public class NotExistsUserException extends Exception {

     private BankClient bankClient;

    public NotExistsUserException(String msg) {
        super(msg);

    }




    public BankClient getBankClient() {
        return bankClient;
    }
}

