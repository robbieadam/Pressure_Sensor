package android.example.sensorpressure;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String SENSOR_TABLE = "SENSOR_TABLE";
    public static final String SENSOR_DATA = "SENSOR_DATA";
    public static final String SENSOR_ID = "ID";
    public static final String SENSOR_ACTIVE = "ACTIVE";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "sensor.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = " CREATE TABLE "+ SENSOR_TABLE + "("+ SENSOR_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ SENSOR_DATA +" TEXT, "+ SENSOR_ACTIVE +" BOOL  )";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean addOne (CustomModel custumModel){

        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(SENSOR_DATA, custumModel.getData());
        cv.put(SENSOR_ACTIVE, custumModel.isActive());

        db.insert(SENSOR_TABLE,null , cv);


        return true;
    }
}
