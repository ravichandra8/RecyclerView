package com.example.ravichandra.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    private Context mContext;
    private ClickListener clickListener;
    ArrayList<String> values;
    public CustomAdapter(ArrayList<String> values, Context context) {
        this.values = values;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        //initialize the layout
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        //supply the proper values
        viewHolder.names.setText(values.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return values == null ? 0 : values.size();
    }

    public void setClickListener(ClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView names;

        public ViewHolder(View itemView) {
            super(itemView);
            names = (TextView) itemView.findViewById(R.id.textView);

            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d("pos",getAdapterPosition()+"");

//            //remove the list item
//            values.remove(getAdapterPosition());
//            notifyItemRemoved(getAdapterPosition());

           if (clickListener != null) clickListener.itemClicked(view, getAdapterPosition());
        }
    }
    public interface ClickListener
    {
        public void itemClicked(View v,int position);
    }
}