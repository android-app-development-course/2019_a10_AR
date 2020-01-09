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

public class Register extends AppCompatActivity {

    EditText Etid;
    EditText Etpassword;
    Button reg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.hide();
        }



        Etid = (EditText) findViewById(R.id.et_name);
        Etpassword = (EditText) findViewById(R.id.et_password);
        reg = (Button) findViewById(R.id.btn_register);



        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username;
                String password;
                username = Etid.getText().toString();
                password = Etpassword.getText().toString();

                if(username.equals("")||password.equals("")){

                    AlertDialog.Builder dialog = new AlertDialog.Builder(Register.this);
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
                else{

                    int k=0;
                    List<Person> personList = LitePal.findAll(Person.class);

                    for(Person p : personList){
                        if(username.equals(p.getName())){
                            k=1;
                            break;
                        }

                    }

                    if(k==1){
                        AlertDialog.Builder dialog = new AlertDialog.Builder(Register.this);
                        dialog.setTitle("提醒");
                        dialog.setMessage("此用户名已经被占用");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        dialog.show();
                    }
                    else{
                        Person user = new Person();
                        user.setName(username);
                        user.setPassword(password);
                        user.save();
                        Intent intent = new Intent(Register.this,SuRegActivity.class);
                        startActivity(intent);
                    }
                }

            }
        });

    }
}
