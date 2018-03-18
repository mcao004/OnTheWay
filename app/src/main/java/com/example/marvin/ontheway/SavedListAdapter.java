package com.example.marvin.ontheway;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by marvin on 3/15/18.
 */

public class SavedListAdapter extends RecyclerView.Adapter {
    private String[] mDataset;
    private List<String[]> models;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        //public TextView mTextView;
        public ViewHolder(View v) {
            super(v);
            //mTextView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public SavedListAdapter(List<String[]> m/*String[] myDataset*/) {
        models = m;
        //mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SavedListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
//        TextView v = (TextView) LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.saved_place, parent, false);
//        //...
//        ViewHolder vh = new ViewHolder(v);
//        return vh;
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new SavedPlace(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        ((SavedPlace) holder).bindData(models.get(position));
//        holder.mTextView.setText(mDataset[position]);
//        Toast.makeText(SavedList.this,
//                "Removed",
//                Toast.LENGTH_SHORT)
//                .show();
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.saved_place;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return models.size();
        //return mDataset.length;
    }

}
