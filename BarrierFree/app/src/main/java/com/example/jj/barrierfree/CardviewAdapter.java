package com.example.jj.barrierfree;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by JJ on 2017-03-29.
 */

public class CardviewAdapter extends RecyclerView.Adapter<CardviewAdapter.ViewHolder>
{
    private List<ListItem> listItems;
    private Context context;

    public CardviewAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        public TextView reviewTitle;
        public TextView reviewContent;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            reviewTitle = (TextView)itemView.findViewById(R.id.review_item_title);
            reviewContent = (TextView)itemView.findViewById(R.id.review_item_content);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.review_item_linear);
        }

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //return null;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ListItem listItem = listItems.get(position);

        holder.reviewTitle.setText(listItem.getTitle());
        holder.reviewContent.setText(listItem.getContent());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "클릭"+listItem.getTitle(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

}
