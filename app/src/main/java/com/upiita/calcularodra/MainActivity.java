package com.upiita.calcularodra;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView pantalla;
    double var1 = 0;
    double var2 = 0;
    double resultado = 0;
    int oper = 0;  // 0: sin operación, 1: suma, 2: resta, 3: multiplicación, 4: división
    boolean nuevaOperacion = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantalla = findViewById(R.id.pantalla);
        // Botones de números
        Button bt0 = findViewById(R.id.bt0);
        Button bt1 = findViewById(R.id.bt1);
        Button bt2 = findViewById(R.id.bt2);
        Button bt3 = findViewById(R.id.bt3);
        Button bt4 = findViewById(R.id.bt4);
        Button bt5 = findViewById(R.id.bt5);
        Button bt6 = findViewById(R.id.bt6);
        Button bt7 = findViewById(R.id.bt7);
        Button bt8 = findViewById(R.id.bt8);
        Button bt9 = findViewById(R.id.bt9);
        Button btPunto = findViewById(R.id.btPunto);

        // Botones de operaciones
        Button btSuma = findViewById(R.id.btSuma);
        Button btResta = findViewById(R.id.btResta);
        Button btMult = findViewById(R.id.btMult);
        Button btDivision = findViewById(R.id.btDivision);
        Button btIgual = findViewById(R.id.btIgual);
        Button btC = findViewById(R.id.btC);
        Button btAC = findViewById(R.id.btAC);
        Button btSigno = findViewById(R.id.btsigno);
        Button btCuad = findViewById(R.id.btCuad);
        Button btRaiz = findViewById(R.id.btRaiz);

        bt0.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        btPunto.setOnClickListener(this);
        btSuma.setOnClickListener(this);
        btResta.setOnClickListener(this);
        btMult.setOnClickListener(this);
        btDivision.setOnClickListener(this);
        btIgual.setOnClickListener(this);
        btC.setOnClickListener(this);
        btAC.setOnClickListener(this);
        btSigno.setOnClickListener(this);
        btCuad.setOnClickListener(this);
        btRaiz.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.bt0) {
            agregarNumero("0");
        } else if (id == R.id.bt1) {
            agregarNumero("1");
        } else if (id == R.id.bt2) {
            agregarNumero("2");
        } else if (id == R.id.bt3) {
            agregarNumero("3");
        } else if (id == R.id.bt4) {
            agregarNumero("4");
        } else if (id == R.id.bt5) {
            agregarNumero("5");
        } else if (id == R.id.bt6) {
            agregarNumero("6");
        } else if (id == R.id.bt7) {
            agregarNumero("7");
        } else if (id == R.id.bt8) {
            agregarNumero("8");
        } else if (id == R.id.bt9) {
            agregarNumero("9");
        } else if (id == R.id.btPunto) {
            agregarPunto();
        } else if (id == R.id.btSuma) {
            realizarOperacion(1);
        } else if (id == R.id.btResta) {
            realizarOperacion(2);
        } else if (id == R.id.btMult) {
            realizarOperacion(3);
        } else if (id == R.id.btDivision) {
            realizarOperacion(4);
        } else if (id == R.id.btIgual) {
            calcularResultado();
        } else if (id == R.id.btC) {
            limpiarPantalla();
        } else if (id == R.id.btAC) {
            resetearCalculadora();
        } else if (id == R.id.btsigno) {
            cambiarSigno();
        } else if (id == R.id.btCuad) {
            elevarCuadrado();
        } else if (id == R.id.btRaiz) {
            calcularRaiz();
        }
    }

    private void agregarNumero(String numero) {
        if (nuevaOperacion) {
            pantalla.setText(numero);
            nuevaOperacion = false;
        } else {
            pantalla.append(numero);
        }
    }

    private void agregarPunto() {
        if (nuevaOperacion) {
            pantalla.setText("0.");
            nuevaOperacion = false;
        } else if (!pantalla.getText().toString().contains(".")) {
            pantalla.append(".");
        }
    }

    private void realizarOperacion(int operacion) {
        var1 = Double.parseDouble(pantalla.getText().toString());
        oper = operacion;
        nuevaOperacion = true;
    }

    private void calcularResultado() {
        var2 = Double.parseDouble(pantalla.getText().toString());
        switch (oper) {
            case 1: // Suma
                resultado = var1 + var2;
                break;
            case 2: // Resta
                resultado = var1 - var2;
                break;
            case 3: // Multiplicación
                resultado = var1 * var2;
                break;
            case 4: // División
                if (var2 != 0) {
                    resultado = var1 / var2;
                } else {
                    pantalla.setText("Error");
                    return;
                }
                break;
        }
        pantalla.setText(String.valueOf(resultado));
        nuevaOperacion = true;
    }

    private void limpiarPantalla() {
        pantalla.setText("0");
        nuevaOperacion = true;
    }

    private void resetearCalculadora() {
        pantalla.setText("0");
        var1 = 0;
        var2 = 0;
        resultado = 0;
        oper = 0;
        nuevaOperacion = true;
    }

    private void cambiarSigno() {
        double valor = Double.parseDouble(pantalla.getText().toString());
        valor = -valor;
        pantalla.setText(String.valueOf(valor));
    }

    private void elevarCuadrado() {
        double valor = Double.parseDouble(pantalla.getText().toString());
        resultado = Math.pow(valor, 2);
        pantalla.setText(String.valueOf(resultado));
        nuevaOperacion = true;
    }

    private void calcularRaiz() {
        double valor = Double.parseDouble(pantalla.getText().toString());
        if (valor >= 0) {
            resultado = Math.sqrt(valor);
            pantalla.setText(String.valueOf(resultado));
        } else {
            pantalla.setText("Error");
        }
        nuevaOperacion = true;
    }
}