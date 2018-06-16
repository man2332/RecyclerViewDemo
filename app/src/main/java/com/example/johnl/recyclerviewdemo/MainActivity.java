package com.example.johnl.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

//RECYCLER VIEW & CARDVIEW DEMO
public class MainActivity extends AppCompatActivity {
    //The recyclerview, the adapter for that view,
    private RecyclerView mRecyclerView;
//    private RecyclerView.Adapter mAdapter;
    //Changed RecyclerView.Adapter to our custom adapter-this way we can access our custom methods
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private EditText addET, removeET;
    private Button addBtn, removeBtn;

    private ArrayList<Item> arrayList;

    //Adapter-helps performance-provides only as many views as user is looking at
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createItemList();
        setUpRecyclerView();
        setUpButtons();

    }
    //add an item to the list with the position given & update it in the adapter
    public void addNewItem(int position){
        arrayList.add(position, new Item(R.drawable.ic_android,"New Item", "Position: "+position));
        mAdapter.notifyItemInserted(position);//notifyYtemInserted() adds cool animation
    }
    //remove an item to the list with the position given & update it in the adapter
    public void removeItem(int position){
        arrayList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }
    //change the details of an item
    public void changeItem(int position, String text){
        arrayList.get(position).setmText1(text);
        mAdapter.notifyItemChanged(position);
    }

    private void setUpButtons(){
        addBtn = findViewById(R.id.add_button);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addET = findViewById(R.id.add_editText);
                addNewItem(Integer.parseInt(addET.getText().toString()));
            }
        });

        removeBtn = findViewById(R.id.remove_button);
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeET = findViewById(R.id.remove_editText);
                removeItem(Integer.parseInt(removeET.getText().toString()));
            }
        });
    }

    private void setUpRecyclerView() {
        //get the recycler view in our xml layout
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);//set to true if u know your recycler view won't change in size
        mLayoutManager = new LinearLayoutManager(this);//i dunno
        mAdapter = new MyAdapter(arrayList);//create & give an adapter it's data
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        //call our custom method to implement our OnItemClickListener interface
        mAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //define what happens when an item is clicked
                changeItem(position,"You Clicked this item!");
            }
            //implement abstract method from our custom OnItemClickListener interface
            @Override
            public void onRemoveClick(int position) {
                removeItem(position);
            }
        });
    }

    private void createItemList() {
        //create a list
        arrayList = new ArrayList<>();
        //fill list with fake data
        arrayList.add(new Item(R.drawable.ic_android,"Android", "Super cool"));
        arrayList.add(new Item(R.drawable.ic_attach_money,"Money", "Most cool"));
        arrayList.add(new Item(R.drawable.ic_call,"Call", "Call friend"));
        arrayList.add(new Item(R.drawable.ic_android,"Android", "Super cool"));
    }
}
