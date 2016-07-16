package com.example.dell.demo;

import android.app.ActivityManager;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.*;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {
    Button Submit;
    ImageView img;
    Spinner track;
    MediaPlayer mediaPlayer1;
    MediaPlayer mediaPlayer2;
    Button play;
    Button stop;
    Button disable;
    Button enable;
    TextView textView;
    int mStartMode;
    IBinder mBinder;
    boolean mAllowRebind;
    final Handler handler = new Handler();
    Handler time = new Handler();
    long start;
    Runnable timer = new Runnable() {
        @Override
        public void run() {
            long s = (System.currentTimeMillis() - start)/1000;
            String p = Long.toString(s);
            textView.setText(p);
            time.postDelayed(this, 1000);
        }
    };
    Service service = new Service() {
        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {

            final String check = track.getSelectedItem().toString();
            if (flags == 1) {
                if (check == "Hedwig's Theme") {
                    if (mediaPlayer2.isPlaying())
                        mediaPlayer2.pause();
                    mediaPlayer1.start();
                } else {
                    if (mediaPlayer1.isPlaying())
                        mediaPlayer1.pause();
                    mediaPlayer2.start();
                }
            } else {
                if (check == "Hedwig's Theme")
                    mediaPlayer1.pause();
                else
                    mediaPlayer2.pause();

            }
            return mStartMode;
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            Toast.makeText(getApplicationContext(), "Music stopped", Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Submit = (Button) findViewById(R.id.b);
        img = (ImageView) findViewById(R.id.i);
        textView = (TextView) findViewById(R.id.count);


        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start = System.currentTimeMillis();
                time.postDelayed(timer,0);
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=1; i<12 ; i++) {
                            try{
                            call(i);
                            Thread.sleep(3000);
                            } catch (InterruptedException e)
                            {
                                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                t.start();

            }


        });

        mediaPlayer1 = MediaPlayer.create(getApplicationContext(), R.raw.hptrack1);
        mediaPlayer2 = MediaPlayer.create(getApplicationContext(), R.raw.hptrack2);
        track = (Spinner) findViewById(R.id.tracks);
        play = (Button) findViewById(R.id.b1);
        stop = (Button) findViewById(R.id.b2);
        List<String> songs = new ArrayList<String>();

        songs.add("Hedwig's Theme");
        songs.add("Leaving Hogwarts");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, songs);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        track.setAdapter(adapter);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                service.onStartCommand(new Intent(getApplicationContext(), MainActivity.class), 1, 0);

            }
        });
        stop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                service.onStartCommand(new Intent(getApplicationContext(), MainActivity.class), 0, 0);

            }
        });


    }
    public void call (int j)
    {   final int i = j;

        handler.postDelayed(new Runnable() {

                @Override
                public void run () {

                switch (i) {
                    case 1:
                        img.setImageResource(R.drawable.hp1);
                        break;
                    case 2:
                        img.setImageResource(R.drawable.hp2);
                        break;
                    case 3:
                        img.setImageResource(R.drawable.hp3);
                        break;
                    case 4:
                        img.setImageResource(R.drawable.hp4);
                        break;
                    case 5:
                        img.setImageResource(R.drawable.hp5);
                        break;
                    case 6:
                        img.setImageResource(R.drawable.hp6);
                        break;
                    case 7:
                        img.setImageResource(R.drawable.hp7);
                        break;
                    case 8:
                        img.setImageResource(R.drawable.hp8);
                        break;
                    case 9:
                        img.setImageResource(R.drawable.hp9);
                        break;
                    case 10:
                        img.setImageResource(R.drawable.hp10);
                        break;
                    case 11:
                        img.setImageResource(R.drawable.hp11);
                        break;


                }

            }
            }, 3000);

    }
}


