package com.example.joker.reminder.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.joker.reminder.model.ModelTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joker on 29.01.16.
 */
public class DBQueryManager {

    private SQLiteDatabase database;

    public DBQueryManager(SQLiteDatabase database) {
        this.database = database;
    }



    public ModelTask getTask(long timeStamp){
        ModelTask modelTask = null;
        Cursor cursor = database.query(DBHelper.TASKS_TABLE, null, DBHelper.SELECTION_TIME_STAMP, new String[]{Long.toString(timeStamp)}, null, null, null);

        if (cursor.moveToNext()){
            String title = cursor.getString(cursor.getColumnIndex(DBHelper.TASK_TITLE_COLUMN));
            long date = cursor.getLong(cursor.getColumnIndex(DBHelper.TASK_DATE_COLUMN));
            int priority = cursor.getInt(cursor.getColumnIndex(DBHelper.TASK_PRIORITY_COLUMN));
            int status = cursor.getInt(cursor.getColumnIndex(DBHelper.TASK_STATUS_COLUMN));

            modelTask = new ModelTask(title, date, priority, status, timeStamp);
        }

        cursor.close();

        return modelTask;
    }



    public List<ModelTask> getTasks(String selection, String[] selectionArgs, String orderBy){
        List<ModelTask> tasks = new ArrayList<>();

        Cursor cursor = database.query(DBHelper.TASKS_TABLE, null, selection, selectionArgs, null, null, orderBy);

        if (cursor.moveToFirst()){
            do {
                String title = cursor.getString(cursor.getColumnIndex(DBHelper.TASK_TITLE_COLUMN));
                long date = cursor.getLong(cursor.getColumnIndex(DBHelper.TASK_DATE_COLUMN));
                int priority = cursor.getInt(cursor.getColumnIndex(DBHelper.TASK_PRIORITY_COLUMN));
                int status = cursor.getInt(cursor.getColumnIndex(DBHelper.TASK_STATUS_COLUMN));
                long timeStamp = cursor.getLong(cursor.getColumnIndex(DBHelper.TASK_TIME_STAMP_COLUMN));

                ModelTask modelTask = new ModelTask(title, date, priority, status, timeStamp);
                tasks.add(modelTask);

            }while (cursor.moveToNext());
        }

        return tasks;
    }
}
