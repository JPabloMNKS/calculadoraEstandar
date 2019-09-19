package com.example.calculadoraestandar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // botones numero
    Button btnUno,btnDos,btnTres,btnCuatro,btnCinco,btnSeis,btnSiete,btnOcho,btnNueve,btnCero;
    TextView txtPrincipal,txtPrevio;
    Button btnMas,btnMenos,btnMultiplicar,btnDivision,btnPunto,btnIgual;
    Button btnC,btnCE,btnPow,btnRaiz;


    // variables
    boolean igual = true, inicio = true, operacion1 = true, operacion2 = true;
    double a, b, c, memoria = 0, resultado, valor1, valor2;
    String funciones, tipoOperaciones;
    String previo = "";
    String principal = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // enlazando numeros con los ID's
        btnUno = findViewById(R.id.btn_uno);
        btnDos = findViewById(R.id.btn_dos);
        btnTres = findViewById(R.id.btn_tres);
        btnCuatro = findViewById(R.id.btn_cuatro);
        btnCinco = findViewById(R.id.btn_cinco);
        btnSeis = findViewById(R.id.btn_seis);
        btnSiete = findViewById(R.id.btn_siete);
        btnOcho = findViewById(R.id.btn_ocho);
        btnNueve = findViewById(R.id.btn_nueve);
        btnCero = findViewById(R.id.btn_cero);

        // enlazando signos con los ID's
        btnMas = findViewById(R.id.btn_mas);
        btnMenos = findViewById(R.id.btn_menos);
        btnMultiplicar = findViewById(R.id.btn_multiplicar);
        btnDivision = findViewById(R.id.btn_dividir);
        btnPunto = findViewById(R.id.btn_punto);
        btnIgual = findViewById(R.id.btn_igual);

        btnC = findViewById(R.id.btn_c);
        btnCE = findViewById(R.id.btn_ce);
        btnPow = findViewById(R.id.btn_pow);
        btnRaiz = findViewById(R.id.btn_raiz);

        // enlazando textos con los ID's
        txtPrincipal = findViewById(R.id.txt_principal);
        txtPrevio = findViewById(R.id.txt_previo);

        // Numero Click Listener
        btnUno.setOnClickListener(this);
        btnDos.setOnClickListener(this);
        btnTres.setOnClickListener(this);
        btnCuatro.setOnClickListener(this);
        btnCinco.setOnClickListener(this);
        btnSeis.setOnClickListener(this);
        btnSiete.setOnClickListener(this);
        btnOcho.setOnClickListener(this);
        btnNueve.setOnClickListener(this);
        btnCero.setOnClickListener(this);

        // Signo Click Listener
        btnMas.setOnClickListener(this);
        btnMenos.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnPunto.setOnClickListener(this);
        btnIgual.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnPow.setOnClickListener(this);
        btnRaiz.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_uno:
                numero_Click(1);
                break;
            case R.id.btn_dos:
                numero_Click(2);
                break;
            case R.id.btn_tres:
                numero_Click(3);
                break;
            case R.id.btn_cuatro:
                numero_Click(4);
                break;
            case R.id.btn_cinco:
                numero_Click(5);
                break;
            case R.id.btn_seis:
                numero_Click(6);
                break;
            case R.id.btn_siete:
                numero_Click(7);
                break;
            case R.id.btn_ocho:
                numero_Click(8);
                break;
            case R.id.btn_nueve:
                numero_Click(9);
                break;
            case R.id.btn_cero:
                if(!txtPrincipal.getText().toString().equals("0"))
                    numero_Click(0);
                break;

            case R.id.btn_mas:
                funcion_click("+");
                break;
            case R.id.btn_menos:
                funcion_click("-");
                break;
            case R.id.btn_multiplicar:
                funcion_click("*");
                break;
            case R.id.btn_dividir:
                funcion_click("/");
                break;
            case R.id.btn_igual:
                inicio = true;
                operacion1 = true;
                if (igual)
                {
                    if(tipoOperaciones != null)
                    {
                        valor2 = Double.parseDouble(txtPrincipal.getText().toString());
                        txtPrevio.setText(txtPrevio.getText().toString()+ txtPrincipal.getText().toString());
                        Operaciones(valor1,valor2);
                        igual = false;
                    }
                }
                break;

            case R.id.btn_punto:
                if (!txtPrincipal.getText().toString().contains("."))
                {
                    txtPrincipal.setText(txtPrincipal.getText()+".");
                    inicio = false;
                }
                break;

            case R.id.btn_c:
                txtPrevio.setText("");
                txtPrincipal.setText("0");
                inicio = true;
                funciones = "";
                operacion1 = true;
                operacion2 = true;
                igual = true;
                valor1 = 0;
                valor2 = 0;
                resultado = 0;
                break;

            case R.id.btn_ce:
                txtPrevio.setText("");
                txtPrincipal.setText("0");
                inicio = true;
                funciones = "";
                break;
            case R.id.btn_pow:
                valor1 = Double.parseDouble(txtPrincipal.getText().toString());
                txtPrevio.setText("("+valor1+")^2");
                txtPrincipal.setText(Math.pow(valor1,2)+"");
                break;
            case R.id.btn_raiz:
                valor1 = Double.parseDouble(txtPrincipal.getText().toString());
                if(valor1 >= 0)
                {
                    txtPrevio.setText("√"+String.valueOf(valor1)+")");
                    txtPrincipal.setText(String.valueOf(Math.sqrt(valor1)));
                }
                else
                {
                    txtPrincipal.setText("Error");
                }
                break;
        }
    }



    private void funcion_click(String signo)
    {
        igual = true;
        inicio = true;
        previo = "";

        if (operacion1)
        {
//            valor1 = Convert.ToDouble(textBox_principal.Text);
//            txtBox_previo.Text = "";
//            txtBox_previo.Text += textBox_principal.Text + signo;
//            operacion1 = false;

            valor1 = Double.parseDouble(txtPrincipal.getText()+"");
            txtPrevio.setText("");
//            previo += txtPrincipal.getText() + signo;
            txtPrevio.setText(txtPrevio.getText().toString()+txtPrincipal.getText().toString()+signo);
            operacion1 = false;
        }
        else if (operacion2)
        {
//            valor2 = Convert.ToDouble(textBox_principal.Text);
//            txtBox_previo.Text += textBox_principal.Text + signo;
//            operacion2 = false;

            valor2 = Double.parseDouble(txtPrincipal.getText().toString());
//            previo += txtPrincipal.getText()+signo;
            txtPrevio.setText(txtPrevio.getText().toString()+txtPrincipal.getText().toString()+signo);
            operacion2 = false;
        }
        else
        {
            //txtBox_previo.Text += textBox_principal.Text + signo;
            Operaciones(resultado, valor2);

//            previo += txtPrincipal.getText() + signo;
            txtPrevio.setText(txtPrevio.getText().toString()+txtPrincipal.getText().toString()+signo);

        }
        tipoOperaciones = signo;
    }


    private void Operaciones(double valor1,double valor2)
    {
        switch (tipoOperaciones)
        {
            case "+":
                resultado = valor1 + valor2;
                txtPrincipal.setText(String.format("%s", resultado));
                valor1 = Double.parseDouble(txtPrincipal.getText().toString());
                break;
            case "-":
                resultado = valor1 - valor2;
                txtPrincipal.setText(resultado+"");
                valor1 = Double.parseDouble(txtPrincipal.getText().toString());
                break;
            case "*":
                resultado = valor1 * valor2;
                txtPrincipal.setText(String.format("%s", resultado));
                valor1 = Double.parseDouble(txtPrincipal.getText().toString());
                break;
            case "/":
                if(valor2 == 0)
                {
                    txtPrincipal.setText("Error");
                }
                else
                {
                    resultado = valor1 / valor2;
                    txtPrincipal.setText(String.format("%s", resultado));
                    valor1 = Double.parseDouble(txtPrincipal.getText().toString());
                }
                break;
            case "Potencia":
                resultado = Math.pow(valor1, valor2);
                txtPrincipal.setText(String.format("%s", resultado));
                valor1 = Double.parseDouble(txtPrincipal.getText().toString());
                break;

        }
    }

    private void numero_Click(int n)
    {
        if (inicio)
        {
            txtPrincipal.setText("");
            txtPrincipal.setText(n +"");
            inicio = false;
        }
        else
        {
//            principal += n+"";
            txtPrincipal.setText(txtPrincipal.getText().toString()+n);
        }
    }
}
