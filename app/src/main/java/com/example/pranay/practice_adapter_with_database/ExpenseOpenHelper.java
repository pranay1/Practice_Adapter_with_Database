package com.example.pranay.practice_adapter_with_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by pranay on 7/2/2017.
 */

public class ExpenseOpenHelper extends SQLiteOpenHelper {


    public static final String EXPENSE_TABLE_NAME = "Expense";
    public static final String EXPENSE_ID = "_id";
    public static final String EXPENSE_TITLE = "title";
    public static final String EXPENSE_PRICE = "price";
    public static final String EXPENSE_CATEGORY = "category";


    public ExpenseOpenHelper(Context context) {
        super(context, "Expense.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


   String query  = "CREATE TABLE"+" "+EXPENSE_TABLE_NAME+"("+EXPENSE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
           +EXPENSE_TITLE + " TEXT, "
           +EXPENSE_PRICE+" INTEGER, "
           + EXPENSE_CATEGORY+" TEXT"+");";

db.execSQL(query);





    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
