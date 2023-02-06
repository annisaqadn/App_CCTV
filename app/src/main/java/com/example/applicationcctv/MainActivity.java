package com.example.applicationcctv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String s1[], s2[];
    int images[] = {R.drawable.alunalunwonosari, R.drawable.bunderansiyono, R.drawable.alunalunwonosari};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.area_cctv);
        s2 = getResources().getStringArray(R.array.kapanewon_cctv);

        cctvAdapter CCTVAdapter = new cctvAdapter(this, s1, s2, images);
        recyclerView.setAdapter(CCTVAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}