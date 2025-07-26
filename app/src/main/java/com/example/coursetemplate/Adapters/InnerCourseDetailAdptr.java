package com.example.coursetemplate.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursetemplate.Model.CourseInnerDetail;
import com.example.coursetemplate.R;

import java.util.List;

public class InnerCourseDetailAdptr extends RecyclerView.Adapter<InnerCourseDetailAdptr.ViewHolder> {

    Integer layout;
    List<CourseInnerDetail> courseDet;
    Context context;
    public InnerCourseDetailAdptr(Context context, Integer layout, List<CourseInnerDetail> list) {
        this.context = context;
        this.layout = layout;
        this.courseDet = list;
    }

    @NonNull
    @Override
    public InnerCourseDetailAdptr.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerCourseDetailAdptr.ViewHolder holder, int position) {
        holder.tvTitle.setText(courseDet.get(position).getVideoName());
        holder.noVideos.setText(courseDet.get(position).getNoVideos() + " Videos");

    }

    @Override
    public int getItemCount() {
        return courseDet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,noVideos;
        LinearLayout btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.title);
            noVideos = itemView.findViewById(R.id.text);
            btn = itemView.findViewById(R.id.btn);
        }
    }
}
