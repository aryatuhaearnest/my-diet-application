package com.example.ann.bittwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity1 extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button login;
   // private FirebaseAuth mA;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        email=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText3);
        login=(Button)findViewById(R.id.button);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent =new Intent(Activity1.this,Activity3.class);
                startActivity(myintent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {


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
    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
   void checkDataEntered(){

       if (TextUtils.isEmpty(email.getText())) {
           email.setError("Enter valid email");
       }
        else if (isEmpty(password)){
            password.setError("password is required");
        }else{
          Intent inte=new Intent(Activity1.this,Activity3.class);
          startActivity(inte);
        }

   }
}
