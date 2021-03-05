package com.example.reycclerviewharry.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.PrecomputedText;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.reycclerviewharry.params.params;

public class MyDbHandler extends SQLiteOpenHelper {
    public MyDbHandler(Context context) {
        super(context, params.DB_NAME, null, params.DB_VERSION);
    }

//    public myDbHandle( Context context) {
//        super(context, params.DB_NAME,null,);
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE "+params.TABLE_NAME+"("+
                params.KEY_ID+" INTEGER PRIMARY KEY,"
                +params.KEY_NAME+" TEXT, "+params.KEY_PHONE+" TEXT"+")";

        Log.d("dbharry","Query being run is : "+create);
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
