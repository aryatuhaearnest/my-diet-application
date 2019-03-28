package com.example.ann.bittwo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class fragment_nutrients extends Fragment {


    public fragment_nutrients() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View view=inflater.inflate(R.layout.fragment_nutrients, container, false);

String []listview={
"carbohydrates","fats","proteins","water","mineral salts","takeaway"

};
        ListView listView=view.findViewById(R.id.listview);

        ArrayAdapter<String> listviewadapter=new ArrayAdapter<String>(

                getActivity(),
                android.R.layout.simple_expandable_list_item_1,
                listview
        );
listView.setAdapter(listviewadapter);
        return view;
    }

}
