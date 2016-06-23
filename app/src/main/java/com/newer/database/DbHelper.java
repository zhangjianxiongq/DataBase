package com.newer.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 91593 on 2016/6/20.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "app.db";

    public DbHelper(Context context, int version) {
        super(context, DB_NAME, null, version);
    }

    /**
     * 初始化表结构
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Note.SQL_CREATE);

    }

    /**
     * 更新表结构
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //删除表结构
        db.execSQL(Note.SQL_DROP);
        //创建
        onCreate(db);
    }



}
