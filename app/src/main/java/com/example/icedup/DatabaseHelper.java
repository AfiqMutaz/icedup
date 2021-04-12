package com.example.icedup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

//    public final class FeedReaderContract() {
//        private FeedReaderContract() {}
//
//        public class FeedEntry implements BaseColumns {
//            public static final String TABLE_NAME = "items";
//            public static final String COLUMN_ITEM_NAME = "item_name";
//            public static final String COLUMN_ITEM_PRICE = "item_price";
//            public static final String COLUMN_ITEM_DESC = "item_price";
//        }
//    }
//
//    public static final String SQL_CREATE_ENTRIES =
//            "CREATE TABLE " + FeedReaderContract.FeedEntry.TABLE_NAME + " (" +
//                    FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
//                    FeedReaderContract.FeedEntry.COLUMN_ITEM_NAME + " TEXT," +
//                    FeedReaderContract.FeedEntry.COLUMN_ITEM_PRICE + " TEXT," +
//                    FeedReaderContract.FeedEntry.COLUMN_ITEM_DESC + "TEXT)";

    //public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.TABLE_NAME;
    public static final String DATABASE_NAME = "icedup.db";
    public static final String TABLE_NAME = "items";
    public static final String COLUMN1 = "item_name";
    public static final String COLUMN2 = "item_price";
    public static final String COLUMN3 = "item_description";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
        COLUMN1 + " TEXT," +
        COLUMN2 + " TEXT," +
        COLUMN3 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String itemName, String itemPrice, String itemDescription) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN1, itemName);
        contentValues.put(COLUMN2, itemPrice);
        contentValues.put(COLUMN3, itemDescription);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1) { return false; } else { return true; }
    }

    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();

        String[] projection = {
                COLUMN1,
                COLUMN2,
                COLUMN3
        };

        //String selection = col1 + " = ?";
        //String[] selectionArgs = { "My Title" };

        //String sortOrder = ID + " DESC";

        Cursor cursor = db.query(
                TABLE_NAME, //The table to query
                projection, //The array of colums to return
                null, //The columns for the WHERE clause
                null, //The values for the WHERE clause
                null, //Don't group the rows
                null, //Don't filter by row groups
                null //The sort order
        );

        return cursor;
    }
}
