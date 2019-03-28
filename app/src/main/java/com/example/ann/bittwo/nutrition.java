package com.example.ann.bittwo;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class nutrition extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutrition);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        listView=findViewById(R.id.list);

        final ArrayList<String>arrayList=new ArrayList<>();
        arrayList.add("fats");
        arrayList.add("proteins");
        arrayList.add("cabohydrates");
        arrayList.add("mineral salts");
        arrayList.add("water");
        arrayList.add("takeaway");
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
Toast.makeText(nutrition.this,"clicked item:"+1+""+arrayList.get(1).toString(),Toast.LENGTH_SHORT).show();
    }
});
    }

}
