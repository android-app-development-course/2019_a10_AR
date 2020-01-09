package com.example.courseselectapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class IndexActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ListView listView;
    Button gotomy;
    private List<Course> courseList = new ArrayList<>();
    private List<Course> rcourseList = new ArrayList<>();
    private TheUser theUser = LitePal.findFirst(TheUser.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.hide();
        }


        initCourse();
        initRCourse();


        recyclerView = (RecyclerView) findViewById(R.id.rclview);
        listView = (ListView) findViewById(R.id.listv);
        gotomy = (Button) findViewById(R.id.toperson_btn);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(IndexActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecycleAdapter radapter = new RecycleAdapter(rcourseList);
        recyclerView.setAdapter(radapter);

        gotomy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(IndexActivity.this,PesonalActivity.class);
                startActivity(intent1);
            }
        });


        CourseAdapter adapter = new CourseAdapter(IndexActivity.this,R.layout.
                listview_item,courseList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Course course = courseList.get(position);
                Log.i("FFF","courseId is "+course.getId());
                Intent intent = new Intent(IndexActivity.this,CourDetailActivity.class);
                intent.putExtra("TheCourseId",course.getId());
                startActivity(intent);
            }
        });


    }




    private void initCourse(){


       int number = LitePal.count(Course.class);
       String s = Integer.toString(number);

        if(number==0){
            Course course0 = new Course();
            course0.setCoursename("美工公开课");
            course0.setTeacher("王芳");
            course0.setTime("2019-11-23");
            course0.setBook("《美工基础知识》");
            course0.setIntroduction("主要学习主流图象处理软" +
                    "件Photoshop的图像处理、编辑、通道、图层、路径综合运用；图像色彩的校正；各种特效" +
                    "滤镜的使用；特效字的制作；图像输出与优化等，灵活运用图层风格，流体变形及褪底和蒙板" +
                    "，专业图像处理技巧、图片的修复与合成等。"
            );
            course0.setImageId( R.drawable.course2);
            course0.save();

            Course course1 = new Course();
            course1.setCoursename("人工智能");
            course1.setTeacher("小帅");
            course1.setTime("2019-09-02");
            course1.setBook("《视读人工智能》");
            course1.setIntroduction("人工智能是一门极富挑" +
                    "战性的科学，从事这项工作的人必须懂得计算机知识，心理学和哲学。人工智能是包括十分广" +
                    "泛的科学，它由不同的领域组成，如机器学习，计算机视觉等等，总的说来，人工智能研究" +
                    "的一个主要目标是使机器能够胜任一些通常需要人类智能才能完成的复杂工作。");
            course1.setImageId(R.drawable.artificial);
            course1.save();


            Course course2 = new Course();
            course2.setCoursename("Phython数据分析");
            course2.setTeacher("廖雪峰");
            course2.setTime("2019-02-30");
            course2.setBook("《数据分析》");
            course2.setIntroduction("Python 是一个高层次的结合" +
                    "了解释性、编译性、互动性和面向对象的脚本语言。\n" +
                    "Python 的设计具有很强的可读性，相比其他语言经常使用英文关键字，其他" +
                    "语言的一些标点符号，它具有比其他语言更有特色语法结构。");
            course2.setImageId( R.drawable.coursepic3);
            course2.save();

            Course course3 = new Course();
            course3.setCoursename("室内设计");
            course3.setTeacher("柳家曼");
            course3.setTime("2019-01-02");
            course3.setBook("《室内设计资料图集》");
            course3.setIntroduction("一门根据建筑物的" +
                    "使用性质、所处环境和相应标准，运用物理技术手段和建筑设计原理等理论知识，创" +
                    "造功能合理、舒适优美、满足人们物质和精神生活需要的室内环境的学科。");
            course3.setImageId(R.drawable.housedesign);
            course3.save();

            Course course4 = new Course();
            course4.setCoursename("PHP");
            course4.setTeacher("杨廷琨");
            course4.setTime("2019-12-18");
            course4.setBook("《PHP7内核剖析》");
            course4.setIntroduction("PHP设计模式目的不是" +
                    "为了全面的介绍各种类别的软件设计模式，也不是为了发展一个新的设计模式或者术" +
                    "语，而是为了突出介绍一些已有的著名的设计模式。这本书的独特之处在于介绍了一" +
                    "些对开发动态WEB应用程序很有帮助的设计模式，而且用PHP语言显示了如何实现这些设计模式。");
            course4.setImageId(R.drawable.phpc);
            course4.save();

            Course course5 = new Course();
            course5.setCoursename("大学物理");
            course5.setTeacher("沈君");
            course5.setTime("2019-07-02");
            course5.setBook("《大学物理》");
            course5.setIntroduction("该书涵盖了《理工科类大学物" +
                    "理课程教学基本要求（2010 年版）》中的基本内容，包括力学、热学、电磁学、振动" +
                    "与波动、光学、狭义相对论、量子物理等");
            course5.setImageId(R.drawable.physics);
            course5.save();

        }
        courseList = LitePal.findAll(Course.class);


    }



    private void initRCourse(){

        Course course0 = new Course();
        course0.setCoursename("美工公开课");
        course0.setTeacher("王芳");
        course0.setTime("2019-11-23");
        course0.setBook("《美工基础知识》");
        course0.setIntroduction("主要学习主流图象处理软" +
                "件Photoshop的图像处理、编辑、通道、图层、路径综合运用；图像色彩的校正；各种特效" +
                "滤镜的使用；特效字的制作；图像输出与优化等，灵活运用图层风格，流体变形及褪底和蒙板" +
                "，专业图像处理技巧、图片的修复与合成等。"
        );
        course0.setImageId( R.drawable.course2);
        rcourseList.add(course0);

        Course course1 = new Course();
        course1.setCoursename("人工智能");
        course1.setTeacher("小帅");
        course1.setTime("2019-09-02");
        course1.setBook("《视读人工智能》");
        course1.setIntroduction("人工智能是一门极富挑" +
                "战性的科学，从事这项工作的人必须懂得计算机知识，心理学和哲学。人工智能是包括十分广" +
                "泛的科学，它由不同的领域组成，如机器学习，计算机视觉等等，总的说来，人工智能研究" +
                "的一个主要目标是使机器能够胜任一些通常需要人类智能才能完成的复杂工作。");
        course1.setImageId(R.drawable.artificial);
        rcourseList.add(course1);


        Course course2 = new Course();
        course2.setCoursename("Phython数据分析");
        course2.setTeacher("廖雪峰");
        course2.setTime("2019-02-30");
        course2.setBook("《数据分析》");
        course2.setIntroduction("Python 是一个高层次的结合" +
                "了解释性、编译性、互动性和面向对象的脚本语言。\n" +
                "Python 的设计具有很强的可读性，相比其他语言经常使用英文关键字，其他" +
                "语言的一些标点符号，它具有比其他语言更有特色语法结构。");
        course2.setImageId( R.drawable.coursepic3);
        rcourseList.add(course2);

    }

}


