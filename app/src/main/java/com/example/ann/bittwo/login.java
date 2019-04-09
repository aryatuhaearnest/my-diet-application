package com.example.ann.bittwo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button login;
    private FirebaseAuth mA;
    ProgressDialog progressDialog;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mA = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText3);
        login = (Button) findViewById(R.id.button);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("please wait.......");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(com.example.ann.bittwo.login.this, nutrition.class);
                startActivity(myintent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                checkDataEntered(email.getText().toString(), password.getText().toString());
            }
        });
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    void checkDataEntered(String mail, String Passowrd) {
        if (TextUtils.isEmpty(mail)) {
            email.setError("Enter valid email");
        } else if (TextUtils.isEmpty(Passowrd)) {
            password.setError("password is required");
        } else {
            progressDialog.setTitle("ACTION PERFOMING");
            progressDialog.show();
            mA.signInWithEmailAndPassword(mail, Passowrd)
                    .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "login sucessfully", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(login.this, Activity1.class);
                                startActivity(intent);
                                finish();
                                progressDialog.hide();

                            } else {
                                Toast.makeText(getApplicationContext(), "Error user not found check your internet try again...", Toast.LENGTH_LONG).show();
                                progressDialog.hide();
                            }
                        }
                    });
        }
    }
}