package com.example.ali.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<CategoryModel>categoryList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);

        categoryList=new ArrayList<CategoryModel>();
        categoryList.add(new CategoryModel("Foot",R.drawable.img_1));
        categoryList.add(new CategoryModel("Drink",R.drawable.img_2));
        categoryList.add(new CategoryModel("Snack",R.drawable.img_3));
        categoryList.add(new CategoryModel("Dessert",R.drawable.img_4));

        CustomAdapter adapter=new CustomAdapter(categoryList, new CustomClick() {
            @Override
            public void onItemClick(View v, int position) {
                CategoryModel categoryModel=categoryList.get(position);
                Toast.makeText(getApplicationContext(),categoryModel.getCatName(),
                        Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}
