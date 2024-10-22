package com.example.actividad_312;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText pantalla;
    private double valor1 = 0, valor2 = 0;
    private boolean suma, resta, multiplicacion, division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantalla = findViewById(R.id.tvPantalla);

        // Configurar los listeners de los botones numéricos
        View.OnClickListener listenerNumerico = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                pantalla.append(b.getText().toString());
            }
        };

        // Asignar listeners a los botones
        int[] idsBotonesNumericos = {
                R.id.btnButton0, R.id.btnButton1, R.id.btnButton2,
                R.id.btnButton3, R.id.btnButton4, R.id.btnButton5,
                R.id.btnButton6, R.id.btnButton7, R.id.btnButton8, R.id.btnButton9
        };

        for (int id : idsBotonesNumericos) {
            findViewById(id).setOnClickListener(listenerNumerico);
        }

        // Manejo de las operaciones
        findViewById(R.id.btnButtonSumar).setOnClickListener(v -> operar("+"));
        findViewById(R.id.btnButtonRestar).setOnClickListener(v -> operar("-"));
        findViewById(R.id.btnButtonMulti).setOnClickListener(v -> operar("*"));
        findViewById(R.id.btnButtonDivision).setOnClickListener(v -> operar("/"));

        // Botón de igual
        findViewById(R.id.btnButtonIgual).setOnClickListener(v -> calcularResultado());

        // Botón de borrar
        findViewById(R.id.btnButtonDelete).setOnClickListener(v -> pantalla.setText(""));
    }

    private void operar(String operacion) {
        if (!pantalla.getText().toString().isEmpty()) {
            valor1 = Double.parseDouble(pantalla.getText().toString());
            pantalla.setText("");
            switch (operacion) {
                case "+": suma = true; break;
                case "-": resta = true; break;
                case "*": multiplicacion = true; break;
                case "/": division = true; break;
            }
        } else {
            Toast.makeText(this, "Introduce un número", Toast.LENGTH_SHORT).show();
        }
    }

    private void calcularResultado() {
        if (!pantalla.getText().toString().isEmpty()) {
            valor2 = Double.parseDouble(pantalla.getText().toString());
            double resultado = 0;

            if (suma) {
                resultado = valor1 + valor2;
                suma = false;
            } else if (resta) {
                resultado = valor1 - valor2;
                resta = false;
            } else if (multiplicacion) {
                resultado = valor1 * valor2;
                multiplicacion = false;
            } else if (division) {
                if (valor2 != 0) {
                    resultado = valor1 / valor2;
                } else {
                    Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                division = false;
            }

            pantalla.setText(String.valueOf(resultado));
        } else {
            Toast.makeText(this, "Introduce un número para operar", Toast.LENGTH_SHORT).show();
        }
    }
}
