package com.example.ann.bittwo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button login;
    private FirebaseAuth mA;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        email=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText3);
        login=(Button)findViewById(R.id.button);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent =new Intent(com.example.ann.bittwo.login.this,nutrition.class);
                startActivity(myintent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
               checkDataEntered(email.getText().toString(),password.getText().toString());
            }
        });
    }
   boolean isEmpty(EditText text){
        CharSequence str=text.getText().toString();
        return TextUtils.isEmpty(str);
   }
    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
   void checkDataEntered(String mail,String Passowrd){
       if (TextUtils.isEmpty(mail)) {
           email.setError("Enter valid email");
       }
       else if (TextUtils.isEmpty(Passowrd)) {
           password.setError("password is required");
       }

       else{
          Intent inte=new Intent(com.example.ann.bittwo.login.this,Activity1.class);
          startActivity(inte);
        }

   }
}
