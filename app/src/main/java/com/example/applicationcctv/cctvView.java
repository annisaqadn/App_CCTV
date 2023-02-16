package com.example.applicationcctv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerView;

public class cctvView extends AppCompatActivity {
    PlayerView viewcctv;
    ExoPlayer exoPlayer;
    ImageView fullscreenButton;
    boolean fullscreen = false;

    String data1, data2, video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cctv_view);
        viewcctv = findViewById(R.id.videoexoplayer);
        fullscreenButton = viewcctv.findViewById(R.id.exo_fullscreen_icon);

        getData();
        setData();
        fullscreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fullscreen) {
                    fullscreenButton.setImageDrawable(ContextCompat.getDrawable(cctvView.this, R.drawable.ic_baseline_fullscreen));

                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);

                    if(getSupportActionBar() != null){
                        getSupportActionBar().show();
                    }

                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) viewcctv.getLayoutParams();
                    params.width = params.MATCH_PARENT;
                    params.height = (int) ( 230 * getApplicationContext().getResources().getDisplayMetrics().density);
                    viewcctv.setLayoutParams(params);

                    fullscreen = false;
                }else{
                    fullscreenButton.setImageDrawable(ContextCompat.getDrawable(cctvView.this, R.drawable.ic_baseline_fullscreen_exit));

                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                            |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

                    if(getSupportActionBar() != null){
                        getSupportActionBar().hide();
                    }

                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) viewcctv.getLayoutParams();
                    params.width = params.MATCH_PARENT;
                    params.height = params.MATCH_PARENT;
                    viewcctv.setLayoutParams(params);

                    fullscreen = true;
                }
            }
        });

        if(data1.equals("Tugu Selamat Datang") && data2.equals("Kapanewon Patuk")){
            video = "http://103.141.234.194:8080/live/tugu-selamat-datang-patuk.flv";
        } else if (data1.equals("Bunderan Siyono") && data2.equals("Kapanewon Playen")){
            video = "http://103.141.234.194:8080/live/bunderan-siyono.flv";
        } else if (data1.equals("Alun-Alun Wonosari") && data2.equals("Kapanewon Wonosari")){
            video = "http://103.141.234.194:8080/live/alun-alun-wonosari.flv";
        }else if (data1.equals("Simpang 4 RSUD") && data2.equals("Kapanewon Wonosari")){
            video = "http://103.141.234.194:8080/live/simpang-4-rsud.flv";
        }else if (data1.equals("Bunderan PLN") && data2.equals("Kapanewon Wonosari")){
            video = "http://103.141.234.194:8080/live/bunderan-pln.flv";
        }else if (data1.equals("Ngingrong Mulo") && data2.equals("Kapanewon Wonosari")){
            video = "http://103.141.234.194:8080/live/ngingrong-mulo.flv";
        }else if (data1.equals("SMP N 1 Playen") && data2.equals("Kapanewon Playen")){
            video = video = "http://103.141.234.194:8080/live/smp-1-playen.flv";
        }else if (data1.equals("Simpang 4 Gading") && data2.equals("Kapanewon Playen")){
            video = "http://103.141.234.194:8080/live/simpang-4-gading.flv";
        }else if (data1.equals("Pantai Baron") && data2.equals("Kapanewon Tanjungsari")){
            video = "http://103.141.234.194:8080/live/pantai-baron.flv";
        }else if (data1.equals("Pantai Kukup") && data2.equals("Kapanewon Tanjungsari")){
            video = "http://103.141.234.194:8080/live/pantai-kukup.flv";
        }else {
            Toast.makeText(cctvView.this,"tidak ada cctv",Toast.LENGTH_LONG).show();
        }
        exoPlayer = new ExoPlayer.Builder(this).build();
        viewcctv.setPlayer(exoPlayer);
        viewcctv.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIXED_HEIGHT);
        MediaItem mediaItem = MediaItem.fromUri(video);
        exoPlayer.addMediaItem(mediaItem);
        exoPlayer.prepare();
        exoPlayer.setPlayWhenReady(true);
    }
    @Override
    public void onPause() {
        super.onPause();
        exoPlayer.setPlayWhenReady(false);
    }

    @Override
    public void onDestroy() {
        exoPlayer.release();
        super.onDestroy();
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
        getSupportActionBar().setTitle(data1);
    }
}