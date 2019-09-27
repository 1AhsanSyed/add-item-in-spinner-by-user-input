package com.minhasoft1.adddatatospinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner mySpinner;
    List<SpinnerCategory> mylist;
    ArrayAdapter<SpinnerCategory> myAdapter;
    EditText edtData;
    Button btnAdd;
    ArrayList<SpinnerCategory> myArrayList;
    String catName;
    SpinnerCategory category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtData = findViewById(R.id.myText);
        btnAdd = findViewById(R.id.btnAdd);
        mySpinner = findViewById(R.id.myspinner);



        category = new SpinnerCategory();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                catName = edtData.getText().toString();

                category.setName(catName);

                category.save();

                Toast.makeText(MainActivity.this, catName+"category Added", Toast.LENGTH_SHORT).show();

                updateSpinner();
            }
        });
        updateSpinner();



        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void updateSpinner(){
        mylist = new ArrayList<>();
        //set value from data into List
        mylist = SpinnerCategory.listAll(SpinnerCategory.class);
        //creating spinner dropdown list
        myAdapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,mylist);
        myAdapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);


        mySpinner.setAdapter(myAdapter);
        myAdapter.setNotifyOnChange(true);
        myAdapter.notifyDataSetChanged();
    }

}
