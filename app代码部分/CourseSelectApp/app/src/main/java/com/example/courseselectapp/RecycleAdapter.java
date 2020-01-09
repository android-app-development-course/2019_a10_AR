package com.example.courseselectapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>{

    private List<Course> mCourseList;

    static  class ViewHolder extends RecyclerView.ViewHolder{
        View courseView;
        ImageView courseImage;

        public ViewHolder(View view){
            super(view);
            courseView = view;
            courseImage = (ImageView) view.findViewById(R.id.recycle_image);
        }
    }





    public RecycleAdapter(List<Course> courseList){
        mCourseList = courseList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Course course = mCourseList.get(position);
        holder.courseImage.setImageResource(course.getImageId());


    }

    @Override
    public int getItemCount(){
        return mCourseList.size();
    }



}
