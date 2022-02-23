package com.example.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {// SQLite is a base class that help in doing all the operation of database
    public DbHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create="CREATE TABLE myemployee(sno INTEGER PRIMARY KEY,name TEXT,increment TEXT)";
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop = String.valueOf("DROP TABLE IF EXIST");
        db.execSQL(drop, new String[]{"myemployee"});
        onCreate(db);
    }
    public  void addEmployee(Employee emp){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",emp.getName());
        values.put("increment",emp.getIncrement());
        long k=db.insert("employee",null,values);
        Log.d("mytag",Long.toString(k));
        db.close();

    }
    public void getEmployee(int srno){
      SQLiteDatabase db=this.getReadableDatabase();
      Cursor cursor=db.query("myemployee",new String[]{"srno","name","increment"},
              "srno=?",new String[]{String.valueOf(srno)},null,null,null);

if(cursor !=null && cursor.moveToFirst()){
    Log.e("Mytag",cursor.getString(1));
    Log.e("Mytag",cursor.getString(2));

        }else{
            Log.d("mytag","Some error occured");
        }
    }
}
