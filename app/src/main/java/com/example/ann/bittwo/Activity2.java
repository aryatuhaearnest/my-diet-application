package com.example.ann.bittwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    private EditText name;
    private EditText email;
    private EditText password;
    private Button SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        name=(EditText)findViewById(R.id.editText2);
        email=(EditText)findViewById(R.id.editText4);
        password=(EditText)findViewById(R.id.editText5);
        SignUp=(Button)findViewById(R.id.button4);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDataEntered();
            }
        });
    }

    boolean isEmpty(EditText text){
        CharSequence str=text.getText().toString();
        return TextUtils.isEmpty(str);

    }

    boolean isEmail(EditText text){
        CharSequence email=text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    void checkDataEntered(){
        if (isEmpty(name)){
            Toast t=Toast.makeText(this,"You must enter name",Toast.LENGTH_SHORT);
            t.show();
        }
       /* if (isEmail(email)=false) {
            email.setError("Enter valid email");
        }*/
        if (isEmpty(password)){
            password.setError("password is required");
        }
    }

    }

