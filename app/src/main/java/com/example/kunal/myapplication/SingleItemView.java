package com.example.kunal.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SingleItemView extends Activity {
    TextView name,desig,contact;
    String n,d,c;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);
        Intent i=getIntent();
        n=i.getStringExtra("name");
        d=i.getStringExtra("desig");
        c=i.getStringExtra("contact");
        name=(TextView)findViewById(R.id.name);
        desig=(TextView)findViewById(R.id.desig);
        contact=(TextView)findViewById(R.id.contact);
        name.setText(n);
        desig.setText(d);
        contact.setText(c);
    }
}
