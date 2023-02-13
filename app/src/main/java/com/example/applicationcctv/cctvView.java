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
    PlayerView playerView;
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

        if(data1.equals("Tugu Selamat Datang") && data2.equals("Kapanewon Patuk")){
            String videoUrl = "http://103.141.234.194:8080/live/tugu-selamat-datang-patuk.flv";

            exoPlayer = new ExoPlayer.Builder(this).build();
            playerView = findViewById(R.id.videoexoplayer);
            playerView.setPlayer(exoPlayer);
            MediaItem mediaItem = MediaItem.fromUri(videoUrl);
            exoPlayer.addMediaItem(mediaItem);
            exoPlayer.prepare();
            exoPlayer.setPlayWhenReady(true);
        } else if (data1.equals("Bunderan Siyono") && data2.equals("Kapanewon Playen")){
            String videoUrl = "http://103.141.234.194:8080/live/bunderan-siyono.flv";

            exoPlayer = new ExoPlayer.Builder(this).build();
            playerView = findViewById(R.id.videoexoplayer);
            playerView.setPlayer(exoPlayer);
            MediaItem mediaItem = MediaItem.fromUri(videoUrl);
            exoPlayer.addMediaItem(mediaItem);
            exoPlayer.prepare();
            exoPlayer.setPlayWhenReady(true);
        } else if (data1.equals("Alun-Alun Wonosari") && data2.equals("Kapanewon Wonosari")){
            String videoUrl = "http://103.141.234.194:8080/live/alun-alun-wonosari.flv";

            exoPlayer = new ExoPlayer.Builder(this).build();
            playerView = findViewById(R.id.videoexoplayer);
            playerView.setPlayer(exoPlayer);
            MediaItem mediaItem = MediaItem.fromUri(videoUrl);
            exoPlayer.addMediaItem(mediaItem);
            exoPlayer.prepare();
            exoPlayer.setPlayWhenReady(true);
        }else if (data1.equals("Simpang 4 RSUD") && data2.equals("Kapanewon Wonosari")){

        }else if (data1.equals("Bunderan PLN") && data2.equals("Kapanewon Wonosari")){

        }else if (data1.equals("Ngingrong Mulo") && data2.equals("Kapanewon Wonosari")){

        }else if (data1.equals("Simpang 4 Trowono") && data2.equals("Kapanewon Paliyan")){

        }else if (data1.equals("Pantai Baron") && data2.equals("Kapanewon Tanjungsari")){

        }else if (data1.equals("Pantai Kukup") && data2.equals("Kapanewon Tanjungsari")){

        }else {
            Toast.makeText(cctvView.this,"tidak ada cctv",Toast.LENGTH_LONG).show();
        }
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