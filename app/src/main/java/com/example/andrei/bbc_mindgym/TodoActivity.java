package com.example.andrei.bbc_mindgym;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TodoActivity extends AppCompatActivity {

    ListView lv;
    FloatingActionButton button;
    TextInputLayout text;
    List<String> itemlist;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        lv = findViewById(R.id.listView);
        button = findViewById(R.id.floatingActionButton);
        text = findViewById(R.id.textInputLayout);
        itemlist = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemlist);
        lv.setAdapter(arrayAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToList();
            }
        });
    }

    public void addToList(){
        if(!text.getEditText().getText().toString().equals("") ||
                !text.getEditText().getText().toString().equals(" ")){
            String toDoStr = text.getEditText().getText().toString();
            itemlist.add(toDoStr);
            text.getEditText().setText("");
            arrayAdapter.notifyDataSetChanged();}
    }
}
