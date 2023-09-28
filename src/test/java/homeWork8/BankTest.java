package homeWork8;

import org.testng.annotations.Test;

public class BankTest {

    static final Bank bank = new Bank(5);
    public static Bank.Account account1;
    public static Bank.Account account2;

    @Test
    public static void testCreateAccount() {
        account1 = bank.createAccount(1, 1000.0);
        account2 = bank.createAccount(2, 500.0);
    }

    // deposit tests
    @Test(dependsOnMethods = "testCreateAccount")
    public static void testDeposit() {
        account1.deposit(200.0);
        account2.deposit(300.0);
    }

    @Test(dependsOnMethods = "testCreateAccount")
    public static void testDepositByNumber() {
        bank.deposit(1, 550);
    }

    @Test(dependsOnMethods = "testCreateAccount")
    public static void testDepositWrongNumber() {
        bank.deposit(99, 550);
    }

    @Test(dependsOnMethods = "testCreateAccount")
    public static void testDepositInvalid() {
        account1.deposit(0.0);
        account2.deposit(-220.0);
    }

    // withdraw tests
    @Test(dependsOnMethods = "testCreateAccount")
    public static void testWithdraw() {
        account1.withdraw(50.0);
        account2.withdraw(100.0);
    }

    @Test(dependsOnMethods = "testCreateAccount")
    public static void testWithdrawByNumber() {
        bank.withdraw(1, 550);
    }

    @Test(dependsOnMethods = "testCreateAccount")
    public static void testWithdrawWrongNumber() {
        bank.withdraw(1, 550);
    }

    @Test(dependsOnMethods = "testCreateAccount")
    public static void testWithdrawInvalid() {
        account1.withdraw(0.0);
        account2.withdraw(-10.0);
    }

    @Test(dependsOnMethods = "testCreateAccount")
    public static void testWithdrawNoMoney() {
        account1.withdraw(10000.0);
        account2.withdraw(5000.5);
    }

    // account info tests
    @Test(dependsOnMethods = "testCreateAccount")
    public static void testAccountLimit() {
        bank.createAccount(3, 200.0);
        bank.createAccount(4, 300.0);
        bank.createAccount(5, 400.0);
        bank.createAccount(6, 500.0);
    }

    @Test(dependsOnMethods = {"testCreateAccount", "testDeposit", "testWithdraw"})
    public static void testAccountInfoOutput() {
        bank.findAccountAndPrintTransactions(1);
    }

    @Test
    public static void testAccountInvalid() {
        bank.findAccountAndPrintTransactions(99);
    }
}
