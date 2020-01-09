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

import java.util.List;

public class CourDetailActivity extends AppCompatActivity {


    ImageView imageView;
    TextView courseName;
    TextView teacher;
    TextView time;
    TextView book;
    TextView brief;
    Button choose;
    Button backBtn;
    int TheCourseId;
    String s ;
    TheUser theUser;
    Course course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coursedetails);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.hide();
        }


        TheCourseId = getIntent().getIntExtra("TheCourseId",0);
        s = Integer.toString(TheCourseId);
        theUser = LitePal.findFirst(TheUser.class);
        course = LitePal.find(Course.class,TheCourseId);


//          k判断用户是否已经选了这门课程   k=0表示没选
        int k = 0;
        List<SelectC> selectCList = LitePal.findAll(SelectC.class);

        for(SelectC c : selectCList){
            if(c.getPersonId()==theUser.getUserId()&&c.getCourseId()==course.getId())
                k=1;
        }



        imageView = (ImageView) findViewById(R.id.iv_image);
        courseName = (TextView) findViewById(R.id.tv_coursename);
        teacher = (TextView) findViewById(R.id.tv_teacher);
        time = (TextView) findViewById(R.id.tv_time);
        book = (TextView) findViewById(R.id.tv_book);
        brief = (TextView) findViewById(R.id.tv_brief);
        choose = (Button) findViewById(R.id.btn_choose);
        backBtn = (Button) findViewById(R.id.btn_back);

        imageView.setImageResource(course.getImageId());
        courseName.setText(course.getCoursename());
        teacher.setText("教师："+course.getTeacher());
        time.setText("时间："+course.getTime());
        book.setText("教材:"+course.getBook());
        brief.setText("简介："+course.getIntroduction());

        if(k==1){
            choose.setText("已选");
            choose.setEnabled(false);
        }

        else {
            choose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //新建选课记录
                    SelectC selectC = new SelectC();
                    selectC.setCourseId(TheCourseId);
                    selectC.setPersonId(theUser.getUserId());
                    selectC.save();

                    choose.setText("已选");
                    choose.setEnabled(false);
                    Toast.makeText(CourDetailActivity.this,"选课成功！",Toast.LENGTH_SHORT).show();
                }
            });

        }


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(CourDetailActivity.this,IndexActivity.class);
                startActivity(intent1);
            }
        });

    }
}
