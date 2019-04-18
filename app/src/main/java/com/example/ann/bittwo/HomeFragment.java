package com.example.ann.bittwo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
private ListView mylist;
private ArrayAdapter<String> arrayAdapter;
private ArrayList<String> arrayList;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home,container,false);
        mylist=view.findViewById(R.id.lists);
        arrayList=new ArrayList<>();
        arrayList.add("hgdsUHJdsfjuhdfsdfsdfz");
        arrayList.add("hyuEFWHYUJAEFSHUYJUHDS");
        arrayList.add("hjbsdhjdshjdsfdsjdfshjgfv");
        arrayAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arrayList);
        mylist.setAdapter(arrayAdapter);


        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getActivity()," "+arrayList.get(position),Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

}
