package com.example.p2historialactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etN1, etN2;
    private Button btnSumar, btnRestar, btnMultiplicar, btnDividir, btnHSumas, btnHRestas, btnHMultiplicacion, btnHDivisiones;
    private ArrayList<String> historialSumas = new ArrayList<>();
    private ArrayList<String> historialRestas = new ArrayList<>();
    private ArrayList<String> historialMultiplicaciones = new ArrayList<>();
    private ArrayList<String> historialDivisiones = new ArrayList<>();

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
        etN1 = findViewById(R.id.etN1);
        etN2 = findViewById(R.id.etN2);

        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);

        btnHSumas = findViewById(R.id.btnHSumas);
        btnHRestas = findViewById(R.id.btnHRestas);
        btnHMultiplicacion = findViewById(R.id.btnHMultiplicaciones);
        btnHDivisiones = findViewById(R.id.btnHDivisiones);

        etN1.setOnClickListener(this);
        etN2.setOnClickListener(this);
        btnSumar.setOnClickListener(this);
        btnRestar.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);
        btnDividir.setOnClickListener(this);
        btnHSumas.setOnClickListener(this);
        btnHRestas.setOnClickListener(this);
        btnHMultiplicacion.setOnClickListener(this);
        btnHDivisiones.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.etN1)
        {
            etN2.requestFocus();
        }else if(view.getId() == R.id.etN2)
        {
            btnSumar.requestFocus();
        } else if (view.getId() == R.id.btnSumar) {
            int n1 = Integer.parseInt(String.valueOf(etN1.getText()));
            int n2 = Integer.parseInt(String.valueOf(etN2.getText()));
            int suma = n1 + n2;
            String resultado = n1 + " + " + n2 + " = " + suma;
            historialSumas.add(resultado);
            Toast.makeText(this, "Suma:"+suma, Toast.LENGTH_SHORT).show();
            btnHSumas.requestFocus();
        } else if (view.getId() == R.id.btnRestar) {
            int n1 = Integer.parseInt(String.valueOf(etN1.getText()));
            int n2 = Integer.parseInt(String.valueOf(etN2.getText()));
            int resta = n1 - n2;
            String resultado = n1 + " - " + n2 + " = " + resta;
            historialRestas.add(resultado);
            Toast.makeText(this, "Resta:"+resta, Toast.LENGTH_SHORT).show();
            btnHRestas.requestFocus();
        } else if (view.getId() == R.id.btnMultiplicar) {
            int n1 = Integer.parseInt(String.valueOf(etN1.getText()));
            int n2 = Integer.parseInt(String.valueOf(etN2.getText()));
            int multiplicar = n1 * n2;
            String resultado = n1 + " * " + n2 + " = " + multiplicar;
            historialMultiplicaciones.add(resultado);
            Toast.makeText(this, "Multiplicacion:"+multiplicar, Toast.LENGTH_SHORT).show();
            btnHMultiplicacion.requestFocus();
        } else if (view.getId() == R.id.btnDividir) {
            int n1 = Integer.parseInt(String.valueOf(etN1.getText()));
            int n2 = Integer.parseInt(String.valueOf(etN2.getText()));
            int dividir = n1 / n2;
            String resultado = n1 + " / " + n2 + " = " + dividir;
            historialDivisiones.add(resultado);
            Toast.makeText(this, "Division:"+dividir, Toast.LENGTH_SHORT).show();
            btnHDivisiones.requestFocus();
        } else if (view.getId() == R.id.btnHSumas) {
            Intent i = new Intent(MainActivity.this, SumHistoryActivity.class);
            i.putStringArrayListExtra("historialSumas", historialSumas);
            startActivity(i);
        } else if (view.getId() == R.id.btnHRestas) {
            Intent i = new Intent(MainActivity.this, ResHistoryActivity.class);
            i.putStringArrayListExtra("historialRestas", historialRestas);
            startActivity(i);
        } else if (view.getId() == R.id.btnHMultiplicaciones) {
            Intent i = new Intent(MainActivity.this, MultiHistoryActivity.class);
            i.putStringArrayListExtra("historialMultiplicaciones", historialMultiplicaciones);
            startActivity(i);
        } else if (view.getId() == R.id.btnHDivisiones) {
            Intent i = new Intent(MainActivity.this, DiviHistoryActivity.class);
            i.putStringArrayListExtra("historialDivisiones", historialDivisiones);
            startActivity(i);
        }
    }
}