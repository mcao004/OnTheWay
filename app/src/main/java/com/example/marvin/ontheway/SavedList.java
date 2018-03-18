package com.example.marvin.ontheway;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SavedList extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    String myDataset[] = { "Mapo Tofu", "Fried Rice", "Fried Tontons", "Chocolate Rabbits"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.saved_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new SavedListAdapter(generateSimpleList());
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.chronologically_sorted:
                Toast.makeText(SavedList.this,
                        "You have clicked on chronological sort",
                        Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.type_sorted:
                Toast.makeText(SavedList.this,
                        "You have clicked on type sort",
                        Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.distance_sorted:
                Toast.makeText(SavedList.this,
                        "You have clicked on distance sort",
                        Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private List<String[]> generateSimpleList() {
        List<String[]> simplePlaceList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            simplePlaceList.add(new String[]{
                    "The Blue Box Cafe at Tiffany & Co.",
                    "Tiffany & Co. 727 Fifth Avenue,New York",
                    "Cafe"
            });
            simplePlaceList.add(new String[]{
                    "Kuma Sushi",
                    "1905 N Campus Ave # C, Upland",
                    "Fine Dining"
            });
            simplePlaceList.add(new String[]{
                    "le Chat Noir",
                    "3790 9th St, Riverside",
                    "Fine Dining"
            });
            simplePlaceList.add(new String[]{
                    "Crystal Cove Shake Shack",
                    "7703 East Coast Hwy, Newport Beach",
                    "Fast Food"
            });
            simplePlaceList.add(new String[]{
                    "Mario's Place",
                    "3646 Mission Inn Avenue, Riverside",
                    "Fine Dining"
            });
            simplePlaceList.add(new String[]{
                    "Din Tai Fung",
                    "3333 Bristol St #2071, Costa Mesa",
                    "Fine Dining"
            });
            simplePlaceList.add(new String[]{
                    "R Burgers Drive-Thru",
                    "1666 University Ave, Riverside",
                    "Fast Food"
            });
            simplePlaceList.add(new String[]{
                    "Nobu Malibu",
                    "22706 Pacific Coast Highway, Malibu",
                    "Fast Food"
            });
            simplePlaceList.add(new String[]{
                    "Seaside Donuts Bakery",
                    "2108 W Oceanfront, Newport Beach",
                    "Fast Food"
            });
            simplePlaceList.add(new String[]{
                    "Danny K's Billiards & Sports Bar",
                    "1096 N Main St, Orange",
                    "Bar"
            });
            simplePlaceList.add(new String[]{
                    "Boiling Point",
                    "3173, 13876 Brookhurst St, Garden Grove",
                    "Sit Down"
            });
            simplePlaceList.add(new String[]{
                    "Pho 79",
                    "9941 W Hazard Ave, Garden Grove",
                    "Sit Down"
            });
            simplePlaceList.add(new String[]{
                    "Sonora Grill",
                    "23962 Alessandro Blvd, Moreno Valley",
                    "Fast Food"
            });
            simplePlaceList.add(new String[]{
                    "Fleming's Prime Steakhouse & Wine Bar",
                    "7905 Monet Ave, Rancho Cucamonga",
                    "Sit Down"
            });
            simplePlaceList.add(new String[]{
                    "Starbucks",
                    "1280 W Blaine St, Riverside",
                    "Cafe"
            });
            simplePlaceList.add(new String[]{
                    "The Sub Station",
                    "3663 Canyon Crest Dr, Riverside",
                    "Sit Down"
            });
            simplePlaceList.add(new String[]{
                    "The Habit",
                    "900 University Ave, Riverside",
                    "Fast Food"
            });
            simplePlaceList.add(new String[]{
                    "Getaway Cafe",
                    "3615 Canyon Crest Dr B, Riverside",
                    "Bar"
            });
            simplePlaceList.add(new String[]{
                    "Loco Burrito",
                    "24170 Sunnymead Blvd, Moreno Valley",
                    "Fast Food"
            });
            simplePlaceList.add(new String[]{
                    "Coffee Bean",
                    "900 University Ave, Riverside",
                    "Cafe"
            });
            simplePlaceList.add(new String[]{
                    "Bathroom on the 8th floor of Chung",
                    "900 University Ave, Riverside",
                    "Bathroom"
            });
            simplePlaceList.add(new String[]{
                    "Rossa's Cucina Enoteca",
                    "425 N Vineyard Ave, Ontario",
                    "Fine Dining"
            });
            simplePlaceList.add(new String[]{
                    "Mcdonalds",
                    "602 Blaine Laine, Riverside",
                    "Fast Food"
            });
        }

        return simplePlaceList;
    }
}
