package edu.upi.cs.mobileapp.techi.pedulilansia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GeneralOpenHelper extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "techi_pedulilansia.db";

    public static final String TABLE_CREATE_MEDICAL_SCHEDULE = "CREATE TABLE medical_schedule" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, type TEXT, schedule TEXT, " +
            "description TEXT)";

    public GeneralOpenHelper(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        database.execSQL(TABLE_CREATE_MEDICAL_SCHEDULE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i1, int i2)
    {
        database.execSQL("DROP TABLE IF EXISTS medical_schedule");
    }
}
