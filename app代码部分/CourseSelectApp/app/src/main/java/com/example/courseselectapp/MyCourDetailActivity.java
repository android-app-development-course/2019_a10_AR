package com.example.courseselectapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;

public class MyCourDetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView courseName;
    TextView teacher;
    TextView time;
    TextView book;
    TextView brief;
    Button cancel;
    Button backBtn;
    int TheCourseId ;
    String scourseId ;
    TheUser theUser;
    Course course ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycoursedetails);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.hide();
        }

        TheCourseId = getIntent().getIntExtra("TheCourseId",0);
        scourseId = Integer.toString(TheCourseId);
        theUser = LitePal.findFirst(TheUser.class);
        course = LitePal.where("id=?",scourseId).findFirst(Course.class);


        imageView = (ImageView) findViewById(R.id.iv_image);
        courseName = (TextView) findViewById(R.id.tv_coursename);
        teacher = (TextView) findViewById(R.id.tv_teacher);
        time = (TextView) findViewById(R.id.tv_time);
        book = (TextView) findViewById(R.id.tv_book);
        brief = (TextView) findViewById(R.id.tv_brief);
        cancel = (Button) findViewById(R.id.btn_cancel);
        backBtn = (Button) findViewById(R.id.btn_back);

        imageView.setImageResource(course.getImageId());
        courseName.setText(course.getCoursename());
        teacher.setText("教师:"+course.getTeacher());
        time.setText("时间："+course.getTime());
        book.setText("教材:"+course.getBook());
        brief.setText("简介："+course.getIntroduction());

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String spersonid =Integer.toString(theUser.getUserId());
                LitePal.deleteAll(SelectC.class,"personId=? and courseId=?",spersonid,scourseId);

                cancel.setText("已退选");
                cancel.setEnabled(false);
                Toast.makeText(MyCourDetailActivity.this,"退选成功！",Toast.LENGTH_SHORT).show();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MyCourDetailActivity.this,PesonalActivity.class);
                startActivity(intent1);
            }
        });

    }
}
