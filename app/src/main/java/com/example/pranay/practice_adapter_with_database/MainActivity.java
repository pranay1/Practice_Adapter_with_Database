package com.example.pranay.practice_adapter_with_database;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    /* ArrayList<String> expenselist;
     ArrayAdapter<String> listadapter;
 */
    ArrayList<Expense> expenselist;

    Expense_Adapter listadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView)findViewById(R.id.listview);
        expenselist = new ArrayList<>();

      /*  for(int i=0;i<20;i++){

            expenselist.add("Expense "+i);

        }
*/

        //listadapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.categorytextview,expenselist);


        //listadapter  = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,expenselist);

        for(int i=0;i<2;i++){

            Expense e = new Expense("Title"+i,100*i,"Category"+i);
            expenselist.add(e);

        }


        listadapter = new Expense_Adapter(this,R.layout.list_item2,expenselist);

        listview.setAdapter(listadapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("title",expenselist.get(position).title);
                startActivity(i);




            }
        });

ExpenseOpenHelper expenseOpenHelper = new ExpenseOpenHelper(this);
      //  expenselist.clear();
        SQLiteDatabase database = expenseOpenHelper.getReadableDatabase();
        Cursor cursor = database.query(ExpenseOpenHelper.EXPENSE_TABLE_NAME,null,null,null,null,null,null);

while(cursor.moveToNext()){

    String title = cursor.getString(cursor.getColumnIndex(ExpenseOpenHelper.EXPENSE_TITLE));
    int price = cursor.getInt(cursor.getColumnIndex(ExpenseOpenHelper.EXPENSE_PRICE));
    String category  = cursor.getString(cursor.getColumnIndex(ExpenseOpenHelper.EXPENSE_CATEGORY));

Expense e = new Expense(title,price,category);
    expenselist.add(e);



}


listadapter.notifyDataSetChanged();


    }



}
