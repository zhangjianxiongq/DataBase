package com.newer.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Note note =new Note("内容");

       dbHelper=new DbHelper(this, 1) ;
        dbHelper.getWritableDatabase()
                .insert(Note.TABLE_NAME,null,note.getValues());
    }
    int i =0;
    public void doSave(View view){
        Note note =new Note("内容"+i++);

        //方法1 调用封装语句
        dbHelper.getWritableDatabase()
                .insert(
                        Note.TABLE_NAME,
                        null,
                        note.getValues());
        //直接使用SQL语句
        dbHelper.getWritableDatabase()
                .execSQL(
                        "insert into notes (content,time) values(?,?)",
                        new Object[]{"SQL",System.currentTimeMillis()}
                );

    }
}
