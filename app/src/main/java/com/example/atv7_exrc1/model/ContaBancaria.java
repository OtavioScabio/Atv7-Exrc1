package com.example.atv7_exrc1.model;

public class ContaBancaria {
    protected String cliente;
    protected int numConta;
    protected float saldo;

    public ContaBancaria(String cliente, int numConta, float saldoInicial) {
        this.cliente = cliente;
        this.numConta = numConta;
        this.saldo = saldoInicial;
    }

    public boolean sacar(float valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente para o saque.");
            return false;
        }
    }

    public void depositar(float valor) {
        saldo += valor;
    }

    public float getSaldo() {
        return saldo;
    }

    public String getDadosConta() {
        return "Cliente: " + cliente + "\nNúmero da Conta: " + numConta + "\nSaldo: " + saldo;
    }
}

