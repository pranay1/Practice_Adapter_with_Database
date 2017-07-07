package com.example.pranay.practice_adapter_with_database;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

EditText title;
    EditText price;
    EditText category;
Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        title  = (EditText)findViewById(R.id.titletext);
        price = (EditText)findViewById(R.id.pricetext);
        category = (EditText)findViewById(R.id.categorytext);
b = (Button)findViewById(R.id.button);


        final String title1 = title.getText().toString();
        final String price1 = price.getText().toString();
            final String category1 = category.getText().toString();



        b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
//int price2 = Integer.parseInt(price1);
        ExpenseOpenHelper expenseOpenHelper = new ExpenseOpenHelper(Main2Activity.this);
        SQLiteDatabase database = expenseOpenHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
      cv.put(ExpenseOpenHelper.EXPENSE_TITLE,title1);
        cv.put(ExpenseOpenHelper.EXPENSE_PRICE,price1);
        cv.put(ExpenseOpenHelper.EXPENSE_CATEGORY,category1);

        database.insert(ExpenseOpenHelper.EXPENSE_TABLE_NAME,null,cv);

        Toast.makeText(Main2Activity.this, "Data saved", Toast.LENGTH_SHORT).show();
//Expense e = new Expense(title1,price2,category1);

    }
});

    }
}
