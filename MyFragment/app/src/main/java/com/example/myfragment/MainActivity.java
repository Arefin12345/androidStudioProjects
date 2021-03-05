package com.example.myfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String name[]={"Arefin","tanim","Mahi","tasin","Rafi","Arko"};
        listView = (ListView) findViewById(R.id.listid);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ArefinFragment fragment;
        TanimFragment fragment2;

        if(position==0){
             fragment = new ArefinFragment();
             FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction = fragmentTransaction.replace(R.id.fragmentid, fragment);
            fragmentTransaction.commit();


        }
        else if(position==1){

            fragment2 = new TanimFragment();
//            FragmentManager fragmentManager = getFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction = fragmentTransaction.replace(R.id.fragmentid, fragment2);
//            fragmentTransaction.commit();
           getFragmentManager().beginTransaction().replace(R.id.fragmentid,fragment2).commit();
        }

    }
}
