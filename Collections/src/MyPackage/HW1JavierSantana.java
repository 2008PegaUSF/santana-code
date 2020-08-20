package hw1javiersantana;

import java.util.*;

public class HW1JavierSantana {

    public static void main(String[] args) {
        //setting static annual interest rate across all accounts
        Account.setAnnualInterest(1.5);
        
        //new account created, deposit and withdraw methods called
        Account one = new Account(1122, "George", 1000.0);
        one.deposit(3000.0, "Paycheck");
        one.withdraw(2500.0, "Rent");
        
        //print all account info
        System.out.println("Account holder's name: " + one.getName());
        System.out.println("Annual interest rate:  " + Account.getAnnualInterest());
        System.out.println("Account balance:       " + one.getBalance());
        System.out.println("Monthly interest:      " + one.getMothlyInterest());
        System.out.println("Account created date:  " + one.getDate());
        
        //loop to print transactions
        for (Transaction tranz : one.getTransactions()) {
            System.out.println(tranz.toString());
        }
        System.out.println();
        
        //Created 10 accounts with their own id and $100 balance
        ArrayList<Account> accounts = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            accounts.add(new Account(1, "", 100.0));
        }
        
        //Scanner object, new array list to store id's, and atm code
        Scanner input = new Scanner(System.in);
        int code;
        ArrayList<Integer> accIds = new ArrayList<>();
        while (true) {
            System.out.println("Entering zero will exit");
            System.out.print("Enter an id: ");
            code = input.nextInt();
            if (code == 0) {
                break;
            } else if (code > 10) {
                System.out.println("Invalid Id");
                continue;
            }
            while (true) {
                int action;
                System.out.println("Main Menu");
                System.out.println("1. check balance");
                System.out.println("2. withdraw");
                System.out.println("3. deposit");
                System.out.println("4. exit");
                System.out.print("Enter a choice: ");
                action = input.nextInt();
                double amount;
                switch (action) {
                    case 1:
                        System.out.println("The balance is " + accounts.get(code).getBalance());
                        continue;
                    case 2:
                        System.out.print("Enter an amount to withdraw: ");
                        amount = input.nextDouble();
                        accounts.get(code).withdraw(amount, "Withdrawal");
                        continue;
                    case 3:
                        System.out.print("Enter an amount to deposit: ");
                        amount = input.nextDouble();
                        accounts.get(code).deposit(amount, "Depostit");
                        continue;
                    case 4:
                        break;
                }
                accIds.add(code);
                break;
            }
        }
        
        //loops through and prints all transactions on all accounts accessed
        for (Integer acct : accIds) {
                System.out.println(accounts.get(acct).getTransactions());
            }

    }
}