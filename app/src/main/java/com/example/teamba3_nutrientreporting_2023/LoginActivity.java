package com.example.teamba3_nutrientreporting_2023;

//import android.support.v7.app.AppCompatActivity;
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


public class LoginActivity extends AppCompatActivity {

    private EditText emailTextView, passwordTextView;
    private ProgressBar progressbar;

    private FirebaseAuth mAuth;
    public void goToRegister(View view){
        Intent itent = new Intent(LoginActivity.this, RegistrationActivity.class);
        LoginActivity.this.startActivity(itent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // taking instance of FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        // initialising all views through id defined above
        emailTextView = findViewById(R.id.email);
        passwordTextView = findViewById(R.id.password);
        Button btn = findViewById(R.id.login);
        progressbar = findViewById(R.id.progressBar);

        // Set on Click Listener on Sign-in button
        btn.setOnClickListener(view -> loginUserAccount());
    }

    private void loginUserAccount()
    {

        // show the visibility of progress bar to show loading
        progressbar.setVisibility(View.VISIBLE);

        // Take the value of two edit texts in Strings
        String email, password;
        email = emailTextView.getText().toString();
        password = passwordTextView.getText().toString();

        // validations for input email and password
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(
                    getApplicationContext(),
                    "Please enter email!!",
                    Toast.LENGTH_LONG
            ).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(
                    getApplicationContext(),
                    "Please enter password!!",
                    Toast.LENGTH_LONG
            ).show();
            return;
        }

        // signin existing user
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                    Toast.makeText(
                            getApplicationContext(),
                            "Login successful!!",
                            Toast.LENGTH_LONG
                    ).show();

                    // hide the progress bar
                    //progressBar.setVisibility(View.GONE);

                    // if sign-in is successful
                    // intent to home activity
                    Intent intent = new Intent(
                            LoginActivity.this,
                            MainActivity.class);
                    startActivity(intent);
                } else {
                    // sign-in failed
                    Toast.makeText(
                            getApplicationContext(),
                            "Login failed!!",
                            Toast.LENGTH_LONG
                    ).show();

                    // hide the progress bar
                    progressbar.setVisibility(View.GONE);
                }
            }
        );
    }
}
