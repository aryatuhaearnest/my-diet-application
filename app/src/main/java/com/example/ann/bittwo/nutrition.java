package com.example.ann.bittwo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class nutrition extends AppCompatActivity {
ListView listView;
    Button mybutton;
    TextView textView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutrition);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        listView=findViewById(R.id.list);
        mybutton=findViewById(R.id.button6);
        editText = findViewById(R.id.editText2);

        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((editText.getText().toString().isEmpty())){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.google.com"));
                    startActivity(intent);
                }
// else if(!(editText.getText().toString().contains("www"))){
//                    Toast.makeText(nutrition.this, "Enter correct format starting with www", Toast.LENGTH_SHORT).show();
//
//                }
                else{
                    String url = editText.getText().toString();
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www."+url));
                    startActivity(intent);
                }



            }
        });

        final ArrayList<String>arrayList=new ArrayList<>();
        arrayList.add("fats");
        arrayList.add("proteins");
        arrayList.add("cabohydrates");
        arrayList.add("mineral salts");
        arrayList.add("water");
        arrayList.add("takeaway");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,arrayList);
listView.setAdapter(arrayAdapter);

listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(getApplicationContext()," "+arrayList.get(position),Toast.LENGTH_SHORT).show();
    }
});
    }
    public class n extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Intent Detected.", Toast.LENGTH_LONG).show();
        }
    }

}
