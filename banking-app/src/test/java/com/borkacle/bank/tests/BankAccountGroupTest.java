package com.borkacle.bank.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.borkacle.bank.BankAccount;

public class BankAccountGroupTest {
    private BankAccount account;

    // configuracion inicial con saldo de 100
    @BeforeMethod
    public void setUp() {
        account = new BankAccount(100.0);
    }

    // prueba de deposito valido (positivo)
    @Test(groups = "positive-tests")
    public void testValidDeposit() {
        account.deposit(50.0); // se deposita 50
        assertEquals(account.getBalance(), 150.0, "Saldo despues del deposito es incorrecto");
    }

    // prueba de retiro valido (positivo)
    @Test(groups = "positive-tests")
    public void testValidWithdrawal() {
        account.withdraw(50.0); // se retiran 50
        assertEquals(account.getBalance(), 50.0, "Saldo despues del retiro es incorrecto");
    }

    // prueba de deposito invalido (negativo)
    @Test(groups = "negative-tests",
          expectedExceptions = IllegalArgumentException.class) // se espera una excepcion
    public void testInvalidDeposit() {
        account.deposit(-50.0);
    }

    // prueba de retiro invalido (negativo)
    @Test(groups = "negative-tests",
          expectedExceptions = IllegalArgumentException.class) // se espera una excepcion
    public void testInvalidWithdrawal() {
        account.withdraw(-50.0);
    }
}
