package com.example.applicationcctv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class cctvAdapter extends RecyclerView.Adapter<cctvAdapter.cctvViewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public cctvAdapter(Context ct, String s1[], String s2[], int img[]) {
        context = ct;
        data1 = s1;
        data2 = s2;
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
    public void onBindViewHolder(@NonNull cctvViewHolder holder, int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class cctvViewHolder extends RecyclerView.ViewHolder{

        TextView myText1, myText2;
        ImageView myImage;
        public cctvViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.textView);
            myText2 = itemView.findViewById(R.id.textView2);
            myImage = itemView.findViewById(R.id.imageView);
        }
    }
}
