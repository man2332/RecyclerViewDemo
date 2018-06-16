package com.example.johnl.recyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//                     extends RecyclerView.Adapter<...ViewHolder>
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    //Create a variable to hold the data within our adapter
    ArrayList<Item> itemList;

    private OnItemClickListener mListener;
    //our custom interface which will need to be implemented in MainActivity
    public interface OnItemClickListener{
        //onItemClick()-used when user clicks on item
        void onItemClick(int position);
        //onRemoveClick()-used when user clicks remove icon
        void onRemoveClick(int position);
    }
    //our custom method-used to set the listener
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public MyAdapter(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    //ViewHolder represents each item in your recycler view
    public static class ViewHolder extends RecyclerView.ViewHolder{
        //Create all the views that are in each item
        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;
        public ImageView deleteImageView;
        //The viewholder constructor gets passed the item layout for each
        //  item in the recycler view
        //  -we need to pass a listener into our ctor because methods in a static class
        //      cannot access fields in it's parent class that is not static
        //      we could of removed static in ViewHolder, but doc recommends otherwise
        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textViewLineOne);
            textView2 = itemView.findViewById(R.id.textViewLineTwo);
            deleteImageView = itemView.findViewById(R.id.deleteView);
            //set what happens when user clicks on a ViewHolder view
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        //listener might be null-if user clicking on a item getting deleted
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
            //set what happens when user clicks on an image icon
            deleteImageView.setOnClickListener(new View.OnClickListener() {
                //View.OnClickListener()-provided by android team to handle clicks on views
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onRemoveClick(position);
                        }
                    }
                }
            });

        }
    }

    //onCreateViewHolder()-called when the recyclerview needs an item created
    //  ViewGroup parent-is the viewgroup which the returned view will be bound to
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //pass the layout of each item to the onCreateViewHolder method
        //-Layoutinflater-instantiates view object by using an xml layout
        //-.inflate(xml layout, rootView, attachToRoot)
        //      provide .inflate() with the xml layout, the root ViewGroup, & should it attach the new view to root view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cardview_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view, mListener);//calls the custom ctor

        return viewHolder;
    }

    //onBindViewHolder()-pass values from our adapter to our views in this method
    //      holder-the ViewHolder which to be updated
    //      position-index of the view in the recycler list
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Set the data we have in our adapter to the ViewHolder
        holder.imageView.setImageResource(itemList.get(position).getmResourceId());
        holder.textView1.setText(itemList.get(position).getmText1());
        holder.textView2.setText(itemList.get(position).getmText2());
    }

    //getItemCount()-is important because the RecyclerView will create as much
    //  list items as this method returns
    @Override
    public int getItemCount() {
        return itemList.size();
    }





}


