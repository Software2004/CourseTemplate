package com.example.coursetemplate.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursetemplate.HomeActivity;
import com.example.coursetemplate.Model.CourseDetail;
import com.example.coursetemplate.Model.CourseInnerDetail;
import com.example.coursetemplate.R;

import java.util.ArrayList;
import java.util.List;

public class CourseTitleAdapter extends RecyclerView.Adapter<CourseTitleAdapter.ViewHolder> {

    Integer layout;
    Context context;
    List<CourseDetail> courseDet = new ArrayList<>();
    private int lastVisiblePosition = -1;
    public CourseTitleAdapter(Context context,Integer layout) {
        this.context = context;
        this.layout = layout;
        for (int i=0; i<5; i++){
            List<CourseInnerDetail> details = new ArrayList<>();
            for (int j=0; j<3; j++){
                details.add(new CourseInnerDetail("Video or some Other Content",j+1));
            }
            courseDet.add(new CourseDetail("Title" + i + 1,details));
            Log.e("TAG", "CourseTitleAdapter: "+ "WE are HERE!!!" + courseDet.size());
        }

    }

    @NonNull
    @Override
    public CourseTitleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseTitleAdapter.ViewHolder holder, int position) {
        CourseDetail item = courseDet.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.rcv.setVisibility(item.getRecyclerViewVisible() ? View.VISIBLE : View.GONE);
        holder.ivUpDown.setRotation(item.getRecyclerViewVisible() ? -90 : 0);

        holder.rcv.setAdapter(new InnerCourseDetailAdptr(context,R.layout.item_expandable_subitem,item.getDetailList()));
        holder.btn.setOnClickListener(view -> {
            boolean isVisible = item.getRecyclerViewVisible();
            item.setRecyclerViewVisible(!isVisible);
            if (lastVisiblePosition != -1 && lastVisiblePosition != position)
            {
                courseDet.get(lastVisiblePosition).setRecyclerViewVisible(false);
                notifyItemChanged(lastVisiblePosition);
            }
            lastVisiblePosition = position;
            notifyItemChanged(position);
            //switchVisibility(holder.rcv, holder.ivUpDown);
        });
    }

    private void switchVisibility(RecyclerView rcv, ImageView ivUpDown) {
        if (rcv.getVisibility()==View.VISIBLE){
            rcv.setVisibility(View.GONE);
            ivUpDown.setRotation(0);
        }
        else{
            rcv.setVisibility(View.VISIBLE);
            ivUpDown.setRotation(-90);
        }
    }

    @Override
    public int getItemCount() {
        return courseDet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView ivUpDown;
        RecyclerView rcv;
        LinearLayout btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.title);
            ivUpDown = itemView.findViewById(R.id.icon);
            rcv = itemView.findViewById(R.id.rcv);
            btn = itemView.findViewById(R.id.btn);
        }
    }
}
