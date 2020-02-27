package com.example.simplenote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView text;
    ListView list_view;
    List<String> list;
    ArrayAdapter<String> adapter;

    int current_view = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.editText);
        list_view = findViewById(R.id.list);
        list = new ArrayList<>();

        //text.setEnabled(false);

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        list_view.setAdapter(adapter);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                text.setText(adapter.getItem(position));
                current_view = position;
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(text.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        Button button1 = findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(current_view);
                if(current_view >= 0) {
                    list.set(current_view,text.getText().toString());
                    adapter.notifyDataSetChanged();
                }
            }
        });




    }
}
