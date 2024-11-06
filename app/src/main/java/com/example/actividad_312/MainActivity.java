/*
    Ejercicio propuestos:
        1. Propuestas pendientes
        2. Declaracion de atributos masivos NO LISTADO
        3. Enlaze de objetos con la Vista con bucle ejmplo Buttoni i=0 i=1...
        4. Asignacion de eventos en bucle
        5. onClick- Simplificar
 */

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
        operando1=0;
        operando2=0;
        strResultado="";
        lcd.setText(strResultado);
    }

    //Logica de funcionamiento
    //Ejercicio: onClick V2
    @Override
    public void onClick(View v){
        //Implementacion V1 (Primero y no definitiva)
        //Identifica el origen del evento
        if(v.getId()==R.id.btnButton0){
            //Gestiona el boton 0
            strResultado+="0";
            operando1= operando1 * 10;
            lcd.setText(strResultado);

        }else if(v.getId()==R.id.btnButton1){
            //Gestiona el boton 1
            strResultado+="1";
            operando1= (operando1 * 10 +1);
            lcd.setText(strResultado);

        }else if(v.getId()==R.id.btnButton2){
            //Gestiona el boton 2
            strResultado+="2";
            operando1= (operando1 * 10 +2);
            lcd.setText(strResultado);

        } else if (v.getId()==R.id.btnButton3){
            //Gestiona el boton 3
            strResultado+="3";
            operando1= (operando1 * 10 +3);
            lcd.setText(strResultado);

        } else if (v.getId()==R.id.btnButton4) {
            //Gestiona el boton 4
            strResultado+="4";
            operando1= (operando1 * 10 +4);
            lcd.setText(strResultado);

        } else if (v.getId()==R.id.btnButton5) {
            //Gestiona el boton 5
            strResultado+="5";
            operando1= (operando1 * 10 +5);
            lcd.setText(strResultado);

        } else if (v.getId()==R.id.btnButton6) {
            //Gestiona el boton 6
            strResultado+="6";
            operando1= (operando1 * 10 +6);
            lcd.setText(strResultado);

        } else if (v.getId()==R.id.btnButton7) {
            //Gestiona el boton 7
            strResultado+="7";
            operando1= (operando1 * 10 +7);
            lcd.setText(strResultado);

        } else if (v.getId()==R.id.btnButton8) {
            //Gestiona el boton 8
            strResultado+="8";
            operando1= (operando1 * 10 +8);
            lcd.setText(strResultado);

        } else if (v.getId()==R.id.btnButton9) {
            //Gestiona el boton 9
            strResultado+="9";
            operando1= (operando1 * 10 +9);
            lcd.setText(strResultado);

        } else if (v.getId()==R.id.btnButtonSumar) {
            operacion='+';
            strResultado+=operacion;
            lcd.setText((strResultado));

            //Cambio de operando
            operando2=operando1;
            operando1=0;

        } else if (v.getId()==R.id.btnButtonRestar) {
            operacion='-';
            strResultado+=operacion;
            lcd.setText((strResultado));

            //Cambio de operando
            operando2=operando1;
            operando1=0;
        } else if (v.getId()==R.id.btnButtonMulti) {
            operacion='x';
            strResultado+=operacion;
            lcd.setText((strResultado));

            //Cambio de operando
            operando2=operando1;
            operando1=0;

        } else if (v.getId()==R.id.btnButtonDelete) {
            operacion=0;
            operando2=0;
            strResultado="";
            lcd.setText("");

        } else if (v.getId()==R.id.btnButtonIgual) {
            // Calcula el resultado según la operación
            int resultado = 0;
            try {
                switch (operacion) {
                    case '+':
                        resultado = operando2 + operando1;
                        break;
                    case '-':
                        resultado = operando2 - operando1;
                        break;
                    case 'x':
                        resultado = operando2 * operando1;
                        break;
                    case '/':
                        if (operando1 == 0) {
                            lcd.setText("Error: División por 0");
                            return;
                        }
                        resultado = operando2 / operando1;
                        break;
                }
            } catch (Exception e) {
                lcd.setText("Error en cálculo");
                return;
            }

            // Muestra el resultado y reinicia operando1 para operaciones continuas
            strResultado += " = " + resultado;
            lcd.setText(strResultado);
            operando1 = resultado;
            strResultado = String.valueOf(resultado); // Reiniciamos el string
        }

    }
}
