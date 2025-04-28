package com.borkacle.bank.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;            

import com.borkacle.bank.BankAccount;       

public class BankAccountDataDrivenTest {
    private BankAccount account;

    // configuracion inicial con saldo de 200
    @BeforeMethod
    public void setUp() {
        account = new BankAccount(200.0);
    }

    // datos de prueba para depositos
    @DataProvider(name = "depositData")
    public Object[][] depositData() {
        return new Object[][] {
            {50.0, 250.0},
            {100.0, 300.0},
            {0.01, 200.01}
        };
    }

    // datos de prueba para retiros
    @DataProvider(name = "withdrawalData")
    public Object[][] withdrawalData() {
        return new Object[][] {
            {50.0, 150.0},
            {100.0, 100.0},
            {199.99, 0.01}
        };
    }

    // prueba de depositos usando datos del DataProvider
    @Test(dataProvider = "depositData", groups = "positive-tests")
    public void testDepositWithData(double amount, double expected) {
        account.deposit(amount); // depositar la cantidad
        assertEquals(account.getBalance(), expected, 0.001, "Saldo despues del deposito es incorrecto");
    }

    // prueba de retiros usando datos del DataProvider
    @Test(dataProvider = "withdrawalData", groups = "positive-tests")
    public void testWithdrawalWithData(double amount, double expected) {
        account.withdraw(amount); // retirar la cantidad
        assertEquals(account.getBalance(), expected, 0.001, "Saldo despues del retiro es incorrecto");
    }
}
