package com.example.sqlitesinhvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "QLSinhVien5.db";
    private  static final String TABLE_NAME_SV = "SinhVien";
    private static final String KEY_MA_SV = "maSV";
    private static final String KEY_TEN_SV = "tenSV";
    private static final String KEY_MO_TA = "moTa";
    private static final String KEY_DIEM = "diem";


    private  static final String TABLE_NAME_LOP = "Lop";
    private static final String KEY_MA_LOP = "maLop";
    private static final String KEY_TEN_LOP = "tenLop";
    private static final String KEY_SI_SO = "siSo";

    public MyDatabase( Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String create_table_lop = String.format("CREATE TABLE %s(%s TEXT PRIMARY KEY, %s TEXT, %s TEXT )",TABLE_NAME_LOP, KEY_MA_LOP, KEY_TEN_LOP, KEY_SI_SO);
        sqLiteDatabase.execSQL(create_table_lop);
        String create_table_SV = String.format("CREATE TABLE %s(%s TEXT PRIMARY KEY, %s TEXT, %s TEXT,%s INTEGER ,%s TEXT)",TABLE_NAME_SV, KEY_MA_SV, KEY_TEN_SV, KEY_MO_TA, KEY_DIEM, KEY_MA_LOP);
        sqLiteDatabase.execSQL(create_table_SV);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String drop_table_lop = String.format("DROP TABLE IF EXITS %s", TABLE_NAME_LOP);
        sqLiteDatabase.execSQL(drop_table_lop);

        String create_table_sinhVien = String.format("DROP TABLE IF EXITS %s", TABLE_NAME_SV);
        sqLiteDatabase.execSQL(create_table_sinhVien);
        onCreate(sqLiteDatabase);
    }



    public void insertSV(SinhVien sinhVien){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MA_SV, sinhVien.getMaSV156());
        values.put(KEY_TEN_SV, sinhVien.getTenSV156());
        values.put(KEY_MO_TA, sinhVien.getMota156());
        values.put(KEY_MA_LOP, sinhVien.getMaLop());

        values.put(KEY_DIEM, sinhVien.getDiem());
        db.insert(TABLE_NAME_SV, null, values);
        db.close();


//        String query = "INSERT INTO SinhVien Values ('sv2', 'cuong', 'mota', 9, 'lop1');";
//        db.execSQL(query, null);
//        db.close();
    }

    public void updateSV(SinhVien sinhVien){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TEN_SV, sinhVien.getTenSV156());
        values.put(KEY_MO_TA, sinhVien.getMota156());
        values.put(KEY_MA_LOP, sinhVien.getMaLop());
        db.update(TABLE_NAME_SV, values, KEY_MA_SV + "=?", new String[]{sinhVien.getMaSV156()});
        db.close();
    }

    public void deleteSV(String maSV){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME_SV, KEY_MA_SV + "=?", new String[] {maSV}); // ep kieu neu khac String
        db.close();
    }

    public List<SinhVien> getSV(Lop lop){
        List<SinhVien> listSinhVien = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM SinhVien WHERE maLop =? ",new String[]{lop.getMalop()}, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false){
            listSinhVien.add(new SinhVien(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4)));
            cursor.moveToNext();
        }
        return listSinhVien;
    }

    public List<SinhVien> readAllSV(){
        List<SinhVien> listSinhVien = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME_SV, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false){
            listSinhVien.add(new SinhVien(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4)));
            cursor.moveToNext();
        }
        return listSinhVien;
    }





    public void insertLop(Lop lop){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MA_LOP, lop.getMalop());
        values.put(KEY_TEN_LOP,lop.getTenLop());
        values.put(KEY_SI_SO, lop.getSiSo());
        db.insert(TABLE_NAME_LOP, null, values);
        db.close();
    }

    public List<Lop> readAllLop(){
        List<Lop> listLop = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME_LOP, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false){
            listLop.add(new Lop(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            cursor.moveToNext();
        }
        return listLop;
    }


}
