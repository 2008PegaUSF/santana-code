package MyPackage;

import java.util.Date;

//transaction class
public class Transaction {

    //objects of transaction class
    private final Date date;
    private final char type;
    private final double amount;
    private final double balance;
    private final String description;

    //get methods
    public Date getDate() {
        return date;
    }

    public char getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return getType() + ", " + getAmount() + ", " + getBalance() + ", " + getDescription() + ", " + getDate();
    }
    
    //Instance of transaction class
    public Transaction(char type, double amount, double balance, String description) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
        this.date = new Date();
    }
}
