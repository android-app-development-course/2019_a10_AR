package com.example.courseselectapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CourseAdapter extends ArrayAdapter<Course> {
    private int resourceId;
    public CourseAdapter(Context context, int  textViewResourceId, List<Course> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Course course = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView courseImage = (ImageView) view.findViewById(R.id.iv_course);
        TextView coursename = (TextView) view.findViewById(R.id.tv_coursename);
        TextView teacher = (TextView) view.findViewById(R.id.tv_teacher);
        courseImage.setImageResource(course.getImageId());
        coursename.setText(course.getCoursename());
        teacher.setText(course.getTeacher());
        return view;
    }

}
