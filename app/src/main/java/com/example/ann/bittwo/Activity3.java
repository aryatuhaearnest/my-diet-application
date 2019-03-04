package com.example.ann.bittwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.menu,menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int x=item.getItemId();
            switch (x){

                case R.id.home:
                    Intent myintent =new Intent(Activity3.this,Activity3.class);
                    startActivity(myintent);
                    break;
                case R.id.exit:
                    Intent myintent1 =new Intent(Activity3.this,home.class);
                    startActivity(myintent1);
                    break;
                case R.id.logout:
                    Intent myintent2 =new Intent(Activity3.this,Activity1.class);
                    startActivity(myintent2);
                    break;
                case R.id.nutrition:
                    Toast.makeText(getApplicationContext(),"service coming soon",Toast.LENGTH_SHORT).show();
                    break;
                default:
                    return false;

            }

            return super.onOptionsItemSelected(item);
    }
}
