package com.example.applicationcctv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.PlayerView;

public class cctvView extends AppCompatActivity {
    TextView area, kapanewon;
    PlayerView viewcctv;
    ExoPlayer exoPlayer;

    String data1, data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cctv_view);
        area = findViewById(R.id.textView);
        kapanewon = findViewById(R.id.textView2);
        getData();
        setData();

        viewcctv = findViewById(R.id.exoplayer);
        exoPlayer = new ExoPlayer.Builder(this).build();
        viewcctv.setPlayer(exoPlayer);

        String video = "http://103.141.234.194:8080/live/alun-alun-wonosari.flv";
        MediaItem mediaItem = MediaItem.fromUri(video);
        exoPlayer.addMediaItem(mediaItem);
        exoPlayer.prepare();
        exoPlayer.setPlayWhenReady(true);
    }
    private void getData(){
        if(getIntent().hasExtra("data1") && getIntent().hasExtra("data2")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        area.setText(data1);
        kapanewon.setText(data2);
    }
}