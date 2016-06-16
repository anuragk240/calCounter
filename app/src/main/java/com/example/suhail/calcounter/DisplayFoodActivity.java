package com.example.suhail.calcounter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import data.CustomListviewAdapter;
import data.DatabaseHandler;
import model.Food;
import util.Utils;

public class DisplayFoodActivity extends AppCompatActivity {

    private DatabaseHandler dba;
    private ArrayList<Food> dbFood=new ArrayList<>();
    private CustomListviewAdapter foodAdapter;
    private ListView listView;

    private Food myFood;
    private TextView totalCals,totalFoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_food);

        listView=(ListView)findViewById(R.id.list);
        totalCals=(TextView)findViewById(R.id.totalAmountTextView);
        totalFoods=(TextView)findViewById(R.id.totalItemsTextView);

        refreshData();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void refreshData() {

        dbFood.clear();

        dba=new DatabaseHandler(getApplicationContext());

        ArrayList<Food> foodsFromDB=dba.getFoods();

        int calsValue=dba.totalCalories();
        int totalItems=dba.getTotalItems();

        String formattedValues= Utils.formatNumber(calsValue);
        String formattedItems=Utils.formatNumber(totalItems);

        totalCals.setText("Total calories: "+formattedValues);
        totalFoods.setText("Total foods: " + formattedItems);

        for (int i=0;i<foodsFromDB.size();i++){
            String name=foodsFromDB.get(i).getFoodName();
            String dateText=foodsFromDB.get(i).getRecordDate();
            int cals=foodsFromDB.get(i).getCalories();
            int foodId=foodsFromDB.get(i).getFoodId();

            Log.v("Food IDS",String.valueOf(foodId));

            myFood=new Food();
            myFood.setFoodName(name);
            myFood.setRecordDate(dateText);
            myFood.setCalories(cals);
            myFood.setFoodId(foodId);

            dbFood.add(myFood);
        }

        dba.close();

        foodAdapter=new CustomListviewAdapter(DisplayFoodActivity.this,R.layout.list_row,dbFood);
        listView.setAdapter(foodAdapter);
        foodAdapter.notifyDataSetChanged();

    }

}
