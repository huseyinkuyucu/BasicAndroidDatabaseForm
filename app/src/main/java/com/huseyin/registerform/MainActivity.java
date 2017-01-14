package com.huseyin.registerform;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText mEditName, mEditNumber, mEditMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Student Information");
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_action));

        mEditName= (EditText) findViewById(R.id.editName);
        mEditNumber= (EditText) findViewById(R.id.editNumber);
        mEditMail= (EditText) findViewById(R.id.editMail);


    }


    public void clickOnButton(View view){


        switch (view.getId()){

            case R.id.buttonSave:

               String mName=mEditName.getText().toString();
               String mNumber=mEditNumber.getText().toString();
               String mEmail=mEditMail.getText().toString();

               if (mName.toString().trim().equals("")){
                   Toast.makeText(this, "please, Enter a name!", Toast.LENGTH_SHORT).show();
               }

               else if (mNumber.toString().trim().equals("")){

                   Toast.makeText(this, "please, Enter a number!", Toast.LENGTH_SHORT).show();
               }


               else if (mEmail.toString().trim().equals("")){

                   Toast.makeText(this, "please, Enter an Email Address!", Toast.LENGTH_SHORT).show();
               }


               else {

                   Student student=new Student(mName,mNumber,mEmail);

                   MyDatabase myDatabase=new MyDatabase(getApplicationContext());

                   long id=myDatabase.addData(student);

                   if (id==-1){

                       Toast.makeText(this, "sorry, somethings went wrong!", Toast.LENGTH_SHORT).show();

                   }
                    else
                       Toast.makeText(this, "Congrats, added new registers", Toast.LENGTH_SHORT).show();

                    mEditName.setText("");
                    mEditNumber.setText("");
                    mEditMail.setText("");

               }
                break;


            case R.id.buttonList:

                Intent intent=new Intent(getApplicationContext(),MyListActivity.class);
                startActivity(intent);
                break;

        }


    }

}
