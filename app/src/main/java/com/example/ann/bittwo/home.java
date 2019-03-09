package com.example.ann.bittwo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.EditText;
/*ARYATUHA EARNEST 2017/BIT/066/PS*/

public class home extends AppCompatActivity {

    Button mybutton;
public static final String my_tag="the custom message ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        mybutton=findViewById(R.id.button3);
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent =new Intent(home.this,Activity1.class);
                startActivity(myintent);
            }
        });
        mybutton=findViewById(R.id.button2);
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent =new Intent(home.this,Activity2.class);
                startActivity(myintent);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(my_tag,"onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(my_tag,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(my_tag,"onStop");
    }
}
