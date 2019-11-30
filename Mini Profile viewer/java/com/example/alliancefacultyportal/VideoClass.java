package com.example.alliancefacultyportal;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.VideoView;
import android.widget.MediaController;
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

public class VideoClass extends AppCompatActivity {
    Spinner spinner;
    String[] SPINNERVALUES = {"video1", "video2", "video3"};
    String SpinnerValue;
    Button play, replay;
    Intent intent;
    private int position = 0;
    private MediaController mediaController;
    private VideoView videoplayer;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoclassxml);
        name = getIntent().getStringExtra("P_name").toLowerCase();
        spinner = (Spinner) findViewById(R.id.VideoSelecter);
        play = (Button) findViewById(R.id.PlayButton);
        replay = (Button) findViewById(R.id.ReplayButton);

        getWindow().setFormat(PixelFormat.UNKNOWN);
        videoplayer = findViewById(R.id.VideoScreen);
        if (mediaController == null) {
            mediaController = new MediaController(VideoClass.this);
            mediaController.setAnchorView(videoplayer);
            videoplayer.setMediaController(mediaController);
        }

        final String Path = "android.resource://com.example.alliancefacultyportal/";
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, SPINNERVALUES);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerValue = (String) spinner.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = name.concat(SpinnerValue);
                int id = getRawResIdByName(str);
                Uri uri1 = Uri.parse(Path + id);
                videoplayer.setVideoURI(uri1);
                videoplayer.requestFocus();
                videoplayer.start();
                videoplayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        videoplayer.seekTo(position);
                        if (position == 0) {
                            videoplayer.start();
                        }
                        mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                            @Override
                            public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                                mediaController.setAnchorView(videoplayer);
                            }
                        });
                    }
                });
            }
        });
        replay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str = name.concat(SpinnerValue);
                int id = getRawResIdByName(str);
                Uri uri1 = Uri.parse(Path + id);
                videoplayer.setVideoURI(uri1);
                videoplayer.requestFocus();
                videoplayer.start();
                mediaController.show();
            }
        });
    }

    public int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("CurrentPosition", videoplayer.getCurrentPosition());
        videoplayer.pause();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        position = savedInstanceState.getInt("CurrentPosition");
        videoplayer.seekTo(position);
        videoplayer.resume();
    }
}