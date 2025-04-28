package com.borkacle.bank.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import com.borkacle.bank.BankAccount;

public class BankAccountTest {
    
    // objeto de BankAccount a probar
    private BankAccount account;

    // se verifica el funcionamiento del constructor
    @Test
    public void testInitialBalance() {
        account = new BankAccount(100.0); // se crea una cuenta con saldo de 100
        assertEquals(account.getBalance(), 100.0, "El saldo inicial debe ser 100"); // verificacion
    }

    // se verifica el funcionamiento del metodo deposit
    @Test
    public void testDeposit() {
        account = new BankAccount(100.0);
        account.deposit(50.0); // deposita 50 a la cuenta
        assertEquals(account.getBalance(), 150.0, "El saldo despues del deposito debe ser 150"); // verificacion
    }

    // se verifica el funcionamiento del metodo withdraw
    @Test
    public void testWithdrawal() {
        account = new BankAccount(100.0);
        account.withdraw(30.0); // retira 30 de la cuenta
        assertEquals(account.getBalance(), 70.0, "El saldo despues del retiro debe ser 70"); // verificacion
    }
}
