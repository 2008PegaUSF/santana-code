
package hw1javiersantana;

import java.util.ArrayList;
import java.util.Date;

//Account class
public class Account {
    
    //All statics
    private static double annualInterest = 0.0;
    
    public static void setAnnualInterest(double annualInterest) {
        Account.annualInterest = annualInterest;
    }
        
    public static double getAnnualInterest() {
        return annualInterest;
    }
    
    public static double getMonthlyInterestRate() {
        return getAnnualInterest() / 12.0;
    }
    
    //objects of account class
    private int id;
    private String name;
    private double balance;
    private Date date;
    private final ArrayList<Transaction> transactions;
    
    //instance of account class
    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.date = new Date();
        this.transactions = new ArrayList<>();
    }
    
    //getters and setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public Date getDate() {
        return date;
    }
    
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    
    public double getMothlyInterest() {
        return (getMonthlyInterestRate() / 100) * balance;
    }
    
    //withdraw method
    public double withdraw(double amount, String description) {
        this.balance -= amount;
        this.transactions.add(new Transaction('W', amount, balance, description));
        return this.balance;
    }
    
    //deposit method
    public double deposit(double amount, String description) {
        this.balance += amount;
        this.transactions.add(new Transaction('D', amount, balance, description));
        return this.balance;
    }    
}
