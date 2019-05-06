package com.example.ann.bittwo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private EditText emai;
    private EditText passwor;
    private Button login;
    private FirebaseAuth mA;
    ProgressDialog progressDialog;
    private SharedPreferences nPreferences;
    private SharedPreferences.Editor nEditor;
    private CheckBox ncheckBox;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        TextView textView=findViewById(R.id.textView9);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mA = FirebaseAuth.getInstance();
        emai = (EditText) findViewById(R.id.editText);
        passwor = (EditText) findViewById(R.id.editText3);
        login = (Button) findViewById(R.id.button);
        ncheckBox=(CheckBox)findViewById(R.id.checkBox);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("please wait.......");

        nPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        nEditor=nPreferences.edit();

        CheckSharedPreferences();


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
                checkDataEntered(emai.getText().toString(), passwor.getText().toString());
                if(ncheckBox.isChecked()){
                    nEditor.putString(getString(R.string.checkbox),"True");
                    nEditor.commit();

                    String email=emai.getText().toString();
                    nEditor.putString(getString(R.string.email),email);
                    nEditor.commit();

                    String password=passwor.getText().toString();
                    nEditor.putString(getString(R.string.password),password);
                    nEditor.commit();
                }else{
                    nEditor.putString(getString(R.string.checkbox),"False");
                    nEditor.commit();


                    nEditor.putString(getString(R.string.email),"");
                    nEditor.commit();


                    nEditor.putString(getString(R.string.password),"");
                    nEditor.commit();
                }
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
            emai.setError("Enter valid email");
        } else if (TextUtils.isEmpty(Passowrd)) {
            passwor.setError("password is required");
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
                                progressDialog.setCancelable(false);
                                progressDialog.hide();

                            } else {
                                Toast.makeText(getApplicationContext(), "Error user not found check your internet try again...", Toast.LENGTH_LONG).show();
                                progressDialog.hide();
                            }
                        }
                    });
        }
    }
    public void cash(View view){
        Intent intents=new Intent(com.example.ann.bittwo.login.this,signup.class);
       startActivity(intents);
    }
    public void CheckSharedPreferences(){
        String checkbox=nPreferences.getString(getString(R.string.checkbox),"False");
        String email=nPreferences.getString(getString(R.string.email),"");
        String password=nPreferences.getString(getString(R.string.password),"");

      emai.setText(email);
       passwor.setText(password);
       if(checkbox.equals("True")){
           ncheckBox.setChecked(true);
       }else{
           ncheckBox.setChecked(false);
       }
    }
}