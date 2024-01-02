package com.tiernoparla.educonex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AsignaturasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);

        // Obtener referencias a los elementos de la interfaz de usuario
        TextView textViewProfesor = findViewById(R.id.textViewProfesor);
        TextView textAppNameProfesor = findViewById(R.id.textAppNameProfesor);
        LinearLayout linearLayoutAsignaturas = findViewById(R.id.linearLayoutAsignaturas);

        // Obtener el nombre del profesor y el tipo de usuario del Intent
        String professorName = getIntent().getStringExtra("professorName");
        String usernameType = getIntent().getStringExtra("usernameType");

        // Configurar los TextViews según el tipo de usuario
        if ("profesor".equals(usernameType)) {
            textViewProfesor.setText("Profesor: " + professorName);
            textAppNameProfesor.setText("EduConex (Profesor)");
        } else if ("alumno".equals(usernameType)) {
            // Ocultar el TextView del profesor para usuarios tipo "alumno"
            textViewProfesor.setVisibility(View.GONE);
            // Configurar el texto de la aplicación para usuarios tipo "alumno"
            textAppNameProfesor.setText("EduConex (Alumno)");
        } else {
            // Tipo de usuario no reconocido, puedes manejarlo según tus necesidades
            textViewProfesor.setVisibility(View.GONE);
            textAppNameProfesor.setText("EduConex");
        }

        // Obtener la lista de asignaturas según el tipo de usuario
        String[] asignaturas;
        if ("profesor".equals(usernameType)) {
            // Obtener la lista de asignaturas desde el archivo de recursos
            asignaturas = getResources().getStringArray(R.array.professor_subjects);
        } else if ("alumno".equals(usernameType)) {
            // Asignaturas para alumno
            asignaturas = new String[]{"Desarrollo de Aplicaciones Móviles", "Diseño de Bases de Datos", "Programación Avanzada", "Redes y Comunicaciones", "Desarrollo Web"};
        } else {
            // Tipo de usuario no reconocido, puedes manejarlo según tus necesidades
            asignaturas = new String[0];
        }

        // Agregar dinámicamente las asignaturas
        for (String asignatura : asignaturas) {
            TextView textViewAsignatura = new TextView(this);
            textViewAsignatura.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            textViewAsignatura.setText(asignatura);
            textViewAsignatura.setBackgroundResource(R.color.colorAccent);  // Ajusta el fondo según tu diseño
            textViewAsignatura.setPadding(16, 16, 16, 16);  // Ajusta el relleno según tu diseño

            // Ajustar el margen inferior (en píxeles)
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) textViewAsignatura.getLayoutParams();
            layoutParams.bottomMargin = 8;  // Ajusta el margen inferior según tu diseño

            // Agregar un listener para manejar el clic en la asignatura
            textViewAsignatura.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Manejar el clic en la asignatura
                    Toast.makeText(AsignaturasActivity.this, "Mostrar notas de " + asignatura, Toast.LENGTH_SHORT).show();

                    // Redirigir a la actividad que muestra las notas
                    Intent intent = new Intent(AsignaturasActivity.this, NotasActivity.class);
                    intent.putExtra("asignatura", asignatura);
                    startActivity(intent);
                }
            });

            linearLayoutAsignaturas.addView(textViewAsignatura);
        }
    }
}
