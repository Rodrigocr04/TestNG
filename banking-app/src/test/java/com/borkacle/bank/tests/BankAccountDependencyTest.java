package com.borkacle.bank.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.borkacle.bank.BankAccount;

public class BankAccountDependencyTest {
    private BankAccount account;

    // configuracion inicial con saldo de 100
    @BeforeClass
    public void setUp() {
        account = new BankAccount(100.0);
    }

    // prueba de deposito inicial
    @Test
    public void testInitialDeposit() {
        account.deposit(200.0);
        assertEquals(account.getBalance(), 300.0, "Fallo en el deposito inicial");
    }

    // prueba de retiro dependiente del deposito inicial
    @Test(dependsOnMethods = "testInitialDeposit") // este test depende de la ejecucion del test de deposito
    public void testDependentWithdrawal() {
        account.withdraw(150.0); // se retiran 150
        assertEquals(account.getBalance(), 150.0, "Fallo en el retiro despues del deposito");
    }
}
