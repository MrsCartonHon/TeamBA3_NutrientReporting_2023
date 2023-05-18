package com.example.teamba3_nutrientreporting_2023;

import android.app.Notification;
import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText emailTextView, passwordTextView;
    private ProgressBar progressbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // taking FirebaseAuth instance
        mAuth = FirebaseAuth.getInstance();

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        } //Hides Action Bars

        // initialising all views through id defined above
        emailTextView = findViewById(R.id.email);
        passwordTextView = findViewById(R.id.passwd);
        Button btn = findViewById(R.id.btnregister);
        progressbar = findViewById(R.id.progressbar);

        // Set on Click Listener on Registration button
        btn.setOnClickListener(view -> registerNewUser());
    }

    private void registerNewUser() {
        // show the visibility of progress bar to show loading
        progressbar.setVisibility(View.VISIBLE);

        // Take the value of two edit texts in Strings
        String email, password;
        email = emailTextView.getText().toString();
        password = passwordTextView.getText().toString();

        // Validations for input email and password
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(
                    getApplicationContext(),
                    "Please enter email!!",
                    Toast.LENGTH_LONG
            ).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                "Please enter password!!",
                    Toast.LENGTH_LONG
            ).show();
            return;
        }

        // create new user or register new user
        mAuth
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(task -> {
                Notification.Builder progressBar = null;
                if (task.isSuccessful()) {
                    Toast.makeText(
                            getApplicationContext(),
                            "Registration successful!",
                            Toast.LENGTH_LONG
                    ).show();

                    // hide the progress bar
                    progressBar.setVisibility(Notification.VISIBILITY_PRIVATE);

                    // if the user created intent to login activity
                    Intent intent = new Intent(
                            RegistrationActivity.this,
                            MainActivity.class);
                    startActivity(intent);
                }
                else {

                    // Registration failed
                    Toast.makeText(
                            getApplicationContext(),
                            "Registration failed!!"
                            + " Please try again later",
                            Toast.LENGTH_LONG
                    ).show();

                    // hide the progress bar
                    progressBar.setVisibility(Notification.VISIBILITY_PUBLIC);
                }
            }
        );
    }
}
