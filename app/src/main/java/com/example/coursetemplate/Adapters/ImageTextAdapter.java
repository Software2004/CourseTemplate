package com.example.coursetemplate.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursetemplate.HomeActivity;
import com.example.coursetemplate.R;

import java.util.ArrayList;
import java.util.List;

public class ImageTextAdapter extends RecyclerView.Adapter<ImageTextAdapter.ViewHolder> {

    Integer layout;
    List<String> names = new ArrayList<>();
    public ImageTextAdapter(Integer layout) {
        this.layout = layout;
        names.add("Content Writing");
        names.add("App Development");
        names.add("Ethical Hacking");
        names.add("Black Hat Hacking");
        names.add("Web Scripting");
        names.add("AI Mastery");
        names.add("Business Mastery");
        names.add("Stock Trading");
    }

    @NonNull
    @Override
    public ImageTextAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageTextAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(names.get(position));
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.text);
        }
    }
}
