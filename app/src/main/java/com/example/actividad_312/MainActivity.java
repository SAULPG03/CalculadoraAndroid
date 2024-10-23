package com.example.actividad_312;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

//Esta clase
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //ATRINUTOS

    //Botonoes numericos
    private  Button btnButton_0;
    private  Button btnButton_1;
    private  Button btnButton_2;
    private  Button btnButton_3;
    private  Button btnButton_4;
    private  Button btnButton_5;
    private  Button btnButton_6;
    private  Button btnButton_7;
    private  Button btnButton_8;
    private  Button btnButton_9;

    //Botonoes de operaciones
    private Button btnSumar,btnRestar,btnMultiplicar,btnDividir;

    //Botones de Control
    private Button btnResultado;
    private Button btnDelete;

    //LCD
    private EditText lcd;

    //Atributo para la logica de operacion
    private int operando1;
    private int operando2;
    private char operacion;
    private String strResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Enlazar los atributos con las vistas
        btnButton_0=findViewById(R.id.btnButton0);
        btnButton_1=findViewById(R.id.btnButton1);
        btnButton_2=findViewById(R.id.btnButton2);
        btnButton_3=findViewById(R.id.btnButton3);
        btnButton_4=findViewById(R.id.btnButton4);
        btnButton_5=findViewById(R.id.btnButton5);
        btnButton_6=findViewById(R.id.btnButton6);
        btnButton_7=findViewById(R.id.btnButton7);
        btnButton_8=findViewById(R.id.btnButton8);
        btnButton_9=findViewById(R.id.btnButton9);

        //Asignar el manejador de eventos de los botones numericos
        btnButton_0.setOnClickListener(this);
        btnButton_1.setOnClickListener(this);
        btnButton_2.setOnClickListener(this);
        btnButton_3.setOnClickListener(this);
        btnButton_4.setOnClickListener(this);
        btnButton_5.setOnClickListener(this);
        btnButton_6.setOnClickListener(this);
        btnButton_7.setOnClickListener(this);
        btnButton_8.setOnClickListener(this);
        btnButton_9.setOnClickListener(this);

        //Enlaza con la vista los botones de operaciones
        btnSumar= (Button) findViewById(R.id.btnButtonSumar);
        btnRestar= (Button) findViewById(R.id.btnButtonRestar);
        btnMultiplicar= (Button) findViewById(R.id.btnButtonMulti);
        btnDividir= (Button) findViewById(R.id.btnButtonDivision);

        //Manejadores de eventos de los botones de operaciones
        btnSumar.setOnClickListener(this);
        btnRestar.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);
        btnDividir.setOnClickListener(this);

        //Botones de control
        btnResultado=findViewById(R.id.btnButtonIgual);
        btnDelete=findViewById(R.id.btnButtonDelete);
        btnResultado.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

        //Enlaza con la pantalla
        lcd=findViewById(R.id.tvPantalla);

        Reset();

    }

    //Inicializar la calculadora
    void Reset(){

    }

    //Logica de funcionamiento
    @Override
    public void onClick(View v){
        //Identifica el origen del evento
        if(v.getId()==R.id.btnButton0){
            //Gestiona el boton 0

        }else if(v.getId()==R.id.btnButton1){
            //Gestiona el boton 1
            btnButton_1.getText();
        }else if(v.getId()==R.id.btnButton2){
            //Gestiona el boton 2

        } else if (v.getId()==R.id.btnButton3){
            //Gestiona el boton 3

        } else if (v.getId()==R.id.btnButton4) {
            //Gestiona el boton 4

        } else if (v.getId()==R.id.btnButton5) {
            //Gestiona el boton 5

        } else if (v.getId()==R.id.btnButton6) {
            //Gestiona el boton 6

        } else if (v.getId()==R.id.btnButton7) {
            //Gestiona el boton 7

        } else if (v.getId()==R.id.btnButton8) {
            //Gestiona el boton 8

        } else if (v.getId()==R.id.btnButton9) {
            //Gestiona el boton 9

        }
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
