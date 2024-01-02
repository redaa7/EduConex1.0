package com.tiernoparla.educonex;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private TextView textAppName;
    private TextView textDateTime;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        // Inicializar Firebase Realtime Database
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        // Aquí debes proporcionar el nombre de la rama (o nodo) de la base de datos que deseas utilizar
        databaseReference = firebaseDatabase.getReference("tu_rama_en_firebase");

        // Obtener referencias a los elementos de la interfaz de usuario
        textAppName = findViewById(R.id.textAppName);
        textDateTime = findViewById(R.id.textDateTime);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Configurar el nombre de la aplicación
        textAppName.setText("EduConex");

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

        // Configurar el listener para el botón de inicio de sesión
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el nombre de usuario y la contraseña ingresados
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Lógica de inicio de sesión
                if (isValidLogin(username, password)) {
                    // Iniciar sesión con Firebase
                    signInWithFirebase(username, password);
                } else {
                    showToast("Inicio de sesión fallido. Verifica tu nombre de usuario y contraseña.");
                }
            }
        });
    }

    private void signInWithFirebase(String username, String password) {
        mAuth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull com.google.android.gms.tasks.Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Inicio de sesión exitoso
                            showToast("Inicio de sesión exitoso");

                            // Redirigir a la actividad de asignaturas y pasar el tipo de usuario como extra
                            redirectToAsignaturasActivity(username);

                            // Guardar información en la base de datos de Firebase
                            saveLoginInfoToFirebase(username);
                        } else {
                            // Si el inicio de sesión falla, muestra un mensaje al usuario.
                            showToast("Inicio de sesión fallido. Verifica tus credenciales.");
                        }
                    }
                });
    }

    private boolean isValidLogin(String username, String password) {
        // En este ejemplo, simplemente verifica que ambos campos no estén vacíos
        return !username.isEmpty() && !password.isEmpty();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void updateDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss", new Locale("es", "ES"));
        String currentDateAndTime = sdf.format(new Date());
        textDateTime.setText(currentDateAndTime);
    }

    // Cambia el nombre del método a redirectToAsignaturasActivity
    private void redirectToAsignaturasActivity(String username) {
        Intent intent;
        if (username.equals("reda")) {
            // Redirigir a la actividad de asignaturas para el profesor
            intent = new Intent(this, AsignaturasActivity.class);
            intent.putExtra("usernameType", "profesor");
            intent.putExtra("professorName", "Reda"); // Cambia esto con el nombre real del profesor
        } else if (username.equals("adrian")) {
            // Redirigir a la actividad de asignaturas para el alumno
            intent = new Intent(this, AsignaturasActivity.class);
            intent.putExtra("usernameType", "alumno");
            intent.putExtra("alumnoName", "Adrian"); // Cambia esto con el nombre real del alumno
        } else {
            // Tipo de usuario no reconocido, puedes manejarlo según tus necesidades
            return;
        }
        startActivity(intent);
    }

    private void saveLoginInfoToFirebase(String username) {
        // Aquí puedes guardar información en la base de datos de Firebase
        // Por ejemplo, puedes almacenar el nombre de usuario y la fecha/hora del inicio de sesión
        String currentDateAndTime = getCurrentDateTime();
        databaseReference.child(username).child("loginInfo").setValue(currentDateAndTime);
    }

    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss", new Locale("es", "ES"));
        return sdf.format(new Date());
    }
}
