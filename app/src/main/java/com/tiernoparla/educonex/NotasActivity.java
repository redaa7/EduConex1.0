package com.tiernoparla.educonex;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        // Obtener referencias a los elementos de la interfaz de usuario
        TextView textViewAsignatura = findViewById(R.id.textViewAsignatura);
        TextView textViewNotas = findViewById(R.id.textViewNotas);

        // Obtener la información de la asignatura desde el Intent
        String asignatura = getIntent().getStringExtra("asignatura");

        // Configurar el TextView de la asignatura
        textViewAsignatura.setText("Notas de " + asignatura);

        // Obtener la información de las notas desde el Intent
        String notas = getIntent().getStringExtra("notas");

        // Configurar el TextView de las notas
        textViewNotas.setText(notas);
    }
}
