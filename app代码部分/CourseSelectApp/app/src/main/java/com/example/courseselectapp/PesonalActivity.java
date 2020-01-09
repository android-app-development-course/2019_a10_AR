package com.example.courseselectapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class PesonalActivity extends AppCompatActivity {

    TextView usernameTV;
    Button editBtn;
    ListView chosedCourseLV;
    Button toIndexBtn;
    int cId;
    private TheUser theUser;
    private List<Course> mycourseList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.hide();
        }

        theUser = LitePal.findFirst(TheUser.class);
        mycourseList = new ArrayList<>();

        usernameTV = (TextView) findViewById(R.id.tv_name);
        editBtn = (Button) findViewById(R.id.btn_edit);
        chosedCourseLV = (ListView) findViewById(R.id.lv_chosedCourse);
        toIndexBtn = (Button) findViewById(R.id.btn_toIndex);

        usernameTV.setText(theUser.getName());

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(PesonalActivity.this,EditInfoActivity.class);
                startActivity(intent1);
            }
        });


        toIndexBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(PesonalActivity.this,IndexActivity.class);
                startActivity(intent1);
            }
        });


        initCourse();

            CourseAdapter adapter = new CourseAdapter(PesonalActivity.this,R.layout.
                    listview_item,mycourseList);
            chosedCourseLV.setAdapter(adapter);
            chosedCourseLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Course course = mycourseList.get(position);
                    Intent intent = new Intent(PesonalActivity.this,MyCourDetailActivity.class);
                    intent.putExtra("TheCourseId",course.getId());
                    startActivity(intent);
                }
            });

    }

    private void initCourse(){
        List<SelectC> selectCList = LitePal.findAll(SelectC.class);
        for(SelectC c : selectCList){
            if(c.getPersonId()==theUser.getUserId())
                cId = c.getCourseId();
                Course course = LitePal.find(Course.class,cId);
                mycourseList.add(course);
        }
    }

}
