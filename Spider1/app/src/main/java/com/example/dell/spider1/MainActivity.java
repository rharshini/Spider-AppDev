package com.example.dell.spider1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity
{

    Button button;
    EditText editText;
    EditText editText1;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {   Intent ret = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button    =    (Button) findViewById(R.id.b1);
        editText  =   (EditText) findViewById(R.id.e1);
        editText1 =  (EditText) findViewById(R.id.e2);
        checkBox1 = (CheckBox) findViewById(R.id.c1);
        checkBox2 = (CheckBox) findViewById(R.id.c2);
        checkBox3 = (CheckBox) findViewById(R.id.c3);
        checkBox4 = (CheckBox) findViewById(R.id.c4);
        editText.getText().clear();
        editText1.getText().clear();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1=editText.getText().toString();
                String s2=editText1.getText().toString();
                if((!checkBox1.isChecked())&&(!checkBox2.isChecked())&&(!checkBox3.isChecked())&&(!checkBox4.isChecked()))
                    Toast.makeText(getApplicationContext(),"Select at least one profile",Toast.LENGTH_LONG).show();
                else if(s1.length()==0)
                    Toast.makeText(getApplicationContext(),"Please enter name", Toast.LENGTH_LONG).show();
                else if(s2.length()==0)
                    Toast.makeText(getApplicationContext(),"Please enter roll number", Toast.LENGTH_LONG).show();
                else {

                    Intent intent = new Intent (MainActivity.this, Main2Activity.class);
                    intent.putExtra("key", s1);
                    MainActivity.this.startActivity(intent);
                }
            }
        });

    }



}

