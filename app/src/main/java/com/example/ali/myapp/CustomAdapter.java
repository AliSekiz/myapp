package com.example.ali.myapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView catName;
        public ImageView catImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            catName=(TextView)itemView.findViewById(R.id.catName);
            catImage=(ImageView)itemView.findViewById(R.id.catImage);
        }
    }
    List<CategoryModel>categoryList;
    CustomClick click;
    public CustomAdapter(List<CategoryModel>categoryList,
                         CustomClick click){
        this.categoryList=categoryList;
        this.click=click;
    }
    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.customrow,viewGroup,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.onItemClick(view,viewHolder.getPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.catName.setText(categoryList.get(i).getCatName());
        viewHolder.catImage.setImageResource(categoryList
        .get(i).getPhotoId());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
