package com.example.pranay.practice_adapter_with_database;

/**
 * Created by pranay on 7/2/2017.
 */

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by pranay on 6/30/2017.
 */

public class Expense_Adapter extends ArrayAdapter<Expense> {


    Context context;
    int resource;
    ArrayList<Expense> expenselist;

    public Expense_Adapter(@NonNull Context context, @LayoutRes int resource, ArrayList<Expense> expenselist) {
        super(context, resource, expenselist);

        this.context = context;
        this.resource = resource;
        this.expenselist = expenselist;


    }


    @Override
    public int getCount() {
        return expenselist.size();
    }


    public static class Viewholder {

        TextView name;
        TextView category;
        TextView price;
        Button button;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Viewholder viewholder;

        if (convertView == null) {
// inflate layout and store all textviews with their id by findviewbyid function

            convertView = LayoutInflater.from(context).inflate(resource, null);
            viewholder = new Viewholder();
            viewholder.name = (TextView) convertView.findViewById(R.id.titletextview);
            viewholder.price = (TextView) convertView.findViewById(R.id.pricetextview);
            viewholder.category = (TextView) convertView.findViewById(R.id.categorytextview);
            viewholder.button = (Button)convertView.findViewById(R.id.buttontextview);
            convertView.setTag(viewholder);

        } else {
// when convertview!=null

            viewholder = (Viewholder) convertView.getTag();
        }

        //get object whose data is to be saved
        Expense e = expenselist.get(position);


        viewholder.name.setText(e.title);
        viewholder.price.setText(String.valueOf(e.price));
        viewholder.category.setText(e.category);
        viewholder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, position+"Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;


    }


}
