package com.example.applicationcctv;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class cctvAdapter extends RecyclerView.Adapter<cctvAdapter.cctvViewHolder> {

    String data1[], data2[], data3[];
    int images[];
    Context context;

    public cctvAdapter(Context ct, String s1[], String s2[], String[] link, int img[]) {
        context = ct;
        data1 = s1;
        data2 = s2;
        //data3 = link;
        images = img;
    }

    @NonNull
    @Override
    public cctvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new cctvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cctvViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);

        holder.myCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, cctvView.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                //intent.putExtra("data3", data3[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class cctvViewHolder extends RecyclerView.ViewHolder{

        TextView myText1, myText2;
        ImageView myImage;
        CardView myCardView;

        public cctvViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.textView);
            myText2 = itemView.findViewById(R.id.textView2);
            myImage = itemView.findViewById(R.id.imageView);
            myCardView = itemView.findViewById(R.id.cvCardView);
        }
    }
}
