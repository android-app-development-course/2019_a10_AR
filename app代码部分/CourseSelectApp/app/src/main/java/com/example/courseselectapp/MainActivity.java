package com.example.courseselectapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.litepal.LitePal;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button loginBtn;
    Button registerBtn;
    EditText idEt;
    EditText pwdEt;
    Person user = new Person();
    List<Person> personList = LitePal.findAll(Person.class);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }

        LitePal.getDatabase();     //创建数据库
//        LitePal.deleteAll(Person.class);
//        LitePal.deleteAll(SelectC.class);
//        LitePal.deleteAll(Course.class);


        loginBtn = (Button) findViewById(R.id.btn_login);
        registerBtn = (Button) findViewById(R.id.btn_register);
        idEt = (EditText) findViewById(R.id.et_number);
        pwdEt = (EditText) findViewById(R.id.et_password);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setName(idEt.getText().toString());
                user.setPassword(pwdEt.getText().toString());


                if(user.getName().equals("")||user.getPassword().equals("")){

                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("提醒");
                    dialog.setMessage("账号或密码不能为空");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.show();

                }
                else {


                    int k=0;
                    for(Person p : personList){
                        if(user.getName().equals(p.getName())&&user.getPassword().equals(p.getPassword())) {
                            k = 1;
                            user.setId(p.getId());
                            break;
                        }

                    }

                    if(k==0){
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("提醒");
                        dialog.setMessage("账号或密码错误！");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        dialog.show();
                    }
                    else {

                        LitePal.deleteAll(TheUser.class);  //清理当前用户

                        TheUser theUser = new TheUser();    //登记当前用户
                        theUser.setName(user.getName());
                        theUser.setPassword(user.getPassword());
                        theUser.setUserId(user.getId());
                        theUser.save();

                        Intent intent1 = new Intent(MainActivity.this,IndexActivity.class);
                        startActivity(intent1);
                    }

                }
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this,Register.class);
                startActivity(intent2);
            }
        });
    }
}
