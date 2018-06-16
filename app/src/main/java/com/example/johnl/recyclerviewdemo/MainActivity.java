package com.example.johnl.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

//RECYCLER VIEW & CARDVIEW DEMO
public class MainActivity extends AppCompatActivity {
    //The recyclerview, the adapter for that view,
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    //=Adapter-helps performance-provides only as many views as user is looking at

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create a list
        ArrayList<Item> arrayList = new ArrayList<>();
        //fill list with fake data
        arrayList.add(new Item(R.drawable.ic_android,"Android", "Super cool"));
        arrayList.add(new Item(R.drawable.ic_attach_money,"Money", "Most cool"));
        arrayList.add(new Item(R.drawable.ic_call,"Call", "Call friend"));
        arrayList.add(new Item(R.drawable.ic_android,"Android", "Super cool"));
        arrayList.add(new Item(R.drawable.ic_attach_money,"Money", "Most cool"));
        arrayList.add(new Item(R.drawable.ic_call,"Call", "Call friend"));
        arrayList.add(new Item(R.drawable.ic_android,"Android", "Super cool"));
        arrayList.add(new Item(R.drawable.ic_attach_money,"Money", "Most cool"));
        arrayList.add(new Item(R.drawable.ic_call,"Call", "Call friend"));
        arrayList.add(new Item(R.drawable.ic_android,"Android", "Super cool"));
        arrayList.add(new Item(R.drawable.ic_attach_money,"Money", "Most cool"));
        arrayList.add(new Item(R.drawable.ic_call,"Call", "Call friend"));
        arrayList.add(new Item(R.drawable.ic_android,"Android", "Super cool"));
        arrayList.add(new Item(R.drawable.ic_attach_money,"Money", "Most cool"));
        arrayList.add(new Item(R.drawable.ic_call,"Call", "Call friend"));
        arrayList.add(new Item(R.drawable.ic_android,"Android", "Super cool"));
        arrayList.add(new Item(R.drawable.ic_attach_money,"Money", "Most cool"));
        arrayList.add(new Item(R.drawable.ic_call,"Call", "Call friend"));


        //get the recycler view in our xml layout
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);//set to true if u know your recycler view won't change in size
        mLayoutManager = new LinearLayoutManager(this);//i dunno
        mAdapter = new MyAdapter(arrayList);//create & give an adapter it's data
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);




    }
}
