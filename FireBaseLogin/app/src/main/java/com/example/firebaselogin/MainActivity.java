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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText signINEmailEditText,signInPasswordEditText;
    private TextView signUpTextView;
    private Button signInBtn;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("Sign In Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signINEmailEditText = (EditText) findViewById(R.id.emailAddressid);
        signInPasswordEditText = (EditText) findViewById(R.id.passwordid);

        signUpTextView = (TextView) findViewById(R.id.signupid);
        signInBtn = (Button) findViewById(R.id.signInButtonId);

        signUpTextView.setOnClickListener(this);
        signInBtn.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signInButtonId:
                userLogin();
                break;

            case R.id.signupid:
                Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
                break;
        }

        }

    private void userLogin() {
        String email = signINEmailEditText.getText().toString().trim();
        String password = signInPasswordEditText.getText().toString().trim();

        //Email Authentication

        if (email.isEmpty()) {
            signINEmailEditText.setError("Enter A Valid Email Address");
            signINEmailEditText.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signINEmailEditText.setError("Enter A Valid Email Address");
            signINEmailEditText.requestFocus();
            return;

        }

        //Password Authentication

        if (password.length() < 6) {
            signInPasswordEditText.setError("Minimum Length Of Password is 6");
            signInPasswordEditText.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    finish();
                    Intent intent = new Intent(getApplicationContext(),Menu.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Login Was Not Successful",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

