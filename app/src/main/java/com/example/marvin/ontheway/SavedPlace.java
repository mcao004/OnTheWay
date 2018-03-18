package com.example.marvin.ontheway;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.MapView;

/**
 * Created by marvin on 3/15/18.
 */

public class SavedPlace extends SavedListAdapter.ViewHolder {
    private TextView placeNameView;
    private TextView descriptionView;
    private ImageView icon;

    public SavedPlace(View itemView) {
        super(itemView);
        placeNameView = (TextView) itemView.findViewById(R.id.textView);
        descriptionView = (TextView) itemView.findViewById(R.id.textView2);
        icon = (ImageView) itemView.findViewById(R.id.imageView7);
    }

    public void bindData(final String[] viewModel) {
        placeNameView.setText(viewModel[0]);
        descriptionView.setText(viewModel[1]);
        switch(viewModel[2]) {
            case "Fast Food":
                icon.setImageResource(R.drawable.fast_food_icon);
                break;
            case "Sit Down":
                icon.setImageResource(R.drawable.sit_down_restuarant_icon);
                break;
            case "Fine Dining":
                icon.setImageResource(R.drawable.fine_dining_icon);
                break;
            case "Bathroom":
                // It's a joke ok
                icon.setImageResource(R.drawable.bathroom_icon);
                break;
            case "Bar":
                icon.setImageResource(R.drawable.bar_icon);
                break;
            case "Cafe":
                icon.setImageResource(R.drawable.coffee_icon);
                break;
            default:
                icon.setImageResource(R.drawable.fast_food_icon);
                break;
        }
        // temporary DELETE LATER
        // icon.setImageResource(R.drawable.fastfoodicon);

    }
}
