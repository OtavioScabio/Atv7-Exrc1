package com.example.atv7_exrc1;

/*Otavio Gabriel Ribeiro Scabio - 1110482223043*/

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.atv7_exrc1.model.ContaEspecial;
import com.example.atv7_exrc1.model.ContaPoupanca;

public class MainActivity extends AppCompatActivity {


    private RadioButton contaPoupancaRadio, contaEspecialRadio;
    private EditText nomeClienteInput, numContaInput, saldoInicialInput, limiteInput, diaRendimentoInput, valorOperacaoInput, taxaRendimentoInput;
    private Button saqueButton, depositoButton, calcularRendimentoButton, criarContaButton;
    private TextView resultTextView;
    private ContaPoupanca contaPoupanca;
    private ContaEspecial contaEspecial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


            contaPoupancaRadio = findViewById(R.id.contaPoupancaRadio);
            contaEspecialRadio = findViewById(R.id.contaEspecialRadio);
            nomeClienteInput = findViewById(R.id.nomeClienteInput);
            numContaInput = findViewById(R.id.numContaInput);
            saldoInicialInput = findViewById(R.id.saldoInicialInput);
            limiteInput = findViewById(R.id.limiteInput);
            diaRendimentoInput = findViewById(R.id.diaRendimentoInput);
            valorOperacaoInput = findViewById(R.id.valorOperacaoInput);
            taxaRendimentoInput = findViewById(R.id.taxaRendimentoInput);
            saqueButton = findViewById(R.id.saqueButton);
            depositoButton = findViewById(R.id.depositoButton);
            calcularRendimentoButton = findViewById(R.id.calcularRendimentoButton);
            resultTextView = findViewById(R.id.resultTextView);
            criarContaButton = findViewById(R.id.criarContaButton);



        saqueButton.setOnClickListener(o -> {
            float valor = Float.parseFloat(valorOperacaoInput.getText().toString());
            if (contaPoupancaRadio.isChecked() && contaPoupanca != null) {
                contaPoupanca.sacar(valor);
                resultTextView.setText(contaPoupanca.getDadosConta());
            } else if (contaEspecialRadio.isChecked() && contaEspecial != null) {
                contaEspecial.sacar(valor);
                resultTextView.setText(contaEspecial.getDadosConta());
            }
        });

        depositoButton.setOnClickListener(o -> {
            float valor = Float.parseFloat(valorOperacaoInput.getText().toString());
            if (contaPoupancaRadio.isChecked() && contaPoupanca != null) {
                contaPoupanca.depositar(valor);
                resultTextView.setText(contaPoupanca.getDadosConta());
            } else if (contaEspecialRadio.isChecked() && contaEspecial != null) {
                contaEspecial.depositar(valor);
                resultTextView.setText(contaEspecial.getDadosConta());
            }
        });

        calcularRendimentoButton.setOnClickListener(o -> {
            if (contaPoupanca != null) {
                float taxa = Float.parseFloat(taxaRendimentoInput.getText().toString());
                contaPoupanca.calcularNovoSaldo(taxa);
                resultTextView.setText(contaPoupanca.getDadosConta());
            }
        });

        findViewById(R.id.criarContaButton).setOnClickListener(o -> {
            String cliente = nomeClienteInput.getText().toString();
            int numConta = Integer.parseInt(numContaInput.getText().toString());
            float saldoInicial = Float.parseFloat(saldoInicialInput.getText().toString());

            if (contaPoupancaRadio.isChecked()) {
                int diaRendimento = Integer.parseInt(diaRendimentoInput.getText().toString());
                contaPoupanca = new ContaPoupanca(cliente, numConta, saldoInicial, diaRendimento);
                resultTextView.setText(contaPoupanca.getDadosConta());
            } else if (contaEspecialRadio.isChecked()) {
                float limite = Float.parseFloat(limiteInput.getText().toString());
                contaEspecial = new ContaEspecial(cliente, numConta, saldoInicial, limite);
                resultTextView.setText(contaEspecial.getDadosConta());
            }
        });
    }
}