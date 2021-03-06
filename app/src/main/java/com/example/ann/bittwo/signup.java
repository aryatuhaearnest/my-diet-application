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
import android.widget.ProgressBar;
import android.widget.TextView;
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
TextView tx=findViewById(R.id.textView7);
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
                checkDataEntered(email.getText().toString(),password.getText().toString(),confirm.getText().toString());
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
    void checkDataEntered(String mail,String Passowrd,String conf) {

        if (TextUtils.isEmpty(mail)) {
            email.setError("Enter valid email");
        }
           else if (TextUtils.isEmpty(Passowrd)) {
                password.setError("password is required");
            }

               else if (TextUtils.isEmpty(conf)) {
                confirm.setError("password needs confirmation");
            }
            else if (!Passowrd.equals(conf)) {
                confirm.setError("Password doesnot match");
            }
            else{
                progressDialog.setTitle("ACTION PERFOMING");
            progressDialog.setCancelable(false);
                progressDialog.show();


                mAuth.createUserWithEmailAndPassword(mail,Passowrd)
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
    public void logg(View view){
        Intent intent=new Intent(signup.this,login.class);
        startActivity(intent);
    }
}

