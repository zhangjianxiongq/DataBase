package com.newer.database;

import android.content.ContentValues;
import android.provider.BaseColumns;

import java.util.Date;

/**
 * Created by 91593 on 2016/6/20.
 */
public class Note implements BaseColumns {


   //表名
    public static  final String TABLE_NAME="notes";
    //字段名
  //  public static  final String _ID="_id";  //主键key 要用下划线表示
    public static  final String _CONTENT="content";
    public static  final String _TIME="time";

    public static  final String SQL_CREATE =String.format(
            "create table %s(_id integer primary key autoincrement, %s text ,%s integer default current_timestamp)",
            TABLE_NAME,
            _CONTENT,
            _TIME);
    public  static  final String SQL_DROP=String.format(
            "drop table if exists %s",
            TABLE_NAME);
    //字段名
    int id ;
    String content;
    long time;

    public Note() {

    }

    public Note(String content) {

        this.content = content;
        time =System.currentTimeMillis();
    }

    /**
     * 返回内容值（表中列和对象的映射）
     * @return
     */
    public ContentValues getValues(){
        ContentValues values = new ContentValues();
        values.put(_CONTENT,content);
        values.put(_TIME,time);
        return  values;
    }
}
