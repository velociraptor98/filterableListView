package com.example.kunal.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class second extends AppCompatActivity {
    private EditText e1;
    private Button b1,b2;
    private ListView ls;
    private ListViewAdapter adapter;
    private String[] name;
    private String[] desig;
    private String[] contact;
    private ArrayList<data> arrayList=new ArrayList<data>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        e1=(EditText)findViewById(R.id.search2);
        b1=(Button)findViewById(R.id.ok2);
        b2=(Button)findViewById(R.id.back2);
        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        name=new String[]{"one","two","three","four","five"};
        desig=new String[]{"officer","insp","data admin","data insp","officer"};
        contact =new String[]{"99999","9998","23123","1231231","87323"};
        ls=(ListView)findViewById(R.id.l2);
        int len=name.length;
        for(int i=0;i<len;i++)
        {
            data d=new data(name[i],desig[i],contact[i]);
            arrayList.add(d);

        }
        adapter=new ListViewAdapter(this,arrayList);
        ls.setAdapter(adapter);
        e1.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable arg0)
            {
                String text=e1.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }
            @Override
            public void beforeTextChanged(CharSequence arg0,int arg1,int arg2,int arg3){
                ;
            }
            @Override
            public void onTextChanged(CharSequence arg0,int arg1,int arg2,int arg3){
                ;
            }

        });

        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}
