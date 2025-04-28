package com.borkacle.bank.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;          

import com.borkacle.bank.BankAccount;      

public class BankAccountLifecycleTest {
    private BankAccount account;

    // configuracion inicial del test con saldo inicial de 500
    @BeforeClass
    public void setUp() {
        account = new BankAccount(500.0);
        System.out.println("Cuenta de prueba creada con saldo inicial: 500"); 
    }

    // se prueba el constructor de la cuenta compartida
    @Test
    public void testDepositInSharedAccount() {
        account.deposit(100.0);
        assertEquals(account.getBalance(), 600.0, "El saldo despues del deposito debe ser 600"); // verificacion
    }

    // se prueba el retiro de la cuenta compartida
    @Test
    public void testWithdrawalFromSharedAccount() {
        account.withdraw(200.0);
        assertEquals(account.getBalance(), 400.0, "El saldo despues del retiro debe ser 400"); // verificacion
    }

    // se limpia el test mostrando el saldo final y liberando la cuenta
    @AfterClass
    public void tearDown() {
        System.out.println("Saldo final de la cuenta: " + account.getBalance());
        account = null;
    }
}
