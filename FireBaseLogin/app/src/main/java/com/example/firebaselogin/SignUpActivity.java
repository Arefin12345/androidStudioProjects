package com.example.firebaselogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText signUpEmailEditText,signUpPasswordEditText;
    private TextView signInTextView;
    private Button signUpBtn;
    private ProgressBar progressBar;

    //Authenticate FireBase
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("Sign Up Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        signUpEmailEditText = (EditText) findViewById(R.id.signupemailAddressid);
        signUpPasswordEditText = (EditText) findViewById(R.id.signuppasswordid);

        signUpBtn = (Button) findViewById(R.id.signUpButtonId);
        signInTextView = (TextView) findViewById(R.id.signUpButtonId);

        signUpBtn.setOnClickListener(this);

        signInTextView.setOnClickListener(this);

        progressBar = (ProgressBar) findViewById(R.id.pogressBarId);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUpButtonId:
                userRegister();
                break;
//            case R.id.signUpButtonId:
//                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(intent);
//                break;
        }

    }

    private void userRegister() {
        progressBar.setVisibility(View.VISIBLE);
        String email = signUpEmailEditText.getText().toString().trim();
        String password = signUpPasswordEditText.getText().toString().trim();

        //Email Authentication

            if (email.isEmpty()) {
            signUpEmailEditText.setError("Enter A Valid Email Address");
            signUpEmailEditText.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signUpEmailEditText.setError("Enter A Valid Email Address");
            signUpEmailEditText.requestFocus();
            return;

        }

        //Password Authentication

        if (password.length() < 6) {
            signUpPasswordEditText.setError("Minimum Length Of Password is 6");
            signUpPasswordEditText.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    finish();
                    Intent intent = new Intent(getApplicationContext(),Menu.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    //If User Is Already Registered
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(), "User Is Already Registered ???", Toast.LENGTH_SHORT);
                    }else{
                        Toast.makeText(getApplicationContext(), "Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT);
                    }
                }
            }
        });

    }

}

