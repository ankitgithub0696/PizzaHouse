package com.pizzahouse.pizzahouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<RecyclerviewStructure> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=findViewById(R.id.pizzahouse);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList.add(new RecyclerviewStructure( R.drawable.pizza,"Chees Pizza","Rs.199"));
        arrayList.add(new RecyclerviewStructure( R.drawable.pudding,"Choclate Pudding","Rs.199"));
        arrayList.add(new RecyclerviewStructure( R.drawable.pepsi,"Pepsi","Rs.49"));

        RecyclerviewAdapter recyclerviewAdapter=new RecyclerviewAdapter(arrayList,this);
        recyclerView.setAdapter(recyclerviewAdapter);


    }
}