package com.example.ann.bittwo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class nutrition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutrition);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
                    Intent myintent =new Intent(nutrition.this,nutrition.class);
                    startActivity(myintent);
                    break;
                case R.id.exit:
                    AlertDialog.Builder builder=new AlertDialog.Builder(this);
                    builder.setMessage("are you sure you want to exit")
                            .setCancelable(false)
                            .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int x ) {
                                    nutrition.this.finish();
                                }
                            })
                            .setNegativeButton("no", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int x) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert=builder.create();
                    alert.show();
                    break;
                case R.id.logout:
                    Intent myintent2 =new Intent(nutrition.this,login.class);
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
