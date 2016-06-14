package com.example.dell.spider1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String val = intent.getStringExtra("key");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView message;
        TextView time;
        Long ts = System.currentTimeMillis();
        Date date = new Date(ts);
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        String formatted = format.format(date);
        message = (TextView) findViewById(R.id.t1);
        message.setText("Thank you "+val+" for your response");
        time =(TextView) findViewById(R.id.t2);
        time.setText("Time: "+formatted);
        Button b;
        b = (Button) findViewById(R.id.back);
        b.setOnClickListener(new View.OnClickListener() {
        @Override
              public void onClick(View v) {
            Intent ret = new Intent(Main2Activity.this, MainActivity.class);
            Main2Activity.this.startActivity(ret);

            }
            });


    }

}
