package com.example.androidpemuladicoding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Items> mList;
    private OnItemClickListener mListener;

    public Adapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    public void setMovieItems(ArrayList<Items> destinationItems) {
        this.mList = destinationItems;
    }



    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        public ImageView mIV;
        public TextView mTV;


        public CategoryViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mIV = itemView.findViewById(R.id.kotak);
            mTV = itemView.findViewById(R.id.items_title_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public Adapter(ArrayList<Items> exampleList) {
        mList = exampleList;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        return new CategoryViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        Items currentItem = mList.get(position);

//        holder.mIV.setImageResource(currentItem.getImage());
        Glide.with(context).load(currentItem.getImage()).into(holder.mIV);
        holder.mTV.setText(currentItem.getTitle());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
