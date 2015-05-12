package com.locfai.musicplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;


public class musicplayer2 extends Activity{



    private ImageView playmusic;
    private ImageView pause;

    private MediaPlayer mp;
    private SeekBar seekBar;
    private Handler handler;
    private int tm;
    private TextView progresstime;
    private TextView progressmaxtime;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_musicplayer2);

        //View v =(View)findViewById(R.id.imageButton);//找到你要设透明背景的layout 的id
        // v.getBackground().setAlpha(0);//0~255透明度值

        final ImageView playmusic = (ImageView) findViewById(R.id.playmusic);
        final ImageView pause = (ImageView) findViewById(R.id.pause);
        final ImageView favour = (ImageView) findViewById(R.id.favour);
        final ImageView favour1 = (ImageView) findViewById(R.id.favour1);
        final SeekBar seekBar=(SeekBar)findViewById(R.id.seekBar);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.song1);
        progresstime=(TextView)findViewById(R.id.progresstime);
        progressmaxtime=(TextView)findViewById(R.id.progressmax);
        handler=new Handler();
        Seekbarchanged sbc=new Seekbarchanged();
        seekBar.setMax(mp.getDuration());
        seekBar.setOnSeekBarChangeListener(sbc);





        playmusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playmusic.setVisibility(View.INVISIBLE);
                pause.setVisibility(View.VISIBLE);
                Delaythread delaythread=new Delaythread();
                delaythread.start();



                try {
                    if (mp != null) {
                        mp.stop();
                    }
                    mp.prepare();
                    mp.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playmusic.setVisibility(View.VISIBLE);
                pause.setVisibility(View.INVISIBLE);
                try {
                    if (mp != null) {
                        mp.pause();
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }


            }
        });

        favour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favour.setVisibility(View.INVISIBLE);
                favour1.setVisibility(View.VISIBLE);
            }
        });

        favour1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favour.setVisibility(View.VISIBLE);
                favour1.setVisibility(View.INVISIBLE);
            }
        });

         handler=new Handler(){

            @Override
            public void handleMessage(Message msg) {
                seekBar.setProgress(mp.getCurrentPosition());
                tm=mp.getCurrentPosition();
                long mm=tm/60000;
                long ss=(tm-mm*60000)/1000;
                int mt=mp.getDuration();


                progresstime.setText(mm+":"+ss+"");

            }
        };




    }



   class Seekbarchanged implements SeekBar.OnSeekBarChangeListener{
       @Override
       public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
          //mp.seekTo(progress);
       }

       @Override
       public void onStartTrackingTouch(SeekBar seekBar) {


       }

       @Override
       public void onStopTrackingTouch(SeekBar seekBar) {


       }
   }


    class Delaythread extends Thread
    {
        @Override
        public void run() {
            while (true){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(0);
            }
        }
    }











}
