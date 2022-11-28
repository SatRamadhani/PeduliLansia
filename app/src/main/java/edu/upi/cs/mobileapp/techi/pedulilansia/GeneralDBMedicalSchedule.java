package edu.upi.cs.mobileapp.techi.pedulilansia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class GeneralDBMedicalSchedule
{
    // Class for record.
    public class MedicalSchedule
    {
        private int id;
        private String name;
        private String type;
        private String schedule;
        private String description;

        public MedicalSchedule()
        {
            id = 0; name = ""; type = ""; schedule = ""; description = "";
        }

        public MedicalSchedule(int id, String name, String type, String schedule, String description)
        {
            this.id = id; this.name = name; this.type = type;
            this.schedule = schedule; this.description = description;
        }

        public int getID() { return id; }
        public void setID(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getSchedule() { return schedule; }
        public void setSchedule(String schedule) { this.schedule = schedule; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
    }

    private SQLiteDatabase database;
    private final GeneralOpenHelper helper;

    public GeneralDBMedicalSchedule(Context context)
    {
        helper = new GeneralOpenHelper(context);
    }

    public void open()
    {
        database = helper.getWritableDatabase();
    }

    public long insert(String name, String type, String schedule, String description)
    {
        ContentValues values = new ContentValues();
        values.put("name", name); values.put("type", type);
        values.put("schedule", schedule); values.put("description", description);

        return database.insert("medical_schedule", null, values);
    }

    public ArrayList<MedicalSchedule> getAll()
    {
        Cursor cursor = null;
        ArrayList<MedicalSchedule> schedule = new ArrayList<>();

        cursor = database.rawQuery("SELECT * FROM medical_schedule", null);
        if(cursor.moveToFirst())
        {
            do
            {
                MedicalSchedule temp = new MedicalSchedule();
                temp.setID(cursor.getInt(0));
                temp.setName(cursor.getString(1));
                temp.setType(cursor.getString(2));
                temp.setSchedule(cursor.getString(3));
                temp.setDescription(cursor.getString(4));

                schedule.add(temp);
            } while(cursor.moveToNext());
        }

        cursor.close();
        return schedule;
    }

    public void close()
    {
        database.close();
    }
}
