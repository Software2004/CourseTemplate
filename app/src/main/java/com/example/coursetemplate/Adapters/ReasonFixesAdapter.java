package com.example.coursetemplate.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursetemplate.Interfaces.ExitDesignInterface;
import com.example.coursetemplate.Model.ReasonFix;
import com.example.coursetemplate.R;

import java.util.ArrayList;
import java.util.List;

public class ReasonFixesAdapter extends RecyclerView.Adapter<ReasonFixesAdapter.ViewHolder> {

    Integer layout;
    List<ReasonFix> names;
    boolean isFirst;
    ExitDesignInterface exitInter;
    public ReasonFixesAdapter(Integer layout, List<ReasonFix> names, boolean isFirst, ExitDesignInterface exitInter) {
        this.layout = layout;
        this.names = names;
        this.isFirst = isFirst;
        this.exitInter = exitInter;
    }

    @NonNull
    @Override
    public ReasonFixesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReasonFixesAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(names.get(position).getText());
        holder.icon.setImageResource(names.get(position).getImage());
        holder.lay.setOnClickListener(view -> {
            if (isFirst){
                exitInter.ShowLayout();
            }else{
                exitInter.startNewAct();
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView icon;
        ConstraintLayout lay;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.text);
            icon = itemView.findViewById(R.id.icon);
            lay = itemView.findViewById(R.id.rootLay);
        }
    }
}
