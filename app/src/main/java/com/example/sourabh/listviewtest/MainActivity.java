package com.example.sourabh.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> stars;
    private ArrayAdapter adapter;
    private ListView list;
    private EditText edit;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.list);
        button = (Button)findViewById(R.id.button);
        edit = (EditText)findViewById(R.id.edit);

        stars = new ArrayList<String>(); //Creating a new ArrayList
        stars.add("Miley Cyrus");
        stars.add("Selena Gomez");
        stars.add("Jonas Brothers");

        add();   //Calls the user defined function

        list.setOnItemClickListener(   //Whenever any item gets selected or clicked,onItenClick() will be called
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String n = String.valueOf(parent.getItemAtPosition(position)); //returns an item of selected position and then converting it to a String
                        Toast.makeText(MainActivity.this,"You have selected " + n,Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void add()        //Function to set adapter on listView
    {
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stars);
        list.setAdapter(adapter);
    }

    public void pressed(View v)   //Calls when Button "Submit" gets clicked
    {
        String name = edit.getText().toString();
        stars.add(name);  //Adding the new name to an arrayList which is entered by the user in EditText
        add();         //Calling
        edit.setText(null);  //Setting EditText back to null
    }
}
