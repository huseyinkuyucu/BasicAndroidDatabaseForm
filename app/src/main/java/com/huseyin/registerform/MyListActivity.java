package com.huseyin.registerform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyListActivity extends AppCompatActivity {

    TextView textshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);


        try {
            textshow= (TextView) findViewById(R.id.textShow);

            MyDatabase myDatabase=new MyDatabase(getApplicationContext());
            List<Student> studentList=new ArrayList<>();



            studentList=myDatabase.getStudentData();

            StringBuilder stringBuilder=new StringBuilder();

            for (Student student:studentList) {

                stringBuilder.append(student.getName()  + "\n" + student.getNumber() + "\n" + student.getEmail() + "\n\n");
            }

            textshow.setText(stringBuilder);
        }catch (Exception error){

            Toast.makeText(this, "not found any register", Toast.LENGTH_SHORT).show();
            textshow.setText("not found");
        }
        

    }
}
