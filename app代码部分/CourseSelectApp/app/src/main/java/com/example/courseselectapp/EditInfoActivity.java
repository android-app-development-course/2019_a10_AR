package com.example.courseselectapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;

public class EditInfoActivity extends AppCompatActivity {

    TextView idShowTv;
    EditText etTruename;
    EditText etAge;
    EditText etSchool;
    EditText etFaculty;
    EditText etClasses;
    Button backBtn;
    Button saveBtn;
    TheUser theUser;
    String s;
    Person person;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edpersoninfo);

       ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.hide();
        }

        theUser = LitePal.findFirst(TheUser.class);
        s = Integer.toString(theUser.getUserId());
        person = LitePal.where("id=?",s).findFirst(Person.class);


        idShowTv = (TextView) findViewById(R.id.tv_idshow);
        backBtn = (Button) findViewById(R.id.btn_back);
        saveBtn = (Button) findViewById(R.id.btn_save) ;
        etTruename = (EditText) findViewById(R.id.et_truename);
        etAge = (EditText) findViewById(R.id.et_age);
        etSchool = (EditText) findViewById(R.id.et_school);
        etFaculty = (EditText) findViewById(R.id.et_faculty);
        etClasses = (EditText) findViewById(R.id.et_classes);


        //显示个人信息
        idShowTv.setText(person.getName());
        etTruename.setText(person.getTruename());
        etAge.setText(person.getAge());
        etSchool.setText(person.getSchool());
        etFaculty.setText(person.getFaculty());
        etClasses.setText(person.getClasses());


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(EditInfoActivity.this,PesonalActivity.class);
                startActivity(intent1);
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String truename = etTruename.getText().toString();
                String age = etAge.getText().toString();
                String school = etSchool.getText().toString();
                String faculty = etFaculty.getText().toString();
                String classes = etClasses.getText().toString();

                Person person1 =new Person();
                person1.setTruename(truename);
                person1.setAge(age);
                person1.setSchool(school);
                person1.setFaculty(faculty);
                person1.setClasses(classes);
                person1.updateAll("id=?",s);

                Toast.makeText(EditInfoActivity.this,"保存成功！",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
