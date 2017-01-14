package com.huseyin.registerform;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class MyDatabase extends SQLiteOpenHelper {

    public static final String TABLE_NAME="Student_table";
    public static final String DATABASE_NAME="Student_database";
    public static final int DATABASE_VERSION=1;

    public static final String ID="_id";
    public static final String NAME="name";
    public static final String NUMBER="number";
    public static final String MAIL="email";

    public static final String CREATE_DATABASE="CREATE TABLE " + TABLE_NAME + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NAME + " TEXT NOT NULL,"
            + NUMBER + " TEXT NOT NULL,"
            + MAIL + " TEXT NOT NULL" + ")";

     public static final String DATABASE_DROP="DROP TABLE IF EXISTS" + TABLE_NAME;

    public MyDatabase(Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_DATABASE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w("MyDatabase", "upgrading database from" + oldVersion + "to" + newVersion);
        db.execSQL(DATABASE_DROP);
    }

    public long addData(Student student) {

        SQLiteDatabase db=getWritableDatabase();

        ContentValues cv=new ContentValues();
         cv.put(NAME, student.getName());
         cv.put(NUMBER, student.getNumber());
         cv.put(MAIL, student.getEmail());

         long id=db.insert(TABLE_NAME,null,cv);

         db.close();
         return id;

    }

        public List<Student> getStudentData() {

            SQLiteDatabase db=getReadableDatabase();

            String [] columns=new String[]{NAME, NUMBER, MAIL};

            Cursor cursor=db.query(TABLE_NAME,columns,null,null,null,null,null,null);

            List<Student> studentList=new ArrayList<>();


        for (cursor.moveToFirst(); !cursor.isAfterLast();cursor.moveToNext()){


            Student student=new Student();

            student.setName(cursor.getString(0));
            student.setNumber(cursor.getString(1));
            student.setEmail(cursor.getString(2));

             studentList.add(student);
        }

        db.close();

        return studentList;
    }
}
