// EditarUsuarioActivity.java
package com.tiernoparla.educonex;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EditarUsuarioActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextEdad;
    private EditText editTextFechaNacimiento;
    private EditText editTextTelefono;
    private EditText editTextCorreo;

    private String nombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextEdad = findViewById(R.id.editTextEdad);
        editTextFechaNacimiento = findViewById(R.id.editTextFechaNacimiento);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        editTextCorreo = findViewById(R.id.editTextCorreo);

        Button btnGuardarCambios = findViewById(R.id.btnGuardarCambios);

        // Obtener el nombre del usuario seleccionado del Intent
        nombreUsuario = getIntent().getStringExtra("nombreUsuario");

        // Mostrar el nombre del usuario en el TextView correspondiente
        TextView textViewNombre = findViewById(R.id.textViewNombre);
        textViewNombre.setText("Nombre del Alumno: " + nombreUsuario);

        // Cargar los datos actuales del alumno si existen
        cargarDatosAlumno();

        btnGuardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Guardar los cambios
                guardarCambiosAlumno();

                // Cerrar la actividad actual y volver al listado de alumnos
                finish();
            }
        });
    }

    private void cargarDatosAlumno() {
        // Utilizar SharedPreferences para cargar datos almacenados
        SharedPreferences preferences = getSharedPreferences("Alumnos", MODE_PRIVATE);

        // Obtener los datos almacenados para el alumno actual
        String nombre = preferences.getString(nombreUsuario + "_nombre", "");
        String edad = preferences.getString(nombreUsuario + "_edad", "");
        String fechaNacimiento = preferences.getString(nombreUsuario + "_fechaNacimiento", "");
        String telefono = preferences.getString(nombreUsuario + "_telefono", "");
        String correo = preferences.getString(nombreUsuario + "_correo", "");

        // Mostrar los datos en los EditText
        editTextNombre.setText(nombre);
        editTextEdad.setText(edad);
        editTextFechaNacimiento.setText(fechaNacimiento);
        editTextTelefono.setText(telefono);
        editTextCorreo.setText(correo);
    }

    private void guardarCambiosAlumno() {
        // Utilizar SharedPreferences para guardar datos
        SharedPreferences preferences = getSharedPreferences("Alumnos", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        // Obtener los nuevos datos del alumno desde los EditText
        String nuevoNombre = editTextNombre.getText().toString();
        String nuevaEdad = editTextEdad.getText().toString();
        String nuevaFechaNacimiento = editTextFechaNacimiento.getText().toString();
        String nuevoTelefono = editTextTelefono.getText().toString();
        String nuevoCorreo = editTextCorreo.getText().toString();

        // Guardar los nuevos datos
        editor.putString(nombreUsuario + "_nombre", nuevoNombre);
        editor.putString(nombreUsuario + "_edad", nuevaEdad);
        editor.putString(nombreUsuario + "_fechaNacimiento", nuevaFechaNacimiento);
        editor.putString(nombreUsuario + "_telefono", nuevoTelefono);
        editor.putString(nombreUsuario + "_correo", nuevoCorreo);

        // Aplicar los cambios
        editor.apply();
    }
}
