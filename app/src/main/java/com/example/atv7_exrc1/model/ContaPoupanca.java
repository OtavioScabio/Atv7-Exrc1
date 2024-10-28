package com.example.atv7_exrc1.model;
/*Otavio Gabriel Ribeiro Scabio - 1110482223043*/
public class ContaPoupanca extends ContaBancaria {
    private int diaDeRendimento;

    public ContaPoupanca(String cliente, int numConta, float saldoInicial, int diaDeRendimento) {
        super(cliente, numConta, saldoInicial);
        this.diaDeRendimento = diaDeRendimento;
    }

    public void calcularNovoSaldo(float taxaRendimento) {
        saldo += saldo * (taxaRendimento / 100);
    }

    @Override
    public String getDadosConta() {
        return super.getDadosConta() + "\nDia de Rendimento: " + diaDeRendimento;
    }
}
