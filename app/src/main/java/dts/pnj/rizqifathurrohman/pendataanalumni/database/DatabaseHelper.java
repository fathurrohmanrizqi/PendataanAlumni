package dts.pnj.rizqifathurrohman.pendataanalumni.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;

    // Table name and column names
    public static final String TABLE_USER = "user";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_NIM = "nim";
    public static final String COLUMN_TMPT = "tempat_lahir";
    public static final String COLUMN_TGL = "tanggal_lahir";
    public static final String COLUMN_DOMISILI = "alamat";
    public static final String COLUMN_TLP = "telepon";
    public static final String COLUMN_THNMSK = "tahun_masuk";
    public static final String COLUMN_THNLLS = "tahun_lulus";
    public static final String COLUMN_JOB = "pekerjaan";
    public static final String COLUMN_JBTN = "jabatan";

    // SQL statement to create the table
    private static final String TABLE_CREATE =
            String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL);",
                    TABLE_USER,
                    COLUMN_ID,
                    COLUMN_NAME,
                    COLUMN_NIM,
                    COLUMN_TMPT,
                    COLUMN_TGL,
                    COLUMN_DOMISILI,
                    COLUMN_TLP,
                    COLUMN_THNMSK,
                    COLUMN_THNLLS,
                    COLUMN_JOB,
                    COLUMN_JBTN);

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Execute the SQL statement to create the table
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the old table and create a new one
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }
}
