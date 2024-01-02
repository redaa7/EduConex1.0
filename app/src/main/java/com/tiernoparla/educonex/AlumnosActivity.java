// AlumnosActivity.java
package com.tiernoparla.educonex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AlumnosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);

        // Obtener el listado de alumnos común para todas las asignaturas
        List<String> alumnos = obtenerListadoAlumnos();

        // Ordenar la lista de alumnos
        Collections.sort(alumnos);

        // Configurar el adaptador para la ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alumnos);

        // Configurar la ListView
        ListView listViewAlumnos = findViewById(R.id.listViewAlumnos);
        listViewAlumnos.setAdapter(adapter);

        // Configurar el clic en un nombre de usuario
        listViewAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtener el nombre del usuario seleccionado
                String usuarioSeleccionado = (String) parent.getItemAtPosition(position);

                // Iniciar la actividad de edición de usuario
                Intent intent = new Intent(AlumnosActivity.this, EditarUsuarioActivity.class);
                intent.putExtra("nombreUsuario", usuarioSeleccionado);
                startActivity(intent);
            }
        });
    }

    private List<String> obtenerListadoAlumnos() {
        List<String> nombres = new ArrayList<>();

        // Generar 15 nombres y apellidos aleatorios
        for (int i = 0; i < 15; i++) {
            String nombre = generateRandomNombre();
            String apellido = generateRandomApellido();
            nombres.add(nombre + " " + apellido);
        }

        return nombres;
    }

    private String generateRandomNombre() {
        String[] nombres = {"Juan", "Ana", "Carlos", "María", "Pedro", "Laura", "José", "Sofía", "David", "Elena"};
        Random random = new Random();
        return nombres[random.nextInt(nombres.length)];
    }

    private String generateRandomApellido() {
        String[] apellidos = {"Gómez", "Martínez", "Fernández", "López", "Rodríguez", "Pérez", "García", "Sánchez", "Romero", "Díaz"};
        Random random = new Random();
        return apellidos[random.nextInt(apellidos.length)];
    }
}
