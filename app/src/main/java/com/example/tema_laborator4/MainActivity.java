package com.example.tema_laborator4;

import androidx.appcompat.app.AppCompatActivity;

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

    ListView listView1;
    EditText inputtext1;
    Button btnAdd;

    ArrayList<String> students = new ArrayList<String>();
    ArrayAdapter myAdapter1;

    Integer indexVal;
    String item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1 = (ListView) findViewById(R.id.listview1);
        btnAdd = (Button) findViewById(R.id.button1);
        inputtext1 = (EditText) findViewById(R.id.editText);

        //setup listview
        students.add("Andreea");
        students.add("Mrius");

        myAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,students);
        listView1.setAdapter(myAdapter1);
//Add items
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringval=inputtext1.getText().toString();
                students.add(stringval);
                myAdapter1.notifyDataSetChanged();

                inputtext1.setText("");
            }
        });


        // Select item
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString() + "has been selected";
                indexVal=i;
                Toast.makeText(MainActivity.this, "item:", Toast.LENGTH_SHORT).show();
            }
        });

        //Delete
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item= adapterView.getItemAtPosition(i).toString() +"has been deleted";
                Toast.makeText(MainActivity.this, "deleted", Toast.LENGTH_SHORT).show();

                students.remove(i);
                myAdapter1.notifyDataSetChanged();
              //  return true;
            }
        });




    }
}