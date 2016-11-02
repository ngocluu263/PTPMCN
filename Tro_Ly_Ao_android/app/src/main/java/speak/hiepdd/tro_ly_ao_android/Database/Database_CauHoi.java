package speak.hiepdd.tro_ly_ao_android.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import speak.hiepdd.tro_ly_ao_android.Model.CauHoi;

/**
 * Created by hiepdd on 14/09/2016.
 */
public class Database_CauHoi extends SQLiteOpenHelper {
    private static final String DATANAME = "cauhoi.db";
    private static final String TABLE_CAUHOI = "cauhoi";
    private static final String ID = "id";
    private static final String LOAICAUHOI = "loaicauhoi";
    private static final String CAUHOI = "cauhoi";

    public Database_CauHoi(Context context){
        super(context, DATANAME, null, 1);
    }

    // them cau hoi nguoi dung
    public void themCauHoi(CauHoi cauHoi){
        SQLiteDatabase database = this.getWritableDatabase();
        String sql = "INSERT INTO "+TABLE_CAUHOI+" ("+
                LOAICAUHOI+", "+CAUHOI+") VALUES ('"+
                cauHoi.getLoaiCauHoi()+"','"+
                cauHoi.getCauHoi()+"')";
        database.execSQL(sql);
    }

    // Lay danh sach cau hoi du database
    public ArrayList<CauHoi> layDanhSachCauHoi(){
        SQLiteDatabase database = this.getReadableDatabase();
        ArrayList<CauHoi> danhSachCauHoi = new ArrayList<CauHoi>();
        String sql = "SELECT * FROM "+TABLE_CAUHOI;
        Cursor cursor = database.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(cursor.getInt(0));
                cauHoi.setLoaiCauHoi(cursor.getString(1));
                cauHoi.setCauHoi(cursor.getString(2));
                danhSachCauHoi.add(cauHoi);
            }while (cursor.moveToNext());
        }

        database.close();
        return danhSachCauHoi;
    }
    public void xoaToanboDulieu(){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_CAUHOI,null,null);
    }
    // khoi tao database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABLE_CAUHOI+"("+
                ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                LOAICAUHOI+" text,"+
                CAUHOI+" text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CAUHOI);
        onCreate(db);
    }
}
