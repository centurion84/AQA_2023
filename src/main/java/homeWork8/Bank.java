package homeWork8;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<Account> accounts;
    private final int maxAccounts;

    public Bank(int maxAccounts) {
        this.maxAccounts = maxAccounts;
        this.accounts = new ArrayList<>();
    }

    public Account createAccount(int accountNumber, double initialBalance) {
        if (accounts.size() < maxAccounts) {
            Account account = new Account(accountNumber, initialBalance);
            accounts.add(account);
            return account;
        } else {
            System.out.println("Cannot create more accounts. Maximum account limit reached.");
            return null;
        }
    }

    // reloaded method deposit that accept account number
    public void deposit(int accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null)
            account.deposit(amount);
    }

    // reloaded method withdraw that accept account number
    public void withdraw(int accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null)
            account.withdraw(amount);
    }

    // search and output account info
    public void findAccountAndPrintTransactions(int accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("Account " + accountNumber + " balance: " + account.getBalance());
            System.out.println("Account " + accountNumber + " transactions:");
            for (Transaction transaction : account.getTransactions()) {
                System.out.println("Type: " + transaction.getTransactionType() + ", Amount: " + transaction.getAmount());
            }
        }
    }

    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        System.out.println("Account with number " + accountNumber + " not found.");
        return null;
    }

    public enum TransactionType {
        DEPOSIT,
        WITHDRAW
    }

    public static class Account {
        private final int accountNumber;
        private final List<Transaction> transactions;
        private double balance;

        public Account(int accountNumber, double initialBalance) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
            this.transactions = new ArrayList<>();
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        public List<Transaction> getTransactions() {
            return transactions;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                transactions.add(new Transaction(accountNumber, amount, TransactionType.DEPOSIT));
                System.out.println("Deposit of " + amount + " USD into account " + accountNumber + " successful, balance is " + balance);
            } else {
                System.out.println("Invalid deposit amount!");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                transactions.add(new Transaction(accountNumber, amount, TransactionType.WITHDRAW));
                System.out.println("Withdrawal of " + amount + " USD from account " + accountNumber + " successful, balance is " + balance);
            } else {
                System.out.println("Invalid withdrawal amount or insufficient balance!");
            }
        }
    }

    private static class Transaction {
        private final int accountNumber;
        private final double amount;
        private final TransactionType transactionType;

        public Transaction(int accountNumber, double amount, TransactionType transactionType) {
            this.accountNumber = accountNumber;
            this.amount = amount;
            this.transactionType = transactionType;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public double getAmount() {
            return amount;
        }

        public TransactionType getTransactionType() {
            return transactionType;
        }
    }
}
