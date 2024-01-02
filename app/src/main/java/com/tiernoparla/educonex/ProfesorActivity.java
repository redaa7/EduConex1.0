// ProfesorActivity.java
package com.tiernoparla.educonex;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ProfesorActivity extends AppCompatActivity {

    private TextView textAppName;
    private TextView textViewProfesor;  // Agregado: TextView para mostrar el nombre del profesor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor);

        // Obtener referencias a los elementos de la interfaz de usuario
        textAppName = findViewById(R.id.textAppNameProfesor);
        textViewProfesor = findViewById(R.id.textViewProfesor);

        // Configurar el nombre de la aplicación
        textAppName.setText("EduConex (Profesor)");

        // Actualizar la fecha y la hora cada segundo
        updateDateTime();
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                updateDateTime();
                handler.postDelayed(this, 1000);
            }
        }, 1000);

        // Obtener el nombre del profesor del Intent
        Intent intent = getIntent();
        if (intent.hasExtra("professorName")) {
            String professorName = intent.getStringExtra("professorName");
            // Mostrar el nombre del profesor en el TextView correspondiente
            textViewProfesor.setText("Profesor: " + professorName);
        }

        // Agrega un OnClickListener a cada TextView de asignatura
        TextView asignatura1 = findViewById(R.id.asignatura1);
        asignatura1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inicia la nueva actividad y pasa la asignatura seleccionada como extra
                Intent intent = new Intent(ProfesorActivity.this, AlumnosActivity.class);
                intent.putExtra("asignaturaSeleccionada", "Desarrollo de Aplicaciones Móviles");
                startActivity(intent);
            }
        });

        TextView asignatura2 = findViewById(R.id.asignatura2);
        asignatura2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inicia la nueva actividad y pasa la asignatura seleccionada como extra
                Intent intent = new Intent(ProfesorActivity.this, AlumnosActivity.class);
                intent.putExtra("asignaturaSeleccionada", "Diseño de Bases de Datos");
                startActivity(intent);
            }
        });

        TextView asignatura3 = findViewById(R.id.asignatura3);
        asignatura3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inicia la nueva actividad y pasa la asignatura seleccionada como extra
                Intent intent = new Intent(ProfesorActivity.this, AlumnosActivity.class);
                intent.putExtra("asignaturaSeleccionada", "Programación Avanzada");
                startActivity(intent);
            }
        });

        TextView asignatura4 = findViewById(R.id.asignatura4);
        asignatura4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inicia la nueva actividad y pasa la asignatura seleccionada como extra
                Intent intent = new Intent(ProfesorActivity.this, AlumnosActivity.class);
                intent.putExtra("asignaturaSeleccionada", "Redes y Comunicaciones");
                startActivity(intent);
            }
        });

        TextView asignatura5 = findViewById(R.id.asignatura5);
        asignatura5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inicia la nueva actividad y pasa la asignatura seleccionada como extra
                Intent intent = new Intent(ProfesorActivity.this, AlumnosActivity.class);
                intent.putExtra("asignaturaSeleccionada", "Desarrollo Web");
                startActivity(intent);
            }
        });
    }

    private void updateDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss", new Locale("es", "ES"));
        String currentDateAndTime = sdf.format(new Date());
        // Puedes usar esta fecha y hora actualizada para algo si lo necesitas
    }
}
