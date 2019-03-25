package com.example.ann.bittwo;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private EditText confirm;
    private Button SignUp;
    private FirebaseAuth mAuth;

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        mAuth = FirebaseAuth.getInstance();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        email = (EditText) findViewById(R.id.editText4);
        password = (EditText) findViewById(R.id.editText5);
        confirm = (EditText) findViewById(R.id.confirm);
        SignUp = (Button) findViewById(R.id.button4);

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("please wait.......");

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDataEntered();
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

    void checkDataEntered() {

        if (TextUtils.isEmpty(email.getText())) {
            email.setError("Enter valid email");

           if (isEmpty(password)) {
                password.setError("password is required");
            }
            if (isEmpty(confirm)) {
                confirm.setError("password needs confirmation");
            }
            if (!password.equals(confirm)) {
                confirm.setError("Password doesnot match");
            }
            else
                progressDialog.show();

            {
                mAuth.createUserWithEmailAndPassword(email.toString(), password.toString())
                        .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "added sucessfully", Toast.LENGTH_LONG).show();
                                    email.setText("");
                                    password.setText("");
                                    confirm.setText("");
                                    email.requestFocus();
                                    progressDialog.hide();

                                } else {
                                    email.setText("");
                                    password.setText("");
                                    confirm.setText("");
                                    email.requestFocus();
                                    progressDialog.hide();
                                    Toast.makeText(getApplicationContext(), "Error occured ", Toast.LENGTH_LONG).show();

                                }
                            }
                        });
            }

        }
    }
}

