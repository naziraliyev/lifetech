package com.example.lifetech.Adapters;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lifetech.InfoActivity;
import com.example.lifetech.R;
import com.example.lifetech.model.MyModel;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolderView> {
    private Context context;
    private List<MyModel> list;


    public MyAdapter(Context context, List<MyModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolderView onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);

        return new MyHolderView(view);
    }

    @Override
    public void onBindViewHolder(MyHolderView holder, int position) {
        MyModel item = list.get(position);
        holder.course.setText(item.getCourse());
        holder.teacher.setText(item.getTeacher());
        holder.desc.setText(item.getDescription());
        holder.time.setText(item.getTime());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,InfoActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolderView extends RecyclerView.ViewHolder {
         private TextView course,time,teacher,desc;
           CardView cardView;
        public MyHolderView(View itemView) {
            super(itemView);
            course = itemView.findViewById(R.id.tv_course1);
            desc = itemView.findViewById(R.id.description);

            teacher = itemView.findViewById(R.id.tv_teacher);
            time = itemView.findViewById(R.id.tv_time);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
