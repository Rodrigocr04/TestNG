package com.borkacle.bank.tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.borkacle.bank.BankAccount;   

public class BankAccountExceptionTest {
    private BankAccount account;

    // configuracion inicial con saldo inicial de 100
    @BeforeMethod
    public void setUp() {
        account = new BankAccount(100.0);
    }

    // se prueba el deposito negativo
    @Test(expectedExceptions = IllegalArgumentException.class, // se espera una excepcion de tipo IllegalArgumentException
          expectedExceptionsMessageRegExp = "El deposito debe ser positivo")
    public void testNegativeDeposit() {
        account.deposit(-50.0); // se intenta depositar una cantidad negativa
    }

    // se prueba el retiro negativo
    @Test(expectedExceptions = IllegalArgumentException.class, 
          expectedExceptionsMessageRegExp = "El retiro debe ser positivo")
    public void testNegativeWithdrawal() {
        account.withdraw(-30.0); // se intenta retirar una cantidad negativa
    }

    // se prueba el retiro cuando no hay suficiente saldo
    @Test(expectedExceptions = IllegalArgumentException.class, 
          expectedExceptionsMessageRegExp = "Fondos insuficientes")
    public void testInsufficientFunds() {
        account.withdraw(150.0); // se intenta retirar una cantidad mayor al saldo disponible
    }
}
