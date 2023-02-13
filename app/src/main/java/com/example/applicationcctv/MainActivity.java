package com.example.applicationcctv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView kalender;
    RecyclerView recyclerView;
    String s1[], s2[];
    int images[] = {R.drawable.gunungkidul, R.drawable.bunderansiyono, R.drawable.alunalunwonosari, R.drawable.rsudwonosari, R.drawable.bunderanpln,
                    R.drawable.ngingrong, R.drawable.simpanggading, R.drawable.pantaibaron, R.drawable.pantaikukup};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kalender = findViewById(R.id.tvDate);
        getToday();

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.area_cctv);
        s2 = getResources().getStringArray(R.array.kapanewon_cctv);

        cctvAdapter CCTVAdapter = new cctvAdapter(this, s1, s2, images);
        recyclerView.setAdapter(CCTVAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void getToday() {
        Date date = Calendar.getInstance().getTime();
        String hari = (String) DateFormat.format("EEEE", date);
        String tanggal = (String) DateFormat.format("dd", date);
        String bulan = (String) DateFormat.format("MMMM", date);
        String tahun = (String) DateFormat.format("yyyy", date);
        String formatFix = hari + ", " + tanggal + " " + bulan + " " + tahun;
        kalender.setText(formatFix);
    }
}