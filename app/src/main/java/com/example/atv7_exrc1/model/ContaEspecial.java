package com.example.atv7_exrc1.model;

public class ContaEspecial extends ContaBancaria {
    private float limite;

    public ContaEspecial(String cliente, int numConta, float saldoInicial, float limite) {
        super(cliente, numConta, saldoInicial);
        this.limite = limite;
    }

    @Override
    public boolean sacar(float valor) {
        if (saldo + limite >= valor) {
            saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo e limite insuficientes para o saque.");
            return false;
        }
    }

    @Override
    public String getDadosConta() {
        return super.getDadosConta() + "\nLimite: " + limite;
    }
}

